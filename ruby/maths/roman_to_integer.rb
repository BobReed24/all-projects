ROM_NUMS = {
  'I' => 1,
  'V' => 5,
  'X' => 10,
  'L' => 50,
  'C' => 100,
  'D' => 500,
  'M' => 1000
}

def roman_to_int(s)
  res = 0
  temp = 0

  s.chars.each_with_index do |el, i|
    
    if ROM_NUMS[s[i + 1]] && ROM_NUMS[el] < ROM_NUMS[s[i + 1]]
      temp = ROM_NUMS[el]
    else
      
      res += (ROM_NUMS[el] - temp)
      temp = 0
    end
  end

  res
end

s = 'III'
puts roman_to_int(s)

s = 'IV'
puts roman_to_int(s)

s = 'IX'
puts roman_to_int(s)

s = 'LVIII'
puts roman_to_int(s)

s = 'MCMXCIV'
puts roman_to_int(s)

