# -*- coding: utf-8 -*-
require_relative '../knapsack'

describe Knapsack, "#calc" do
  it 'returns 7 when n=4, (w,v) = [(2,3), (1,2), (3,4), (2,2)] and w=5' do
    n = 4
    wv = [[2,3],[1,2],[3,4],[2,2]]
    w = 5
    knapsack = Knapsack.new(n, wv, w)
    expect(knapsack.calc).to eq(7)
  end

  it 'returns 7 when n=5, (w,v) = [(5,6), (2,3), (1,2), (3,4), (2,2)] and w=5' do
    n = 5
    wv = [[5,6],[2,3],[1,2],[3,4],[2,2]]
    w = 5
    knapsack = Knapsack.new(n, wv, w)
    expect(knapsack.calc).to eq(7)
  end

  it 'returns 65 when n=5, (w,v) = [(35,30), (35,35), (40,60), (40,30), (40,50)] and w=70' do
    n = 5
    wv = [[35,30],[35,35],[40,60],[40,30],[40,50]]
    w = 70
    knapsack = Knapsack.new(n, wv, w)
    expect(knapsack.calc).to eq(65)
  end
end
