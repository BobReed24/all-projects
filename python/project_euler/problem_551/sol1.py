ks = range(2, 20 + 1)
base = [10**k for k in range(ks[-1] + 1)]
memo: dict[int, dict[int, list[list[int]]]] = {}

def next_term(a_i, k, i, n):
    
    ds_b = sum(a_i[j] for j in range(k, len(a_i)))
    c = sum(a_i[j] * base[j] for j in range(min(len(a_i), k)))

    diff, dn = 0, 0
    max_dn = n - i

    sub_memo = memo.get(ds_b)

    if sub_memo is not None:
        jumps = sub_memo.get(c)

        if jumps is not None and len(jumps) > 0:
            
            max_jump = -1
            for _k in range(len(jumps) - 1, -1, -1):
                if jumps[_k][2] <= k and jumps[_k][1] <= max_dn:
                    max_jump = _k
                    break

            if max_jump >= 0:
                diff, dn, _kk = jumps[max_jump]
                
                new_c = diff + c
                for j in range(min(k, len(a_i))):
                    new_c, a_i[j] = divmod(new_c, 10)
                if new_c > 0:
                    add(a_i, k, new_c)

        else:
            sub_memo[c] = []
    else:
        sub_memo = {c: []}
        memo[ds_b] = sub_memo

    if dn >= max_dn or c + diff >= base[k]:
        return diff, dn

    if k > ks[0]:
        while True:
            
            _diff, terms_jumped = next_term(a_i, k - 1, i + dn, n)
            diff += _diff
            dn += terms_jumped

            if dn >= max_dn or c + diff >= base[k]:
                break
    else:
        
        _diff, terms_jumped = compute(a_i, k, i + dn, n)
        diff += _diff
        dn += terms_jumped

    jumps = sub_memo[c]

    j = 0
    while j < len(jumps):
        if jumps[j][1] > dn:
            break
        j += 1

    sub_memo[c].insert(j, (diff, dn, k))
    return (diff, dn)

def compute(a_i, k, i, n):
    
    if i >= n:
        return 0, i
    if k > len(a_i):
        a_i.extend([0 for _ in range(k - len(a_i))])

    start_i = i
    ds_b, ds_c, diff = 0, 0, 0
    for j in range(len(a_i)):
        if j >= k:
            ds_b += a_i[j]
        else:
            ds_c += a_i[j]

    while i < n:
        i += 1
        addend = ds_c + ds_b
        diff += addend
        ds_c = 0
        for j in range(k):
            s = a_i[j] + addend
            addend, a_i[j] = divmod(s, 10)

            ds_c += a_i[j]

        if addend > 0:
            break

    if addend > 0:
        add(a_i, k, addend)
    return diff, i - start_i

def add(digits, k, addend):
    
    for j in range(k, len(digits)):
        s = digits[j] + addend
        if s >= 10:
            quotient, digits[j] = divmod(s, 10)
            addend = addend // 10 + quotient
        else:
            digits[j] = s
            addend = addend // 10

        if addend == 0:
            break

    while addend > 0:
        addend, digit = divmod(addend, 10)
        digits.append(digit)

def solution(n: int = 10**15) -> int:
    
    digits = [1]
    i = 1
    dn = 0
    while True:
        diff, terms_jumped = next_term(digits, 20, i + dn, n)
        dn += terms_jumped
        if dn == n - i:
            break

    a_n = 0
    for j in range(len(digits)):
        a_n += digits[j] * 10**j
    return a_n

if __name__ == "__main__":
    print(f"{solution() = }")
