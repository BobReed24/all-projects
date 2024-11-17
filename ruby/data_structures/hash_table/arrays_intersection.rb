def arrays_intersection(arr1, arr2, arr3)
  hash = Hash.new(0)

  add_to_hash(arr1, hash)
  add_to_hash(arr2, hash)
  add_to_hash(arr3, hash)

  hash.select { |_key, value| value == 3 }.keys
end

def add_to_hash(arr, hash)
  arr.count.times do |pointer|
    value = arr[pointer]
    hash[value] += 1
  end
end

arr1 = [1, 2, 3, 4, 5]
arr2 = [1, 2, 5, 7, 9]
arr3 = [1, 3, 4, 5, 8]
print arrays_intersection(arr1, arr2, arr3)

arr1 = [197, 418, 523, 876, 1356]
arr2 = [501, 880, 1593, 1710, 1870]
arr3 = [521, 682, 1337, 1395, 1764]
print arrays_intersection(arr1, arr2, arr3)

