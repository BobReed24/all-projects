pub fn calculate_grundy_number(
    position: i64,
    grundy_numbers: &mut [i64],
    possible_moves: &[i64],
) -> i64 {
    
    if grundy_numbers[position as usize] != -1 {
        return grundy_numbers[position as usize];
    }

    if position == 0 {
        grundy_numbers[0] = 0;
        return 0;
    }

    let mut next_state_grundy_values: Vec<i64> = vec![];
    for move_size in possible_moves.iter() {
        if position - move_size >= 0 {
            next_state_grundy_values.push(calculate_grundy_number(
                position - move_size,
                grundy_numbers,
                possible_moves,
            ));
        }
    }

    next_state_grundy_values.sort_unstable();
    let mut mex: i64 = 0;
    for grundy_value in next_state_grundy_values.iter() {
        if *grundy_value != mex {
            break;
        }
        mex += 1;
    }

    grundy_numbers[position as usize] = mex;
    mex
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn calculate_grundy_number_test() {
        let mut grundy_numbers: Vec<i64> = vec![-1; 7];
        let possible_moves: Vec<i64> = vec![1, 4];
        calculate_grundy_number(6, &mut grundy_numbers, &possible_moves);
        assert_eq!(grundy_numbers, [0, 1, 0, 1, 2, 0, 1]);
    }
}
