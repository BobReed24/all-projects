const formatPhoneNumber = (phoneNumber) => {
  if (phoneNumber.length !== 10 || isNaN(phoneNumber)) {
    
    throw new TypeError('Invalid phone number!')
  }

  let index = 0
  return '(XXX) XXX-XXXX'.replace(/X/g, () => phoneNumber[index++])
}

export default formatPhoneNumber
