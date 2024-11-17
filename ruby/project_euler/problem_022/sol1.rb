file_contents = File.read('p022_names.txt')

words = file_contents.tr('\"', '').split(',').sort

def word_worth(word)
  word.chars.sum { |char| char.ord - 'A'.ord + 1 }
end

def total_rank(words)
  result = 0
  words.each_with_index { |word, index| result += word_worth(word) * (index + 1) }
  result
end

puts total_rank(words)
