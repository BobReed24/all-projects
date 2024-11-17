def get_row(row_index)
  (0..row_index).map { |num| combination(row_index, num) }
end

def combination(num1, num2)
  factorial(num1) / (factorial(num2) * factorial(num1 - num2))
end

def factorial(num)
  (1..num).inject(1) { |res, i| res * i }
end

row_index = 3
print(get_row(row_index))

row_index = 0
print(get_row(row_index))

row_index = 1
print(get_row(row_index))

