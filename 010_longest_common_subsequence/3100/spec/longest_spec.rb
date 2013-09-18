# -*- coding: utf-8 -*-
require_relative '../longest'

describe Longest, "#calc" do
  it 'returns 3 when n=4, m=4, s="abcd", t="becd"' do
    n = 4
    m = 4
    s = "abcd"
    t = "becd"
    longest = Longest.new(n, m, s, t)
    expect(longest.calc).to eq(3)
  end

  it 'returns 3 when n=9, m=6, s="abzfbydbf", t="becdfb"' do
    n = 9
    m = 6
    s = "abzfbydbf"
    t = "becdfb"
    longest = Longest.new(n, m, s, t)
    expect(longest.calc).to eq(3)
  end
end
