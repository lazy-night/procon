# -*- coding: utf-8 -*-
class Fence
  def initialize(input)
    lines = input.lines.to_a
    @n = lines.shift.to_i
    @parts = lines.map{|l| l.chomp.to_i}
  end

  def compute
    sorted_parts = @parts.sort
    calc sorted_parts
  end

  private
  def calc(sorted)
    # ナイーブな実装
    (@n-1).times.inject(0) do |ret, i|
      combined = sorted.shift + sorted.shift
      sorted.push(combined).sort!
      ret += combined
    end
  end
end
