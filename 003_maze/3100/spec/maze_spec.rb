# -*- coding: utf-8 -*-
require_relative '../lib/maze'

describe Maze, "#solve" do
  it 'returns the correct value.' do
    input = <<EOF
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
    maze = Maze.new input
    maze.solve.should eq(22)
  end

  it 'returns the correct value.(2)' do
    input = <<EOF
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
    maze = Maze.new input
    maze.solve.should eq(32)
  end
end
