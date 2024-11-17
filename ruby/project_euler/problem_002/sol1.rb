even_fib_sum = 0
fib_first = 1
fib_second = 2

while fib_second < 4_000_000
  even_fib_sum += fib_second if fib_second.even?
  fib_second += fib_first
  fib_first = fib_second - fib_first
end

p even_fib_sum
