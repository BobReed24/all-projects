answer = 0
999.downto(99) do |i|
  999.downto(99) do |j|
    t = (i * j)
    answer = i * j if (t.to_s == t.to_s.reverse) && (t > answer) && (t > answer)
  end
end
puts answer
