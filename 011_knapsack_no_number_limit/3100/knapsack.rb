# -*- coding: utf-8 -*-
class Knapsack
  Data = Struct.new 'Data', :weight, :value
  def initialize(n, wv, w)
    @n = n
    @wv = wv.map{|item| Data.new item[0], item[1]}.sort_by{|item| item.weight}
    @w = w
  end

  def calc
    memo = Array.new @w+1, 0
    @wv.each do |data|
      memo = update_memo memo, data
      #puts memo.join "\t"
    end
    memo.max
  end

  private
  def update_memo(memo, data)
    result = memo.dup
    memo.each.with_index do |value, weight|
      result[weight] = calc_max(result, data, value, weight)
    end
    result
  end

  #FIXME
  def calc_max(result, data, value, weight)
    diff = weight % data.weight
    coeff = weight/data.weight
    if diff == 0
      max coeff * data.value, value
    elsif coeff >= 1
      tmp = (0..data.weight).map{|d|
        (coeff-1) * data.value + result[diff+d]
      }.max
      max coeff * data.value + result[diff], tmp, value
    else
      max result[weight - 1], value
    end
  end

  def max(*array)
    array.max
  end
end
