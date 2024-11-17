def find_jewels(jewels, stones)
  jewels_array = jewels.split('')
  stones_array = stones.split('')
  result = 0
  jewels_array.each do |jewel|
    stones_array.each do |stone|
      result += 1 if jewel == stone
    end
  end
  result
end

puts find_jewels('aA', 'aAAbbbb')

puts find_jewels('z', 'ZZ')

def find_jewels(jewels, stones)
  jewels_array = jewels.split('')
  stones_array = stones.split('')
  result_hash = {}
  result = 0

  stones_array.each do |stone|
    if result_hash[stone]
      result_hash[stone] += 1
    else
      result_hash[stone] = 1
    end
  end

  jewels_array.each do |jewel|
    if result_hash[jewel]
      result += result_hash[jewel]
    else
      result
    end
  end

  result
end

puts find_jewels('aA', 'aAAbbbb')

puts find_jewels('z', 'ZZ')

