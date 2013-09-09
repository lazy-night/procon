# -*- coding: utf-8 -*-

require_relative '../lib/cow'

describe Cow, '#line_up' do
  it 'returns ' do
    input =<<EOF
6
A
C
D
B
C
B
EOF
    cow = Cow.new(input)
    cow.line_up.should eq('ABCBCD')
  end

  it 'returns ' do
    input =<<EOF
6
A
C
B
B
C
A
EOF
    cow = Cow.new(input)
    cow.line_up.should eq('AACBBC')
  end

  it 'returns ' do
    input =<<EOF
7
A
C
C
D
B
C
A
EOF
    cow = Cow.new(input)
    cow.line_up.should eq('AACBCCD')
  end
end

