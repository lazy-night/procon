require_relative '../knapsack'

describe Knapsack, "#calc" do
  subject { Knapsack.new(n, wv, w).calc }

  context 'when n=3, (w,v)={(3,4), (4,5), (2,3)} and W=7' do
    let(:n)  { 3 }
    let(:wv) { [[3,4], [4,5], [2,3]] }
    let(:w)  { 7 }
    it { should eq 10 }
  end

  context 'when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)} and W=10' do
    let(:n)  { 5 }
    let(:wv) { [[3,2], [4,3], [1,2], [2,3], [3,6]] }
    let(:w)  { 10 }
    it { should eq 20 }
  end

  context 'when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)} and W=8' do
    let(:n)  { 5 }
    let(:wv) { [[3,2], [4,3], [1,2], [2,3], [3,6]] }
    let(:w)  { 8 }
    it { should eq 16 }
  end

  context 'when n=5, (w,v)={(3,2), (4,3), (1,2), (2,3), (3,6)} and W=2' do
    let(:n)  { 5 }
    let(:wv) { [[3,2], [4,3], [1,2], [2,3], [3,6]] }
    let(:w)  { 2 }
    it { should eq 4 }
  end

  context 'when n=5, (w,v)={(3,2), (4,7), (1,1), (2,3), (5,9)} and W=12' do
    let(:n)  { 5 }
    let(:wv) { [[3,2], [4,7], [1,1], [2,3], [5,9]] }
    let(:w)  { 12 }
    it { should eq 21 }
  end
end
