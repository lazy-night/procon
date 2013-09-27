require_relative '../lib/cow'

describe Cow, '#line_up' do
  subject { Cow.new(input).line_up }

  context 'with the sample case' do
    let(:input) do
      <<EOF
6
A
C
D
B
C
B
EOF
    end
    it { should eq 'ABCBCD' }
  end

  context 'with an another case' do
    let(:input) do
      <<EOF
6
A
C
B
B
C
A
EOF
    end
    it { should eq 'AACBBC' }
  end

  context 'with a yet another case' do
    let(:input) do
      <<EOF
7
A
C
C
D
B
C
A
EOF
    end
    it { should eq 'AACBCCD' }
  end
end
