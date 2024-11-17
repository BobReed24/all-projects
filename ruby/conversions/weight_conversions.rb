module WeightConversion
  
  def self.kilogram_to_gram(kilogram_input)
    raise StandardError unless kilogram_input.is_a?(Integer)

    gram = kilogram_input * 1000

    "
  end

  def self.gram_to_kilogram(gram_input)
    kilogram = gram_input / 1000

    "
  end

  def self.pound_to_ounce(pound_input)
    ounce = pound_input * 16

    "
  end

  def self.ounce_to_pound(ounce_input)
    pound = ounce_input / 16

    "
  end

  def self.kilogram_to_pound(kilogram_input)
    pound = (kilogram_input * 2.205).round(2)

    "
  end

  def self.pound_to_kilogram(pound_input)
    raise StandardError unless pound_input.is_a?(Integer)

    kilogram = (pound_input / 2.205).round(2)

    "
  end
end

puts WeightConversion.kilogram_to_gram(2)

puts WeightConversion.gram_to_kilogram(3000)

puts WeightConversion.pound_to_ounce(16)

puts WeightConversion.ounce_to_pound(16)

puts WeightConversion.kilogram_to_pound(1)

puts WeightConversion.pound_to_kilogram(100)

begin
  puts WeightConversion.kilogram_to_gram('a')
rescue StandardError
  puts 'Error: Please provide number only!'
end

begin
  puts WeightConversion.kilogram_to_gram('3000')
rescue StandardError
  puts 'Error: Please provide number only!'
end

begin
  puts WeightConversion.kilogram_to_gram('16')
rescue StandardError
  puts 'Error: Please provide number only!'
end

begin
  puts WeightConversion.kilogram_to_gram('x ')
rescue StandardError
  puts 'Error: Please provide number only!'
end

begin
  puts WeightConversion.kilogram_to_gram('weight')
rescue StandardError
  puts 'Error: Please provide number only!'
end

begin
  puts WeightConversion.kilogram_to_gram('100')
rescue StandardError
  puts 'Error: Please provide number only!'
end
