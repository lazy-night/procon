require_relative '../lib/solver'

describe Solver, "#minimum_needed" do
  subject { Solver.new(a, c1, c5, c10, c50, c100, c500).minimum_needed }

  context 'when c1=3,c5=2,c10=1,c50=3,c100=0,c500=2 and a=620' do
    let(:c1)   { 3 }
    let(:c5)   { 2 }
    let(:c10)  { 1 }
    let(:c50)  { 3 }
    let(:c100) { 0 }
    let(:c500) { 2 }
    let(:a)    { 620 }
    it { should eq 6 }
  end
end
