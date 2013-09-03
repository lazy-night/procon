# -*- coding: utf-8 -*-
require_relative '../lib/lake'

describe Lake, '#calc' do
  it 'returns the correct value.' do
    input = <<EOF
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
    lake = Lake.new input
    lake.calc.should eq(3)
  end

  it 'returns the correct value.(2)' do
    input = <<EOF
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
    lake = Lake.new input
    lake.calc.should eq(6)
  end
end
