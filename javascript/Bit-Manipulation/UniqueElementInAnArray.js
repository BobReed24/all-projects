const findUniqueElement = (arr) => arr.reduce((acc, val) => acc ^ val, 0)

export { findUniqueElement }
