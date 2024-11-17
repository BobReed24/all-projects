export const catalanNumbers = (n) => {
  if (n === 0) {
    return [1]
  }
  const catList = [1, 1]

  for (let i = 2; i <= n; i++) {
    let newNumber = 0
    for (let j = 0; j < i; j++) {
      newNumber += catList[j] * catList[i - j - 1]
    }
    catList.push(newNumber)
  }

  return catList
}
