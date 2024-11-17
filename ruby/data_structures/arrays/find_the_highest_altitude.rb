def largest_altitude(gain)
  arr = [0]

  (1..gain.count).each do |pointer|
    sum = arr[pointer - 1] + gain[pointer - 1]
    arr.push(sum)
  end

  max = 0
  arr.each { |i| max = i if max < i }
  max
end

gain = [-5, 1, 5, 0, -7]
largest_altitude(gain)

gain = [-4, -3, -2, -1, 4, 3, 2]
largest_altitude(gain)

def largest_altitude(gain)
  max_alt = alt = 0

  (0...gain.count).each do |i|
    alt += gain[i]

    max_alt = alt if max_alt < alt
  end

  max_alt
end

gain = [-5, 1, 5, 0, -7]
largest_altitude(gain)

gain = [-4, -3, -2, -1, 4, 3, 2]
largest_altitude(gain)

