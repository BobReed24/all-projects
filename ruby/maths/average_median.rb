module AverageMedian
  def self.average_median(n, *array)
    if n.instance_of? Integer
      if n == array.size
        array.sort
        if array.size.even?
          mid_element_1 = array.size / 2
          mid_element_2 = mid_element_1 + 1
          puts "The average median of the following elements 
        else
          mid_element = (array.size + 1) / 2
          puts "The average median of the following elements 
        end
      else
        puts "Provide the required 
      end
    else
      raise
    end
  rescue StandardError
    puts 'Error: Please provide number only!'
  end
end

puts AverageMedian.average_median(2, 3, 1)

puts AverageMedian.average_median(5, 1, 2, 3, 4, 5)

puts AverageMedian.average_median(3, 2, 2, 2)

puts AverageMedian.average_median(1, 5)

puts AverageMedian.average_median(2, 3, 1, 5)

puts AverageMedian.average_median(2, 3, 'a')

puts AverageMedian.average_median('a', 1, 2)

