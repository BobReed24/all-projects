require_relative '../data_structures/heaps/max_heap'

class WordCount
  include Comparable

  attr_reader :word
  attr_reader :occurrences

  def <=>(other)
    occurrences <=> other.occurrences
  end

  def initialize(word, occurrences)
    @word = word
    @occurrences = occurrences
  end
end

def max_k_most_frequent_words(words, k)
  count_by_word = words.tally
  heap = MaxHeap.new(count_by_word.map { |w, c| WordCount.new(w, c) })
  most_frequent_words = []
  [k, count_by_word.size].min.times { most_frequent_words.append(heap.extract_max.word) }
  most_frequent_words
end