require_relative '../lib/subsum'

describe Subsum, "#judge" do
  subject { Subsum.new(n, a, k).judge }

  context 'when n=4, a=[1,2,4,7] and k=13' do
    let(:n) { 4 }
    let(:a) { [1,2,4,7] }
    let(:k) { 13 }
    it { should be_true }
  end

  context 'when n=4, a=[1,2,4,7] and k=15' do
    let(:n) { 4 }
    let(:a) { [1,2,4,7] }
    let(:k) { 15 }
    it { should be_false }
  end
end
