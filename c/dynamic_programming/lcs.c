#include <stdio.h>		
#include <stdlib.h>		
#include <string.h>		
#include <assert.h>		

enum {LEFT, UP, DIAG};

void lcslen(const char *s1, const char *s2, int l1, int l2, int **L, int **B) {
	
	int i, j;

	for (i = 1; i <= l1; ++i) {
		for (j = 1; j <= l2; ++j) {
			if (s1[i-1] == s2[j-1]) {
				L[i][j] = 1 + L[i-1][j-1];
				B[i][j] = DIAG;
			}
			else if (L[i-1][j] < L[i][j-1]) {
				L[i][j] = L[i][j-1];
				B[i][j] = LEFT;
			}
			else {
				L[i][j] = L[i-1][j];
				B[i][j] = UP;
            }
		}
	}
}

char *lcsbuild(const char *s1, int l1, int l2, int **L, int **B) {
	int	 i, j, lcsl;
	char	*lcs;
	lcsl = L[l1][l2];
	
	lcs = (char *)calloc(lcsl+1, sizeof(char)); 
	if (!lcs) {
		perror("calloc: ");
		return NULL;
	}

	i = l1, j = l2;
	while (i > 0 && j > 0) {
		
		if (B[i][j] == DIAG) {
			lcs[--lcsl] = s1[i-1];
			i = i - 1;
			j = j - 1;
		}
        else if (B[i][j] == LEFT)
        {
            j = j - 1;
		}
        else
        {
            i = i - 1;
        }
	}
	return lcs;
}

static void test() {
	
int main(int argc, char *argv[]) {
	test();  
	return 0;
}
