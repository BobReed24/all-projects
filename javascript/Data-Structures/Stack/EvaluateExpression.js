function evaluatePostfixExpression(expression) {
  const stack = []

  function performOperation(operator) {
    const rightOp = stack.pop() 
    const leftOp = stack.pop() 

    if (leftOp === undefined || rightOp === undefined) {
      return false 
    }
    switch (operator) {
      case '+':
        stack.push(leftOp + rightOp)
        break
      case '-':
        stack.push(leftOp - rightOp)
        break
      case '*':
        stack.push(leftOp * rightOp)
        break
      case '/':
        if (rightOp === 0) {
          return false
        }
        stack.push(leftOp / rightOp)
        break
      default:
        return false 
    }
    return true
  }

  const tokens = expression.split(/\s+/)

  for (const token of tokens) {
    if (!isNaN(parseFloat(token))) {
      
      stack.push(parseFloat(token))
    } else {
      
      if (!performOperation(token)) {
        return null 
      }
    }
  }

  return stack.length === 1 ? stack[0] : null
}

export { evaluatePostfixExpression }
