module TemperatureConversion
  
  def self.celsius_to_kelvin(celsius_input)
    kelvin_output = (celsius_input + 273.15).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end

  def self.kelvin_to_celsius(kelvin_input)
    celsius_output = (kelvin_input - 273.15).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end

  def self.celsius_to_fahrenheit(celsius_input)
    fahrenheit_output = ((celsius_input * 9 / 5) + 32).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end

  def self.fahrenheit_to_celsius(fahrenheit_input)
    celsius_output = ((fahrenheit_input - 32) * 5 / 9).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end

  def self.fahrenheit_to_kelvin(fahrenheit_input)
    kelvin_output = ((fahrenheit_input - 32) * 5 / 9).round(2).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end

  def self.kelvin_to_fahrenheit(kelvin_input)
    fahrenheit_output = (((kelvin_input - 273.15) * 9 / 5) + 32).round(2).round(2)
    puts "
  rescue StandardError
    puts 'Error: Please provide number only!'
  end
end

TemperatureConversion.celsius_to_kelvin(20)
TemperatureConversion.kelvin_to_celsius(20)

TemperatureConversion.kelvin_to_celsius('a')

TemperatureConversion.celsius_to_fahrenheit(-20)
TemperatureConversion.fahrenheit_to_celsius(68)

TemperatureConversion.celsius_to_fahrenheit('abc')

TemperatureConversion.fahrenheit_to_kelvin(60)
TemperatureConversion.kelvin_to_fahrenheit(-60)

TemperatureConversion.fahrenheit_to_kelvin('60')
