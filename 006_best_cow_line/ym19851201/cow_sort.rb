def sort_array(array, new_array)
  if array.length == 1
    new_array << array[0]
    return
  end
  
  index = head_or_tail?(array)
  new_array << array[index]
  array.delete_at(index)

  sort_array(array, new_array)
end

def head_or_tail?(array)
  if array.length == 0 || array[0] < array[-1] 
    return 0
  elsif array[0] > array[-1]
    return -1
  else
    head_or_tail?(array[1..-2])
  end
end

array = ["A", "C", "B", "B", "C", "A"]
new_array = []
sort_array(array, new_array)
p new_array

