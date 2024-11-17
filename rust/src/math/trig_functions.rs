fn template<T: Into<f64>>(x: T, tol: f64, kind: i32) -> f64 {
    use std::f64::consts::PI;
    const PERIOD: f64 = 2.0 * PI;
    
    fn factorial(n: i128) -> i128 {
        (1..=n).product()
    }

    fn round_up_to_decimal(x: f64, decimal: i32) -> f64 {
        let multiplier = 10f64.powi(decimal);
        (x * multiplier).round() / multiplier
    }

    let mut value: f64 = x.into(); 

    if !value.is_finite() || value.is_nan() {
        eprintln!("This function does not accept invalid arguments.");
        return f64::NAN;
    }

    while value >= PERIOD {
        value -= PERIOD;
    }
    
    while value <= -PERIOD {
        value += PERIOD;
    }

    let mut rez = 0f64;
    let mut prev_rez = 1f64;
    let mut step: i32 = 0;
    
    while (prev_rez - rez).abs() > tol {
        prev_rez = rez;
        rez += (-1f64).powi(step) * value.powi(2 * step + kind)
            / factorial((2 * step + kind) as i128) as f64;
        step += 1;
    }

    round_up_to_decimal(rez, 6)
}

pub fn sine<T: Into<f64>>(x: T, tol: f64) -> f64 {
    template(x, tol, 1)
}

pub fn cosine<T: Into<f64>>(x: T, tol: f64) -> f64 {
    template(x, tol, 0)
}

pub fn cosine_no_radian_arg<T: Into<f64>>(x: T, tol: f64) -> f64 {
    use std::f64::consts::PI;
    let val: f64 = x.into();
    cosine(val * PI / 180., tol)
}

pub fn sine_no_radian_arg<T: Into<f64>>(x: T, tol: f64) -> f64 {
    use std::f64::consts::PI;
    let val: f64 = x.into();
    sine(val * PI / 180f64, tol)
}

pub fn tan<T: Into<f64> + Copy>(x: T, tol: f64) -> f64 {
    let cos_val = cosine(x, tol);

    if cos_val != 0f64 {
        let sin_val = sine(x, tol);
        sin_val / cos_val
    } else {
        f64::NAN
    }
}

pub fn cotan<T: Into<f64> + Copy>(x: T, tol: f64) -> f64 {
    let sin_val = sine(x, tol);

    if sin_val != 0f64 {
        let cos_val = cosine(x, tol);
        cos_val / sin_val
    } else {
        f64::NAN
    }
}

pub fn tan_no_radian_arg<T: Into<f64> + Copy>(x: T, tol: f64) -> f64 {
    let angle: f64 = x.into();

    use std::f64::consts::PI;
    tan(angle * PI / 180., tol)
}

pub fn cotan_no_radian_arg<T: Into<f64> + Copy>(x: T, tol: f64) -> f64 {
    let angle: f64 = x.into();

    use std::f64::consts::PI;
    cotan(angle * PI / 180., tol)
}

#[cfg(test)]
mod tests {
    use super::*;
    use std::f64::consts::PI;

    enum TrigFuncType {
        Sine,
        Cosine,
        Tan,
        Cotan,
    }

    const TOL: f64 = 1e-10;

    impl TrigFuncType {
        fn verify<T: Into<f64> + Copy>(&self, angle: T, expected_result: f64, is_radian: bool) {
            let value = match self {
                TrigFuncType::Sine => {
                    if is_radian {
                        sine(angle, TOL)
                    } else {
                        sine_no_radian_arg(angle, TOL)
                    }
                }
                TrigFuncType::Cosine => {
                    if is_radian {
                        cosine(angle, TOL)
                    } else {
                        cosine_no_radian_arg(angle, TOL)
                    }
                }
                TrigFuncType::Tan => {
                    if is_radian {
                        tan(angle, TOL)
                    } else {
                        tan_no_radian_arg(angle, TOL)
                    }
                }
                TrigFuncType::Cotan => {
                    if is_radian {
                        cotan(angle, TOL)
                    } else {
                        cotan_no_radian_arg(angle, TOL)
                    }
                }
            };

            assert_eq!(format!("{value:.5}"), format!("{:.5}", expected_result));
        }
    }

    #[test]
    fn test_sine() {
        let sine_id = TrigFuncType::Sine;
        sine_id.verify(0.0, 0.0, true);
        sine_id.verify(-PI, 0.0, true);
        sine_id.verify(-PI / 2.0, -1.0, true);
        sine_id.verify(0.5, 0.4794255386, true);
        
        sine_id.verify(0, 0.0, false);
        sine_id.verify(-180, 0.0, false);
        sine_id.verify(-180 / 2, -1.0, false);
        sine_id.verify(0.5, 0.00872654, false);
    }

    #[test]
    fn test_sine_bad_arg() {
        assert!(sine(f64::NEG_INFINITY, 1e-1).is_nan());
        assert!(sine_no_radian_arg(f64::NAN, 1e-1).is_nan());
    }

    #[test]
    fn test_cosine_bad_arg() {
        assert!(cosine(f64::INFINITY, 1e-1).is_nan());
        assert!(cosine_no_radian_arg(f64::NAN, 1e-1).is_nan());
    }

    #[test]
    fn test_cosine() {
        let cosine_id = TrigFuncType::Cosine;
        cosine_id.verify(0, 1., true);
        cosine_id.verify(0, 1., false);
        cosine_id.verify(45, 1. / f64::sqrt(2.), false);
        cosine_id.verify(PI / 4., 1. / f64::sqrt(2.), true);
        cosine_id.verify(360, 1., false);
        cosine_id.verify(2. * PI, 1., true);
        cosine_id.verify(15. * PI / 2., 0.0, true);
        cosine_id.verify(-855, -1. / f64::sqrt(2.), false);
    }

    #[test]
    fn test_tan_bad_arg() {
        assert!(tan(PI / 2., TOL).is_nan());
        assert!(tan(3. * PI / 2., TOL).is_nan());
    }

    #[test]
    fn test_tan() {
        let tan_id = TrigFuncType::Tan;
        tan_id.verify(PI / 4., 1f64, true);
        tan_id.verify(45, 1f64, false);
        tan_id.verify(PI, 0f64, true);
        tan_id.verify(180 + 45, 1f64, false);
        tan_id.verify(60 - 2 * 180, 1.7320508075, false);
        tan_id.verify(30 + 180 - 180, 0.57735026919, false);
    }

    #[test]
    fn test_cotan_bad_arg() {
        assert!(cotan(tan(PI / 2., TOL), TOL).is_nan());
        assert!(!cotan(0, TOL).is_finite());
    }

    #[test]
    fn test_cotan() {
        let cotan_id = TrigFuncType::Cotan;
        cotan_id.verify(PI / 4., 1f64, true);
        cotan_id.verify(90 + 10 * 180, 0f64, false);
        cotan_id.verify(30 - 5 * 180, f64::sqrt(3.), false);
    }
}
