class SolverInitializeError < StandardError; end
class CannotSolveError      < StandardError; end

class Solver
  KINDS_OF_COIN = [1, 5, 10, 50, 100, 500]

  Coin = Struct.new('Coin', :amount, :count)

  def initialize(a, *c)
    raise SolverInitializeError unless c.count == KINDS_OF_COIN.count
    @coins = c.map.with_index {|coin_count, i|
      Coin.new(KINDS_OF_COIN[i], coin_count)
    }.reverse! # 金額大きい順にしといた方が便利
    @a = a
  end

  def minimum_needed
    sum = 0
    used_count = 0
    catch :exit do
      @coins.each do |coin|
        coin.count.times do
          candidate = sum + coin.amount
          break if candidate > @a
          sum = candidate
          used_count += 1
          throw :exit if sum == @a
        end
      end
      raise CannotSolveError
    end
    used_count
  end
end
