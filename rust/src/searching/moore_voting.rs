pub fn moore_voting(arr: &[i32]) -> i32 {
    let n = arr.len();
    let mut cnt = 0; 
    let mut ele = 0; 

    arr.iter().for_each(|&item| {
        if cnt == 0 {
            cnt = 1;
            ele = item;
        } else if item == ele {
            cnt += 1;
        } else {
            cnt -= 1;
        }
    });

    let cnt_check = arr.iter().filter(|&&x| x == ele).count();

    if cnt_check > (n / 2) {
        ele
    } else {
        -1
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_moore_voting() {
        let arr1: Vec<i32> = vec![9, 1, 8, 1, 1];
        assert!(moore_voting(&arr1) == 1);
        let arr2: Vec<i32> = vec![1, 2, 3, 4];
        assert!(moore_voting(&arr2) == -1);
    }
}
