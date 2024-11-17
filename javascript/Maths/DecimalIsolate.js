export const decimalIsolate = (number) => {
  const answer = parseFloat((number + '').replace(/^[-\d]+./, '.'))
  return isNaN(answer) === true ? 0 : answer
}
