# -*- coding: utf-8 -*-
require_relative '../knapsack'

describe Knapsack, "#calc" do
  it 'returns 10 when n=3, (w,v)={(3,4), (4,5), (2,3)}, W=7' do
    n = 3
    wv = [[3,4], [4,5], [2,3]]
    w = 7
    knapsack = Knapsack.new n, wv, w
    expect(knapsack.calc).to eq 10
  end

  it 'returns 20 when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)}, W=10' do
    n = 5
    wv = [[3,2], [4,3], [1,2], [2,3], [3,6]]
    w = 10
    knapsack = Knapsack.new n, wv, w
    expect(knapsack.calc).to eq 20
  end

  it 'returns 16 when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)}, W=8' do
    n = 5
    wv = [[3,2], [4,3], [1,2], [2,3], [3,6]]
    w = 8
    knapsack = Knapsack.new n, wv, w
    expect(knapsack.calc).to eq 16
  end

  it 'returns 4 when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)}, W=2' do
    n = 5
    wv = [[3,2], [4,3], [1,2], [2,3], [3,6]]
    w = 2
    knapsack = Knapsack.new n, wv, w
    expect(knapsack.calc).to eq 4
  end

  it 'returns 21 when n=5, (w,v)={(3,2), (4,7), (1,1), (2,3), (5,9)}, W=12' do
    n = 5
    wv = [[3,2], [4,7], [1,1], [2,3], [5,9]]
    w = 12
    knapsack = Knapsack.new n, wv, w
    expect(knapsack.calc).to eq 21
  end
end
