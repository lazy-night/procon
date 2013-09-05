# -*- coding: utf-8 -*-
require_relative '../lib/scheduling'

describe Scheduling, "#calc" do
  it 'returns 3 when n=5, s=[1,2,4,6,8], t=[3,5,7,9,10]' do
    n = 5
    s = [1,2,4,6, 8]
    t = [3,5,7,9,10]
    scheduling = Scheduling.new n, s, t
    scheduling.calc.should eq(3)
  end

  it 'returns 4 when n=7, s=[1,1,2,4,6,8], t=[10,3,5,7,9,10]' do
    n = 6
    s = [1, 1,2,4,6, 8]
    t = [10,3,5,7,9,10]
    scheduling = Scheduling.new n, s, t
    scheduling.calc.should eq(3)
  end

  it 'returns 4 when n=7, s=[1,1,2,4,6,8,2,4,8,9,1,5] t=[10,3,5,7,9,10,3,5,10,2,8]' do
    #                       X X X X
    s = [1, 1,2,4,6, 8,2,4, 9,1,3,5]
    t = [10,3,5,7,9,10,3,5,10,2,4,8]
    n = s.count
    scheduling = Scheduling.new n, s, t
    scheduling.calc.should eq(4)
  end
end
