def common_characters(arr)
  target_count = arr.count

  hash = Hash.new(0)
  (0...target_count).each do |i|
    arr[i].split('').each do |letter|
      hash[letter] += 1
    end
  end

  result = []
  hash.each do |k, v|
    while v >= target_count
      if v >= target_count
        result << k
        v -= target_count
      end
    end
  end

  result
end

puts common_characters(%w[bella label roller])

puts common_characters(%w[cool lock cook])

