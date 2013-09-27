require 'thread'

class Maze
  GOAL   = 'G'
  START  = 'S'
  ROUTE  = '.'
  WALL   = 'W'

  Point = Struct.new('Point', :x, :y, :distance)

  def initialize(input)
    @input = input
    # 幅優先探索用
    @queue = Queue.new
  end

  def solve
    generate_member_vals
    @queue.push @start
    until @queue.empty?
      p = @queue.pop
      return p.distance+1 if search(p)
    end
  end

  private
  def search(point)
    distance = point.distance + 1
    [
      Point.new(point.x,   point.y-1, distance),
      Point.new(point.x,   point.y+1, distance),
      Point.new(point.x-1, point.y,   distance),
      Point.new(point.x+1, point.y,   distance)
    ].each do |p|
      return true if search_and_push p
    end

    # 何度も探索しないように壁に変更してやる
    @map[point.y][point.x] = WALL
    false
  end

  def generate_member_vals
    array = @input.each_line.map {|line| line.chomp }
    h = Hash[*(array.shift.split(/[,=]/))]
    @x = h['M'].to_i
    @y = h['N'].to_i
    # 空白行を取り除く
    array.shift
    @map = array.map.with_index do |line, y|
      @start ||= decide_point(line, START, y)
      @end   ||= decide_point(line, GOAL , y)
      line.chars.to_a
    end
  end

  def search_and_push(point)
    return true if goal?(point)
    @queue.push point if route?(point)
    false
  end

  def goal?(point)
    return false unless valid?(point)
    @map[point.y][point.x] == GOAL
  end

  def route?(point)
    return false unless valid?(point)
    @map[point.y][point.x] == ROUTE
  end

  def valid?(point)
    point.x >= 0 && point.x < @x &&
    point.y >= 0 && point.y < @y
  end

  def decide_point(line, char, y)
    x = line.index(char)
    Point.new(x, y, 0) if x
  end
end
