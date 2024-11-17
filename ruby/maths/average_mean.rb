module AverageMean
  
  def self.average_mean(n, *array)
    if n.instance_of? Integer
      if n == array.size
        puts "The average mean of the following elements 
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

AverageMean.average_mean(2, 3, 1)
AverageMean.average_mean(5, 1, 2, 3, 4, 5)
AverageMean.average_mean(3, 2, 2, 2)

AverageMean.average_mean(2, 3, 1, 5)
AverageMean.average_mean(2, 3, 'a')
AverageMean.average_mean('a', 1, 2)
