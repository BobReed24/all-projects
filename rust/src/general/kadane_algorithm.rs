pub fn max_sub_array(nums: Vec<i32>) -> i32 {
    if nums.is_empty() {
        return 0;
    }

    let mut max_current = nums[0];
    let mut max_global = nums[0];

    nums.iter().skip(1).for_each(|&item| {
        max_current = std::cmp::max(item, max_current + item);
        if max_current > max_global {
            max_global = max_current;
        }
    });
    max_global
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_kadanes_algorithm_positive() {
        let arr = [1, 2, 3, 4, 5];
        assert_eq!(max_sub_array(arr.to_vec()), 15);
    }

    #[test]
    fn test_kadanes_algorithm_negative() {
        let arr = [-2, -3, -4, -1, -2];
        assert_eq!(max_sub_array(arr.to_vec()), -1);
    }

    #[test]
    fn test_kadanes_algorithm_mixed() {
        let arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4];
        assert_eq!(max_sub_array(arr.to_vec()), 6);
    }

    #[test]
    fn test_kadanes_algorithm_empty() {
        let arr: [i32; 0] = [];
        assert_eq!(max_sub_array(arr.to_vec()), 0);
    }

    #[test]
    fn test_kadanes_algorithm_single_positive() {
        let arr = [10];
        assert_eq!(max_sub_array(arr.to_vec()), 10);
    }
}
