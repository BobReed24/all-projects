class CircularQueue
  def initialize(max_size)
    @max_size = max_size
    @queue = Array.new(max_size, nil)
    @front = 0
    @back = 0
    @size = 0
  end

  attr_accessor :front, :back, :size
  attr_reader :max_size, :queue

  def empty?
    size == 0
  end

  def peek
    return nil if empty?

    queue[front]
  end

  def add(x)
    raise 'Queue is at max capacity' if size == max_size

    queue[back] = x
    @back = (back + 1) % max_size
    @size += 1
  end

  def pop
    raise 'Queue is empty' if size == 0

    temp = queue[front]
    queue[front] = nil
    @front = (front + 1) % max_size
    @size -= 1

    temp
  end
end

queue = CircularQueue.new(3)

begin
  queue.pop
rescue StandardError => e
  puts e.message
end

queue.add(1)
queue.add(2)
queue.add(3)

begin
  queue.add(4)
rescue StandardError => e
  puts e.message
end

puts queue.inspect

puts queue.peek

queue.pop

puts queue.peek

