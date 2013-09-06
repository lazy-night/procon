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
    if first == last
      if (@head - @tail >= @old_line.count)
        send_head
        reset_index
      else
        @head += 1
        @tail -= 1
      end
    elsif first < last
      (@head+1).times do
        send_head
        reset_index
      end
    else # first > last
      (-@tail).times do
        send_tail
        reset_index
      end
    end
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
