def find_uncommon_words(strA, strB)
  array = strA.concat(' ', strB).split(' ')
  hash = Hash.new(0)
  result = []

  array.each do |word|
    hash[word] += 1
  end

  hash.each do |k, v|
    result.push(k) if v < 2
  end

  result
end

puts find_uncommon_words('this apple is sweet', 'this apple is sour')

puts find_uncommon_words('apple apple', 'banana')

