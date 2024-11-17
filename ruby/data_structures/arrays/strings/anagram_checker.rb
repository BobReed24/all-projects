def is_anagram(s, t)
  return false if s.length != t.length

  arr1 = s.split('').sort
  arr2 = t.split('').sort

  arr1 == arr2
end

s = 'anagram'
t = 'nagaram'
puts(is_anagram(s, t))

s = 'rat'
t = 'car'
puts(is_anagram(s, t))

s = 'a'
t = 'ab'
puts(is_anagram(s, t))

