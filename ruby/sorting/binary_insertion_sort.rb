def binary_search(arr, val, start, stop)
  while start <= stop

    mid = (start + stop) / 2

    if val == arr[mid] 
      return mid
    elsif val > arr[mid] 
      start = mid + 1
    else
      stop = mid - 1 
    end
  end

  start
end

def binary_insertion_sort(arr)
  n = arr.size

  (0...n).each do |index|
    j = index - 1
    selected = arr[index]

    location = binary_search(arr, selected, 0, j)

    while j >= location
      arr[j + 1] = arr[j]
      j -= 1
      arr[j + 1] = selected
    end
  end

  arr
end

if $0 == __FILE__
  puts 'Enter a list of numbers separated by space'

  list = gets.split.map(&:to_i)
  p binary_insertion_sort(list)
end