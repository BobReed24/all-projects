def invert_tree(root)
  return nil if root.nil?

  temp = root.left
  root.left = invert_tree(root.right)
  root.right = invert_tree(temp)
  root
end
