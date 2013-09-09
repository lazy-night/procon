# -*- coding: utf-8 -*-

class Cow
  def initialize(input)
    @input = input
    @new_line = Array.new
  end

  def line_up
    generate_member_valiables
    send
    @new_line.join
  end

  private
  def send
    reset_index
    while @old_line.any?
      first = @old_line[@head]
      last =  @old_line[@tail]
      send_some(first, last)
    end
  end

  # なんかうまく書けなかった
  def send_some(first, last)
    if first < last || force_send_needed?(first, last)
      send_head
      reset_index
      return
    elsif first > last
      send_tail
      reset_index
      return
    end

    # first == last && !head_eq_tail?
    @head += 1
    @tail -= 1
  end

  # メソッド化してわかりにくくなってないか？
  def force_send_needed?(first, last)
    first == last && head_eq_tail?
  end

  def head_eq_tail?
    @head - @tail >= @old_line.count
  end

  def send_head
    @new_line.push @old_line.shift
  end

  def send_tail
    @new_line.push @old_line.pop
  end

  def reset_index
    @head = 0
    @tail = -1
  end

  def generate_member_valiables
    array = @input.each_line.to_a
    @n = array.shift
    @old_line = array.map{|a| a.chomp}
  end
end
