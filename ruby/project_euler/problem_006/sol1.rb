def solution(num=10)
	x = 1
	y = 1
	result = 1
	gap = 3
	while y < num
  		x += gap
  		gap += 2
  		y += 1
  		result += x
	end
	r_n_pow2_plus_n_pow2 = result
	r_sum_n_pow2 = (((num / 2) + 0.5) * num) ** 2

	r_sum_n_pow2 - r_n_pow2_plus_n_pow2
end

answer = solution()
p answer
