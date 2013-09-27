require_relative '../lib/scheduling'

describe Scheduling, "#calc" do
  subject { Scheduling.new(n, s, t).calc }

  context 'when n=5, s=[1,2,4,6,8] and t=[3,5,7,9,10]' do
    let(:n) { 5 }
    let(:s) { [1,2,4,6, 8] }
    let(:t) { [3,5,7,9,10] }
    it { should eq 3 }
  end

  context 'when n=7, s=[1,1,2,4,6,8] and t=[10,3,5,7,9,10]' do
    let(:n) { 6 }
    let(:s) { [1, 1,2,4,6, 8] }
    let(:t) { [10,3,5,7,9,10] }
    it { should eq 3 }
  end

  context 'when n=7, s=[1,1,2,4,6,8,2,4,8,9,1,5] and t=[10,3,5,7,9,10,3,5,10,2,8]' do
    let(:s) { [1, 1,2,4,6, 8,2,4, 9,1,3,5] }
    let(:t) { [10,3,5,7,9,10,3,5,10,2,4,8] }
    let(:n) { s.count }
    it { should eq 4 }
  end
end
