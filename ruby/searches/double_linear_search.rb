def double_linear_search(array, search_item)
  start_ind = 0
  end_ind = array.length - 1

  while start_ind <= end_ind
    return start_ind if array[start_ind] == search_item
    return end_ind if array[end_ind] == search_item

    start_ind += 1
    end_ind -= 1
  end

  -1
end

puts(double_linear_search([1, 5, 5, 10], 1))

puts(double_linear_search([1, 5, 5, 10], 5))

puts(double_linear_search([1, 5, 5, 10], 100))

puts(double_linear_search([1, 5, 5, 10], 10))

