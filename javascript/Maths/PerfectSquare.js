const perfectSquare = (num) =>
  Number.isFinite(num) && Math.round(Math.sqrt(num)) ** 2 === num

export { perfectSquare }
