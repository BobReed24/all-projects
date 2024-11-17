pub struct Point {
    x: f64,
    y: f64,
}

pub fn area_of_polygon(fig: &[Point]) -> f64 {
    let mut res = 0.0;

    for i in 0..fig.len() {
        let p = if i > 0 {
            &fig[i - 1]
        } else {
            &fig[fig.len() - 1]
        };
        let q = &fig[i];

        res += (p.x - q.x) * (p.y + q.y);
    }

    f64::abs(res) / 2.0
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_area_triangle() {
        let points = vec![
            Point { x: 0.0, y: 0.0 },
            Point { x: 1.0, y: 0.0 },
            Point { x: 0.0, y: 1.0 },
        ];

        assert_eq!(area_of_polygon(&points), 0.5);
    }

    #[test]
    fn test_area_square() {
        let points = vec![
            Point { x: 0.0, y: 0.0 },
            Point { x: 1.0, y: 0.0 },
            Point { x: 1.0, y: 1.0 },
            Point { x: 0.0, y: 1.0 },
        ];

        assert_eq!(area_of_polygon(&points), 1.0);
    }

    #[test]
    fn test_area_hexagon() {
        let points = vec![
            Point { x: 0.0, y: 0.0 },
            Point { x: 1.0, y: 0.0 },
            Point { x: 1.5, y: 0.866 },
            Point { x: 1.0, y: 1.732 },
            Point { x: 0.0, y: 1.732 },
            Point { x: -0.5, y: 0.866 },
        ];

        assert_eq!(area_of_polygon(&points), 2.598);
    }
}
