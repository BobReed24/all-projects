def fizz_buzz(n)
  str = []

  n.times do |i|
    i += 1

    if i % 5 == 0 && i % 3 == 0
      str.push('FizzBuzz')
    elsif i % 3 == 0
      str.push('Fizz')
    elsif i % 5 == 0
      str.push('Buzz')
    else
      str.push(i.to_s)
    end
  end

  str
end

n = 15
fizz_buzz(n)

def fizz_buzz(n)
  str = []

  n.times do |i|
    i += 1
    num_str = ''

    num_str += 'Fizz' if i % 3 == 0
    num_str += 'Buzz' if i % 5 == 0

    num_str = i.to_s if num_str == ''

    str.push(num_str)
  end

  str
end

n = 15
puts(fizz_buzz(n))
