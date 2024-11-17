class Node
  attr_reader   :value, :next
  attr_accessor :word

  def initialize(value)
    @value = value
    @word  = false
    @next  = []
  end
end

class Trie
  def initialize
    @root = Node.new('*')
  end

  def insert_many(word)
    letters = word.chars
    base    = @root

    letters.each do |letter|
      base = insert(letter, base.next)
    end
  end

  def include?(word)
    letters = word.chars
    base    = @root

    letters.all? do |letter|
      base = find(letter, base.next)
    end
  end

  private

  def insert(character, trie)
    found = trie.find do |n|
      n.value == character
    end

    add_node(character, trie) unless found
  end

  def add_node(character, trie)
    Node.new(character).tap do |new_node|
      trie << new_node
    end
  end

  def find(character, trie)
    trie.find do |n|
      n.value == character
    end
  end
end

trie = Trie.new
trie.insert_many('Dogs')
trie.insert_many('South')
trie.insert_many('Cape Town')

puts trie.include?('Cape Town')

puts trie.include?('not presented')

