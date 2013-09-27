require_relative '../lib/lake'

describe Lake, '#calc' do
  subject { Lake.new(input).calc }

  context 'with the sample.' do
    let(:input) do
      <<EOF
10 12
W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.
EOF
    end
    it { should eq 3 }
  end

  context 'with an another case' do
    let(:input) do
      <<EOF
10 12
W.W......WW.
.WW...W..WWW
....WW...WW.
...W.....WW.
.....W......
..W......W..
.W.W.WW..WW.
W.W.W.....W.
.W.W......W.
..W.......W.
EOF
    end
    it { should eq 6 }
  end
end
