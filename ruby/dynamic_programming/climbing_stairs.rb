def climb_stairs(n)
  memo = {}

  memo[0] = 1
  memo[1] = 1

  return memo[n] if [0, 1].include?(n)

  (2..n).each do |n|
    recurse(n, memo)
  end

  memo[n]
end

def recurse(n, memo)
  return memo[n] if memo[n]

  memo[n] = recurse(n - 1, memo) + recurse(n - 2, memo)
end

puts climb_stairs(2)

puts climb_stairs(4)

puts climb_stairs(10)

puts climb_stairs(45)

