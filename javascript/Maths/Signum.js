function signum(input) {
  if (input === 0) return 0
  if (input > 0) return 1
  if (input < 0) return -1

  return NaN
}

export { signum }
