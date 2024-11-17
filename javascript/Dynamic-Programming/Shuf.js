function shuf(datasetSource, sampleSize) {
  const output = fillBaseSample(datasetSource, sampleSize)

  return randomizeOutputFromDataset(datasetSource, output)
}

function fillBaseSample(datasetSource, sampleSize) {
  let filledIndexes = []
  let output = new Array(sampleSize)

  while (true) {
    const iterator = datasetSource.next()
    if (iterator.done) break

    let insertTo = Math.floor(Math.random() * output.length)
    while (filledIndexes.includes(insertTo)) {
      insertTo++
      if (insertTo === output.length) {
        insertTo = 0
      }
    }
    output[insertTo] = {
      value: iterator.value
    }

    filledIndexes = [...filledIndexes, insertTo]

    if (filledIndexes.length === sampleSize) {
      break
    }
  }

  if (filledIndexes.length < output.length) {
    
    output = output.filter((_, i) => filledIndexes.includes(i))
  }

  return output.map((o) => o.value)
}

function randomizeOutputFromDataset(datasetSource, output) {
  const newOutput = [...output]
  let readSoFar = output.length

  while (true) {
    const iterator = datasetSource.next()
    if (iterator.done) break
    readSoFar++

    const insertTo = Math.floor(Math.random() * readSoFar)
    if (insertTo < newOutput.length) {
      newOutput[insertTo] = iterator.value
    }
  }

  return newOutput
}

function* generateRandomData(length) {
  const maxValue = Math.pow(2, 31) - 1
  for (let i = 0; i < length; i++) {
    yield Math.floor(Math.random() * maxValue)
  }
}

export { shuf, generateRandomData }
