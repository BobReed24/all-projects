def prime_number(number)
  non_prime_flag = if number <= 1
                     true
                   elsif number == 2
                     false
                   elsif number.even?
                     true
                   else
                     (2..Math.sqrt(number)).any? { |i| number % i == 0 }
                   end

  if !non_prime_flag
    puts "The given number 
  else
    puts "The given number 
  end
end

prime_number(1)

prime_number(2)

prime_number(20)

prime_number(-21)
