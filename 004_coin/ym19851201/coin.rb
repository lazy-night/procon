class Reducer
  @@str_array = ["C1", "C5", "C10", "C50", "C100", "C500"]

  def initialize(array, sum)
    @array = array
    @sum = sum
    @counter = 0
    @map = {}
  end

  def exec
    convert
    reduce
    print @counter
  end

  def convert
    @array.each_with_index do |elem, i|
      @map[@@str_array[i]] = elem
    end
  end

  def reduce
    @@str_array.reverse.each do |elem|
      minus(elem, @map[elem])
    end
  end

  def minus(val, num)
    minus_val = val.gsub("C", "").to_i
    eval("
     num.times do |i|
       if @sum - #{minus_val} >= 0
         @sum -= #{minus_val} 
         @counter += 1
       end
     end
         ")
  end
end

reducer = Reducer.new([3,2,1,3,0,2], 620)
reducer.exec
