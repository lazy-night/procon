require_relative './spec_helper'
require_relative '../solver'

describe Solver, "#run" do
  subject { Solver.new(input).run }

  context 'with the sample case' do
    let(:input) do
      ~<<-EOS1
      0 3
      10 20 20
      10 7
      70 30 2 7 15 20 50
      -1 -1
      EOS1
    end
    let(:expected) do
      ~<<-EOS2
      2
      4
      EOS2
    end
    it { should eq expected }
  end

  context 'with an another case' do
    let(:input) do
      ~<<-EOS1
      4 10
      1 10 5 6 9 13 9 30 20 40
      4 8
      1 10 5 6 9 13 9 17
      9 10
      70 30 1 7 15 20 50 22 19 18
      10 3
      45 58 44
      -1 -1
      EOS1
    end
    let(:expected) do
      ~<<-EOS2
      5
      2
      4
      2
      EOS2
    end
    it { should eq expected }
  end
end
