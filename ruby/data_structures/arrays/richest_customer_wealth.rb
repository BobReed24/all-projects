def find_richest_customer_wealth(accounts)
  summed_accounts = []
  accounts.each do |customer|
    summed = 0
    customer.each do |account|
      summed += account
    end
    summed_accounts.push(summed)
  end

  summed_accounts.sort.pop
end

puts find_richest_customer_wealth([[1, 2, 3], [3, 2, 1]])

puts find_richest_customer_wealth([[1, 5], [7, 3], [3, 5]])

puts find_richest_customer_wealth([[2, 8, 7], [7, 1, 3], [1, 9, 5]])

