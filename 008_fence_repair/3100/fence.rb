# -*- coding: utf-8 -*-
class Fence
  def initialize(input)
    lines = input.lines.to_a
    @n = lines.shift
    @parts = lines.map{|l| l.chomp.to_i}
  end

  def compute
    parts = @parts.sort.reverse # 降順
    calc parts
  end

  def calc(array)
    if array.count > 4
      a, b = split array
      return sum(array) + calc(a) + calc(b)
    end

    ret = 0
    while array.count > 1
      ret += sum array
      array.shift
    end
    ret
  end

  def sum(array)
    array.inject(0){|ret, item| ret += item}
  end

  def split(array)
    a = Array.new
    b = Array.new
    is_a = [true, false, false, true]
    array.each.with_index do |item, i|
      if is_a[i % 4]
        a.push item
      else
        b.push item
      end
    end
    [a, b]
  end
end
