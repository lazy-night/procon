class Longest
  StringData = Struct.new "StringData", :string, :n
  def initialize(n, m, s, t)
    @string1 = StringData.new s, n
    @string2 = StringData.new t, m
  end

  def calc
    # 動的計画法用
    cache = Array.new(@string1.n + 1, 0)
    (0...@string2.n).each do |string2_index|
      cache = update_line string2_index, cache
    end
    cache.max
  end

  private
  # string2の1文字を用いてstring1内の走査する
  def update_line(string2_index, cache)
    result = cache.dup
    char2 = @string2.string[string2_index]
    @string1.string.each_char.with_index(1) do |char1, cache_index|
      if char2 == char1
        # 表でいうと斜め左上に1加える
        result[cache_index] = cache[cache_index - 1] + 1
      else
        # 表でいうと左か上の大きい方
        result[cache_index] = max result[cache_index - 1], cache[cache_index]
      end
    end
    result
  end

  def max(int1, int2)
    [int1, int2].max
  end
end
