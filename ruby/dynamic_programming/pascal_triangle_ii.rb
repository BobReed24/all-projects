def get_num(row, col)
  return 1 if row == 0 || col == 0 || row == col

  get_num(row - 1, col - 1) + get_num(row - 1, col)
end

def get_row(row_index)
  result = []

  (row_index + 1).times do |i|
    result.push(get_num(row_index, i))
  end

  result
end

row_index = 3
print(get_row(row_index))

row_index = 0
print(get_row(row_index))

row_index = 1
print(get_row(row_index))

def get_row(row_index)
  result = generate(row_index)
  result[result.count - 1]
end

def generate(num_rows)
  return [[1]] if num_rows < 1

  result = [[1], [1, 1]]

  (2...num_rows + 1).each do |row|
    prev = result[row - 1]
    current = [1]
    med = prev.count / 2

    (1...prev.count).each do |i|
      current[i] = prev[i - 1] + prev[i]
    end

    current.push(1)
    result.push(current)
  end

  result
end

row_index = 3
print(get_row(row_index))

row_index = 0
print(get_row(row_index))

row_index = 1
print(get_row(row_index))

def get_row(row_index)
  pascal = [[1]]

  (1..row_index).each do |i|
    pascal[i] = []
    pascal[i][0] = pascal[i][i] = 1

    (1...i).each do |j|
      pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j]
    end
  end

  pascal[row_index]
end

row_index = 3
print(get_row(row_index))

row_index = 0
print(get_row(row_index))

row_index = 1
print(get_row(row_index))

