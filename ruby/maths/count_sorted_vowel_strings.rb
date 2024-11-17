def count_vowel_strings(n)
  (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24
end

n = 33
puts count_vowel_strings(n)

n = 2
puts count_vowel_strings(n)

n = 1
puts count_vowel_strings(n)

