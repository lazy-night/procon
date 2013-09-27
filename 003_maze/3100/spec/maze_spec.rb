require_relative '../lib/maze'

describe Maze, "#solve" do
  subject { Maze.new(input).solve }

  context 'with the correct value' do
    let(:input) do
      <<EOF
N=10,M=10

XSXXXXXX.X
......X..X
.X.XX.XX.X
.X........
XX.XX.XXXX
....X....X
.XXXXXXX.X
....X.....
.XXXX.XXX.
....X...GX
EOF
    end
    it { should eq 22 }
  end

  context 'with an another case' do
    let(:input) do
      <<EOF
N=10,M=15

XSXXXXXX.XXXXXX
......X..X....X
.X.XX.XX.XX.X.X
.X..........X.X
XX.XXX.XXXXXX.X
....X....X....X
.XXXXXXX.X.XXX.
....X....X..XX.
.XXXX.XXXXX.X..
....X..XG......
EOF
    end
    it { should eq 32 }
  end
end
