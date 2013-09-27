require_relative '../knapsack'

describe Knapsack, "#calc" do
  subject { Knapsack.new(n, wv, w).calc }

  context 'when n=4, (w,v) = [(2,3), (1,2), (3,4), (2,2)] and w=5' do
    let(:n)  { 4 }
    let(:wv) { [[2,3],[1,2],[3,4],[2,2]] }
    let(:w)  { 5 }
    it { should eq 7 }
  end

  context 'when n=5, (w,v) = [(5,6), (2,3), (1,2), (3,4), (2,2)] and w=5' do
    let(:n)  { 5 }
    let(:wv) { [[5,6],[2,3],[1,2],[3,4],[2,2]] }
    let(:w)  { 5 }
    it { should eq 7 }
  end

  context 'when n=5, (w,v) = [(35,30), (35,35), (40,60), (40,30), (40,50)] and w=70' do
    let(:n)  { 5 }
    let(:wv) { [[35,30],[35,35],[40,60],[40,30],[40,50]] }
    let(:w)  { 70 }
    it { should eq 65 }
  end
end
