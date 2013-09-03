# -*- coding: utf-8 -*-

require_relative '../lib/subsum'

describe Subsum do
  it 'returns true when n=4, a=[1,2,4,7], k=13' do
    n = 4
    a = [1,2,4,7]
    k = 13
    subsum = Subsum.new n, a, k
    subsum.judge.should be_true
  end

  it 'returns false when n=4, a=[1,2,4,7], k=15' do
    n = 4
    a = [1,2,4,7]
    k = 15
    subsum = Subsum.new n, a, k
    subsum.judge.should be_false
  end

#  it 'returns false when n=4, a=[100, 200, 7,4,2,1, 300, 400, 500], k=15' do
#    n = 4
#    a = [1,2,4,7]
#    k = 15
#    subsum = Subsum.new n, a, k
#    subsum.judge.should be_false
#  end
end
