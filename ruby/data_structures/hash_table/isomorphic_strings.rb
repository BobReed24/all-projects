def isomorphic_strings_check(s, t)
  
  map = {}
  
  set = []

  (0..s.length - 1).each do |i|
    
    char1 = s[i]
    char2 = t[i]

    if map[char1]
      
      return false if map[char1] != char2
    
    else
      
      return false if set.include?(char2)

      map[char1] = char2
      set << char2
    end
  end
  true
end

puts isomorphic_strings_check('egg', 'add')

puts isomorphic_strings_check('foo', 'bar')

puts isomorphic_strings_check('paper', 'title')

