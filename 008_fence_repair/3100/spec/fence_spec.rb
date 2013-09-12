# -*- coding: utf-8 -*-

require_relative './spec_helper'
require_relative '../fence'

describe Fence, '#compute' do
  it 'returns the correct answer for the given example.' do
    input = ~<<-EOS
    3
    8
    5
    8
    EOS
    fence = Fence.new input
    fence.compute.should eq 34
  end

  it 'returns 116 for [5,6,7,8,9,10]' do
    input = ~<<-EOS
    6
    5
    6
    7
    8
    9
    10
    EOS
    fence = Fence.new input
    fence.compute.should eq 116
  end

  it 'returns 155 for [3,4,5,6,7,8,9,10]' do
    input = ~<<-EOS
    8
    3
    4
    5
    6
    7
    8
    9
    10
    EOS
    fence = Fence.new input
    fence.compute.should eq 155
  end

  # validate 'calc'
  it 'returns 51 for [10, 7, 6, 3]' do
    input = ~<<-EOS
    4
    10
    7
    6
    3
    EOS
    fence = Fence.new input
    fence.compute.should eq 51
  end

  it 'returns 36 for [10, 7, 6]' do
    input = ~<<-EOS
    3
    10
    7
    6
    EOS
    fence = Fence.new input
    fence.compute.should eq 36
  end
end
