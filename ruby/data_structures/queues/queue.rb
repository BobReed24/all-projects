class ArrayQueue
  def initialize(queue = [])
    @queue = queue
  end

  attr_accessor :queue

  def add(item)
    queue.unshift(item)
  end

  def pop
    queue.pop
  end

  def peek
    queue[-1]
  end
end

queue = ArrayQueue.new
queue.add(3)
queue.add(4)
queue.add(5)

puts queue.inspect

queue.pop

puts queue.inspect

puts(queue.peek)

queue = Queue.new

queue << 1
queue << 2
queue << 3

queue.pop

queue.pop

queue = SizedQueue.new(5)

queue.push(:oranges)
queue.push(:apples)
queue.push(:blue)
queue.push(:orange)
queue.push(:green)

queue.push(:throw_expection)

queue.push(:throw_expection, true)

