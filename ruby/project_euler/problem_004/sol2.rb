class Integer
  def parindrome?
    self == reverse
  end

  def reverse
    result = 0
    n = self
    loop do
      result = result * 10 + n % 10
      break if (n /= 10).zero?
    end
    result
  end
end

factors = (100..999).to_a
products = factors.product(factors).map { _1 * _2 }
puts products.select(&:parindrome?).max
