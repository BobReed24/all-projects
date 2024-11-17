def is_anagram(s, t)
  s_length = s.length
  t_length = t.length
  counter = Hash.new(0)

  return false unless s_length == t_length

  (0...s_length).each do |i|
    counter[s[i]] += 1
    counter[t[i]] -= 1
  end

  counter.each do |_k, v|
    return false unless v == 0
  end

  true
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

def is_anagram(s, t)
  s_length = s.length
  t_length = t.length
  counter = Hash.new(0)

  return false unless s_length == t_length

  (0...s_length).each do |i|
    counter[s[i]] += 1
  end

  (0...s_length).each do |i|
    counter[t[i]] -= 1

    return false if counter[t[i]] < 0
  end

  true
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

def is_anagram(s, t)
  s = s.chars
  t = t.chars

  return false if s.count != t.count

  hash1 = {}
  s.each do |value|
    hash1[value] = if hash1[value]
                     hash1[value] + 1
                   else
                     1
                   end
  end

  hash2 = {}
  t.each do |value|
    hash2[value] = if hash2[value]
                     hash2[value] + 1
                   else
                     1
                   end
  end

  hash1.keys.each do |key|
    return false if hash2[key] != hash1[key]
  end

  true
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

