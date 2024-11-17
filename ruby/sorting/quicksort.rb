def quicksort(arr)
  return [] if arr.empty?

  pivot = arr.delete_at(rand(arr.size))
  
  left, right = arr.partition(&pivot.method(:>))

  [*quicksort(left), pivot, *quicksort(right)]
end

if $0 == __FILE__
  puts 'Enter a list of numbers separated by space'

  list = gets.split.map(&:to_i)
  p quicksort(list)
end
