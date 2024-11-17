class CaesarCipher
  ALPHABET = ('a'..'z').to_a

  def self.encrypt(plaintext, shift)
    plaintext.chars.map do |letter|
      temp = letter.ord + shift
      temp -= ALPHABET.length while temp > 'z'.ord
      temp.chr
    end.join
  end

  def self.decrypt(ciphertext, shift)
    ciphertext.chars.map do |letter|
      temp = letter.ord - shift
      temp += ALPHABET.length while temp < 'a'.ord
      temp.chr
    end.join
  end
end
