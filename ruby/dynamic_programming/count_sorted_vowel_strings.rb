def count_vowel_strings(n, letter = 'a')
  return 1 if n < 1

  @h ||= {}
  key = [n, letter]
  return @h[key] if @h[key]

  result = case letter
           when 'a'
             count_vowel_strings(n - 1, letter = 'a') +
             count_vowel_strings(n - 1, letter = 'e') +
             count_vowel_strings(n - 1, letter = 'i') +
             count_vowel_strings(n - 1, letter = 'o') +
             count_vowel_strings(n - 1, letter = 'u')
           when 'e'
             count_vowel_strings(n - 1, letter = 'e') +
             count_vowel_strings(n - 1, letter = 'i') +
             count_vowel_strings(n - 1, letter = 'o') +
             count_vowel_strings(n - 1, letter = 'u')
           when 'i'
             count_vowel_strings(n - 1, letter = 'i') +
             count_vowel_strings(n - 1, letter = 'o') +
             count_vowel_strings(n - 1, letter = 'u')
           when 'o'
             count_vowel_strings(n - 1, letter = 'o') +
             count_vowel_strings(n - 1, letter = 'u')
           when 'u'
             count_vowel_strings(n - 1, letter = 'u')
           end

  @h[key] = result
  @h[key]
end

n = 33
puts count_vowel_strings(n)

n = 2
puts count_vowel_strings(n)

n = 1
puts count_vowel_strings(n)

