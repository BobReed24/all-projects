def find_max_form(strs, m, n)
  dp = (m + 1).times.map { [0] * (n + 1) }

  strs.each do |str|
    zeros = str.count('0')
    ones = str.count('1')

    m.downto(zeros) do |i|
      n.downto(ones) do |j|
        dp[i][j] = [dp[i][j], dp[i - zeros][j - ones] + 1].max
      end
    end
  end

  dp[m][n]
end

strs = %w[10 0001 111001 1 0]
m = 5
n = 3
puts find_max_form(strs, m, n)

strs = %w[10 0 1]
m = 1
n = 1
puts find_max_form(strs, m, n)

