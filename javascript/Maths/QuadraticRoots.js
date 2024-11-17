const quadraticRoots = (a, b, c) => {
  
  const discriminant = b * b - 4 * a * c

  if (discriminant < 0) {
    return []
  } else if (discriminant === 0) {
    
    return [-b / (2 * a)]
  } else {
    
    const sqrtDiscriminant = Math.sqrt(discriminant)
    return [
      (-b + sqrtDiscriminant) / (2 * a),
      (-b - sqrtDiscriminant) / (2 * a)
    ]
  }
}

export { quadraticRoots }
