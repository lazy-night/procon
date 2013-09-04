# -*- coding: utf-8 -*-
require_relative '../lib/solver'

describe Solver, "#minimum_needed" do
  it 'returns 6 when c1=3,c5=2,c10=1,c50=3,c100=0,c500=2,a=620' do
    c1 = 3
    c5 = 2
    c10 = 1
    c50 = 3
    c100 = 0
    c500 = 2
    a = 620

    solver = Solver.new(a, c1, c5, c10, c50, c100, c500)
    solver.minimum_needed.should eq(6)
  end
end
