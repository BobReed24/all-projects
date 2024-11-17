def inorder_traversal(root)
  ans = []
  def traverse(node, ans)
    unless node.nil?
      traverse(node.left, ans)
      ans.push(node.val)
      traverse(node.right, ans)
    end
  end
  traverse(root, ans)
  ans
end
