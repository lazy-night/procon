# -*- coding: utf-8 -*-
class Lake
  WATER = 'W'

  def initialize(input)
    @input = input
  end

  def calc
    generate_member_vals
    res = 0
    (0...@y).each do |y|
      (0...@x).each do |x|
        if search_and_mark(x, y)
          res += 1
        end
      end
    end
    res
  end

  private
  def search_and_mark(x, y)
    return false unless new_water?(x,y)
    @checked[y][x] = true
    search_and_mark(x-1, y-1)
    search_and_mark(x  , y-1)
    search_and_mark(x+1, y-1)
    search_and_mark(x-1, y  )
    search_and_mark(x+1, y  )
    search_and_mark(x-1, y+1)
    search_and_mark(x  , y+1)
    search_and_mark(x+1, y+1)
    true
  end

  def new_water?(x, y)
    return false if x < 0 || x >= @x
    return false if y < 0 || y >= @y
    !@checked[y][x] && @map[y][x] == WATER
  end

  def generate_member_vals
    array = @input.each_line.map {|line| line.chomp }
    @y, @x = array.shift.split(' ').map{|v| v.to_i}
    @map = array.map do |s|
      s.chars.to_a
    end
    # 走査済みかどうか
    @checked = Array.new(@y).map{Array.new(@x, false)}
  end
end
