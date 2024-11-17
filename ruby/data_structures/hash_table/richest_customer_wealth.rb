def find_richest_customer_wealth(accounts)
  result_hash = {}
  accounts.each_with_index do |customer, i|
    result_hash[i] = customer.sum
  end

  highest_value = 0
  result_hash.each do |_k, v|
    highest_value = v if v > highest_value
  end

  highest_value
end

puts find_richest_customer_wealth([[1, 2, 3], [3, 2, 1]])

puts find_richest_customer_wealth([[1, 5], [7, 3], [3, 5]])

puts find_richest_customer_wealth([[2, 8, 7], [7, 1, 3], [1, 9, 5]])

