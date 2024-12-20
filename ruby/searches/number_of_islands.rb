def num_islands(grid)
  return 0 if grid.empty?

  islands = 0

  grid.each_with_index do |row, x|
    row.each_with_index do |plot, y|
      
      next unless plot == '1'

      dfs(grid, x, y)
      
      islands += 1
    end
  end

  islands
end

def dfs(grid, x, y)
  
  return if x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'

  grid[x][y] = '0'

  dfs(grid, x - 1, y) 
  dfs(grid, x + 1, y) 
  dfs(grid, x, y - 1) 
  dfs(grid, x, y + 1) 
end
