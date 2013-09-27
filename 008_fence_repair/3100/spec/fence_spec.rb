require_relative './spec_helper'
require_relative '../fence'

describe Fence, "#compute" do
  subject { Fence.new(input).compute }

  context 'with the given example' do
    let(:input) do
      ~<<-EOS
      3
      8
      5
      8
      EOS
    end
    it { should eq 34 }
  end

  context 'with [5,6,7,8,9,10] as the input' do
    let(:input) do
      ~<<-EOS
      6
      5
      6
      7
      8
      9
      10
      EOS
    end
    it { should eq 116 }
  end

  context 'with [3,4,5,6,7,8,9,10] as the input' do
    let(:input) do
      ~<<-EOS
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
    end
    it { should eq 153 }
  end

  # validate 'calc'
  context 'with [10, 7, 6, 3] as the input' do
    let(:input) do
      ~<<-EOS
      4
      10
      7
      6
      3
      EOS
    end
    it { should eq 51 }
  end

  context 'with [10, 7, 6] as the input' do
    let(:input) do
      ~<<-EOS
      3
      10
      7
      6
      EOS
    end
    it { should eq 36 }
  end
end
