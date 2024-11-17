use std::f64::consts::E;

pub fn log<T: Into<f64>, U: Into<f64>>(base: U, x: T, tol: f64) -> f64 {
    let mut rez: f64 = 0f64;
    let mut argument: f64 = x.into();
    let usable_base: f64 = base.into();

    if argument <= 0f64 || usable_base <= 0f64 {
        println!("Log does not support negative argument or negative base.");
        f64::NAN
    } else if argument < 1f64 && usable_base == E {
        argument -= 1f64;
        let mut prev_rez = 1f64;
        let mut step: i32 = 1;
        
        while (prev_rez - rez).abs() > tol {
            prev_rez = rez;
            rez += (-1f64).powi(step - 1) * argument.powi(step) / step as f64;
            step += 1;
        }

        rez
    } else {
        
        let ln_x = argument.ln();
        let ln_base = usable_base.ln();

        ln_x / ln_base
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn basic() {
        assert_eq!(log(E, E, 0.0), 1.0);
        assert_eq!(log(E, E.powi(100), 0.0), 100.0);
        assert_eq!(log(10, 10000.0, 0.0), 4.0);
        assert_eq!(log(234501.0, 1.0, 1.0), 0.0);
    }

    #[test]
    fn test_log_positive_base() {
        assert_eq!(log(10.0, 100.0, 0.00001), 2.0);
        assert_eq!(log(2.0, 8.0, 0.00001), 3.0);
    }

    #[test]
    fn test_log_zero_base() {
        assert!(log(0.0, 100.0, 0.00001).is_nan());
    }

    #[test]
    fn test_log_negative_base() {
        assert!(log(-1.0, 100.0, 0.00001).is_nan());
    }

    #[test]
    fn test_log_tolerance() {
        assert_eq!(log(10.0, 100.0, 1e-10), 2.0);
    }
}
