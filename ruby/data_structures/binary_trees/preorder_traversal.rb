def preorder_traversal(root)
  ans = []
  def traverse(node, ans)
    unless node.nil?
      ans.push(node.val)
      traverse(node.left, ans)
      traverse(node.right, ans)
    end
  end
  traverse(root, ans)
  ans
end
