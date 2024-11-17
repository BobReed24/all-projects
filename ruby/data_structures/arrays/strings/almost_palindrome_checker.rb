def almost_palindrome_checker(string)
  p1 = 0
  p2 = string.length - 1
  array = string.split('')

  while p1 < p2
    return palindrome_checker(array, p1, p2 - 1) || palindrome_checker(array, p1 + 1, p2) if array[p1] != array[p2]

    p1 += 1
    p2 -= 1
  end

  true
end

def palindrome_checker(array, p1, p2)
  while p1 < p2
    return false if array[p1] != array[p2]

    p1 += 1
    p2 -= 1
  end

  true
end

puts almost_palindrome_checker('aba')

puts almost_palindrome_checker('abca')

puts almost_palindrome_checker('abc')

