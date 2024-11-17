require 'benchmark'

array = [4, 3, 2, 7, 8, 2, 3, 1]
long_array = [4, 3, 2, 7, 8, 2, 3, 1] * 100

def find_duplicates(array)
  result_hash = {}
  result_array = []

  array.each do |num|
    if result_hash[num].nil?
      result_hash[num] = 1
    else
      result_hash[num] += 1
    end
  end

  result_hash.each do |k, v|
    result_array.push(k) if v > 1
  end

  result_array
end

Benchmark.bmbm do |x|
  x.report('execute algorithm 3') do
    print(find_duplicates(array))
    print(find_duplicates(long_array))
  end
end
