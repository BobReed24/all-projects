def fizz_buzz(n, fizz_buzz = { 3 => 'Fizz', 5 => 'Buzz' })
  n.times.map do |i|
    i += 1
    num_str = ''

    fizz_buzz.each do |key, value|
      num_str += value if i % key == 0
    end

    num_str.empty? ? i.to_s : num_str
  end
end

n = 15
puts(fizz_buzz(n))
