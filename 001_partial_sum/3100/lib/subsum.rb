# -*- coding: utf-8 -*-

class Subsum
  def initialize(n, a, k)
    @n = n
    @arr = a
    @k = k
  end

  def judge
    search(@k, @arr)
  end

  private
  def search(purpose, a)
    return purpose = a.first if a.count == 0
    array = a.dup
    car = array.shift
    cdr = array
    return true if car == purpose
    return true if search(purpose - car, cdr)
    search(purpose, cdr)
  end
end
