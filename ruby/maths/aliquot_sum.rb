require_relative './square_root'
require_relative './ceil'

class AliquotSum
  class << self
    def call(number)
      divisors(number).sum
    end

    private

    def divisors(number)
      low_divisors = (1..Ceil.call(SquareRoot.call(number))).select { |num| (number % num).zero? }
      high_divisors = low_divisors.map { |div| number / div }
      (low_divisors + high_divisors).uniq - [number]
    end
  end
end
