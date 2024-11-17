def radix_sort(array, base = 10)
  
  passes = (Math.log(array.minmax.map(&:abs).max) / Math.log(base)).floor + 1
  passes.times do |i|
    buckets = Array.new(2 * base) { [] }
    base_i = base**i

    array.each do |j|
      n = (j / base_i) % base
      n += base if j >= 0
      buckets[n] << j
    end
    array = buckets.flatten
  end

  array
end
