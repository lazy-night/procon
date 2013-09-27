class Solver
  Case = Struct.new('Case', :r, :n, :positions)
  State = Struct.new('State', :unseen, :effected_pos, :stone_count)

  BLANK = ' '

  def initialize(input)
    @input = input
  end

  def run
    generate_member_variables
    res = Array.new
    @cases.each do |c|
      res.push run_a_case(c)
    end
    res.join("\n") + "\n"
  end

  private

  def run_a_case(c)
    # メンバ変数を増やしたくなくて導入したが、クラスのほうが良かったかも。
    state = State.new(Array.new, -1, 0)
    c.positions.each do |pos|
      unless state.unseen.any?
        next if effected? pos, state
        state.unseen.push pos
      end

      limit_pos = state.unseen.first + c.r
      if pos < limit_pos
        state.unseen.push pos
        next
      end

      if pos == limit_pos
        update_state state, c, pos
      else # pos > limit_pos
        update_state state, c, state.unseen.last
        state.unseen.push pos unless effected? pos, state
      end
    end
    state.stone_count += 1 if state.unseen.any?
    state.stone_count
  end

  def effected?(pos, state)
    pos <= state.effected_pos
  end

  def update_state(state, c, pos)
    state.stone_count += 1
    state.effected_pos = pos + c.r
    state.unseen.clear
  end

  def generate_member_variables
    @cases = Array.new
    c = nil
    @input.each_line.with_index do |line, i|
      if i % 2 == 0
        r, n = split_to_i(line)
        break if end?(r, n)
        c = Case.new(r, n, nil)
      else
        # 計算しやすいようにソートしておく
        c.positions = split_to_i(line).sort
        @cases.push c
      end
    end
  end

  def split_to_i(line)
    line.chomp.split(BLANK).map do |ch|
      ch.to_i
    end
  end

  def end?(r, n)
    r == -1 && n == -1
  end
end
