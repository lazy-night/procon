class Knapsack
  Wv = Struct.new "Wv", :weight, :value

  def initialize(n, wv, w)
    @n = n
    @wvs = wv.map{|elem| Wv.new(elem[0], elem[1])}
    @w = w
  end

  def calc
    # 動的計画法
    row = Array.new(@w+1, 0)
    sorted_wv = sort_by_weight
    sorted_wv.each do |wv|
      row = update_row row, wv
    end
    row.max
  end

  private
  def update_row(row, wv)
    ret = row.dup
    shift = wv.weight
    return row if shift >= @w
    (shift..@w).each do |i|
      tmp =  row[i - shift] + wv.value
      ret[i] = tmp if tmp > row[i]
    end
    ret
  end

  def sort_by_weight
    @wvs.sort_by {|item|
      item.weight
    }
  end
end
