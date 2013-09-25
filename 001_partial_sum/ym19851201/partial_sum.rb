num_array = [1, 2, 4, 50]
k = 54

def plus(array)
  sum = 0
  array.each do |elem|
    sum += elem
  end
  return sum
end

def judge(array, sum)
  array.length.times do |i|
    array.length.times do |j|
      return true if plus(array[i..j]) == sum
    end
  end
  return false
end

print judge(num_array, k)
