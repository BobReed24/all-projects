def max_number(num)
  arr = num.to_s.split('')

  arr.each_with_index do |num, i|
    if num == '6'
      arr[i] = '9'
      return arr.join.to_i
    end
  end
end

puts max_number(9669)

puts max_number(9996)

