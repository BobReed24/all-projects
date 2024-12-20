def sort_colors(nums)
  bubble_sort(nums)
end

def bubble_sort(array)
  array_length = array.size
  return array if array_length <= 1

  loop do
    swapped = false

    (array_length - 1).times do |i|
      if array[i] > array[i + 1]
        array[i], array[i + 1] = array[i + 1], array[i]
        swapped = true
      end
    end

    break unless swapped
  end

  array
end

nums = [2, 0, 2, 1, 1, 0]
puts sort_colors(nums)

nums = [2, 0, 1]
puts sort_colors(nums)

nums = [0]
puts sort_colors(nums)

nums = [1]
puts sort_colors(nums)

