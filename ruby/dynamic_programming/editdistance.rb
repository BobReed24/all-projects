require "test/unit"

def editDistDP(str1, str2, m, n) 
    rows, cols = m+1,n+1  

    dp = Array.new(rows) { Array.new(cols) }

    for i in (0..m + 1-1) do
        for j in (0..n + 1-1) do

            if i == 0 
                dp[i][j] = j   
        
            elsif j == 0 
                dp[i][j]  = i 
            
            elsif str1[i-1] == str2[j-1] 
                dp[i][j] =  dp[i-1][j-1] 
            
            else
                dp[i][j] = 1 +[dp[i][j-1],dp[i-1][j],dp[i-1][j-1]].min()
                
            end
        
        end
        
    end
    
    return dp[m][n]
end

class Editdistancetest < Test::Unit::TestCase
    
    def test_distance1
      assert_equal 3, editDistDP( "sunday","saturday",6,8), "Should return 3" 
    end
  
    def test_distance2
      assert_equal 1, editDistDP("cat","cut",3,3), "editDistDpShould return 1"
    end

    def test_distance3
       assert_equal 8, editDistDP("","applepie",0,8), "editDistDpShould return 1"
    end

    def test_distance4
       assert_equal 0, editDistDP("Hello","Hello",5,5), "editDistDpShould return 1" 
    end

  end
    
