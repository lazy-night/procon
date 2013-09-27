require_relative '../longest'

describe Longest, "#calc" do
  subject { Longest.new(n, m, s, t).calc }

  context 'when n=4, m=4, s="abcd" and t="becd"' do
    let(:n) { 4 }
    let(:m) { 4 }
    let(:s) { "abcd" }
    let(:t) { "becd" }
    it { should eq 3 }
  end

  context 'when n=9, m=6, s="abzfbydbf" and t="becdfb"' do
    let(:n) { 9 }
    let(:m) { 6 }
    let(:s) { "abzfbydbf" }
    let(:t) { "becdfb" }
    it { should eq 3 }
  end
end
