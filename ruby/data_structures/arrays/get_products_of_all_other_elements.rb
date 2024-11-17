def calculate_products_of_all_other_elements(nums)
  product_of_other_elements = Array.new(nums.count, 1)

  nums.count.times do |i|
    nums.count.times do |j|
      next if i == j

      product_of_other_elements[i] = product_of_other_elements[i] * nums[j]
    end
  end

  product_of_other_elements
end

puts(calculate_products_of_all_other_elements([1, 2, 3]))

def build_prefix_products(nums)
  prefix_products = []

  nums.each do |num|
    prefix_products << if prefix_products.count > 0
                         prefix_products.last * num
                       else
                         num
                       end
  end

  prefix_products
end

def build_suffix_products(nums)
  suffix_products = []

  nums.reverse.each do |num|
    suffix_products << if suffix_products.count > 0
                         suffix_products.last * num
                       else
                         num
                       end
  end

  suffix_products
end

def output(prefix_products, suffix_products, nums)
  result = []

  nums.count.times do |index|
    result << if index == 0
                suffix_products[index + 1]
              elsif index == nums.count - 1
                prefix_products[index - 1]
              else
                (prefix_products[index - 1] * suffix_products[index + 1])
              end
  end

  result
end

def products(nums)
  prefix_products = build_prefix_products(nums)
  suffix_products = build_suffix_products(nums)
  suffix_products = suffix_products.reverse

  output(prefix_products, suffix_products, nums)
end

puts(products([1, 2, 3]))

def products(nums)
  return [] if nums.count < 2

  res = [1]

  (0..(nums.count - 2)).each do |i|
    num = nums[i]
    res << num * res[i]
  end

  product = 1

  (nums.count - 1).downto(1) do |i|
    num = nums[i]
    
    res[i - 1] *= (product * num)
    product *= num
  end

  res
end

puts(products([1, 2, 3]))

