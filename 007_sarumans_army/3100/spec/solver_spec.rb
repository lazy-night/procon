# -*- coding: utf-8 -*-

require_relative './spec_helper'
require_relative '../solver'

describe Solver, "#solve" do
  it 'returns a correct answer in the sample case' do
    input, expected = ~<<-EOS1, ~<<-EOS2
    0 3
    10 20 20
    10 7
    70 30 1 7 15 20 50
    -1 -1
    EOS1
    2
    4
    EOS2

    solver = Solver.new input
    solver.run.should eq expected
  end

  it 'returns a correct answer in an another case' do
    input, expected = ~<<-EOS1, ~<<-EOS2
    4 10
    1 10 5 6 9 13 9 30 20 40
    4 8
    1 10 5 6 9 13 9 17
    9 10
    70 30 1 7 15 20 50 22 19 18
    -1 -1
    EOS1
    5
    2
    4
    EOS2

    solver = Solver.new input
    solver.run.should eq expected
  end
end
