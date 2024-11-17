require "test/unit"

def knapSack(weight, wt, val, n)
    
    rows, cols = n+1,weight+1  
    
    dp = Array.new(rows) { Array.new(cols) }
    
    for i in (0..n + 1-1) 
        for w in (0..weight + 1-1) 
            
            if i == 0 || w == 0 
                dp[i][w] = 0
            
            elsif wt[i-1] <= w 
                dp[i][w] = [ val[i-1] + dp[i-1][w-wt[i-1]],dp[i-1][w]].max()
           
            else
                dp[i][w] = dp[i-1][w]
            end
        end
    end
    
    return dp[n][weight]
end
    
class Knapsacktest < Test::Unit::TestCase
    
    def test_knapsack1
      assert_equal 220, knapSack(50,[10,20,30],[60,100,120],3), "Should return 220" 
    end

    def test_knapsack2
      assert_equal 500, knapSack(50,[50, 20, 30],[100, 200, 300],3), "Should return 500" 
    end

    def test_knapsack3
        assert_equal 17, knapSack(10,[3,4,5, 2, 1],[10,2,3,4,0],5), "Should return 17" 
    end

    def test_knapsack4
        assert_equal 0, knapSack(0,[23, 17, 12, 8, 20],[199,200,30,41,10],5), "Should return 0" 
    end

end

