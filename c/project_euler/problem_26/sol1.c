#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#ifdef _OPENMP
#include <omp.h>
#endif

#define MAX_DENO 2000 
#define MAX_LEN \
    (MAX_DENO + 10) 

int compare(const void *a, const void *b)
{
    return (*(unsigned short *)a - *(unsigned short *)b);
}

int main(int argc, char *argv[])
{
    unsigned short max_digits = 0, max_idx_number = 0;

    clock_t start_time = clock();
    short deno;
#ifdef _OPENMP
#pragma omp for
#endif
    for (deno = 2; deno < MAX_DENO; deno++)
    {
        unsigned short remainders[MAX_LEN];
        unsigned short rem = 1, *rem_ptr = remainders;
        memset(remainders, (unsigned short)-1,
               MAX_LEN * sizeof(unsigned short));
        
        unsigned short index = 0, num_digits;

        while (rem != 0)
        {
            rem = (rem * 10) % deno;
            if (rem == 0)
            {
                index = 0;
                break;
            }
            rem_ptr = (unsigned short *)bsearch(
                &rem, remainders, MAX_LEN, sizeof(unsigned short), compare);
            
            if (rem_ptr != NULL)
                break;
            remainders[index] = rem;
            rem_ptr = remainders;
            index++;
        }

        num_digits = index - (rem_ptr - remainders);
        
#ifdef _OPENMP
#pragma omp critical
        {
#endif
            if (num_digits > max_digits)
            {
                max_digits = num_digits;
                max_idx_number = deno;
                
            }
#ifdef _OPENMP
        }
#endif
    }
    clock_t end_time = clock();

    printf("Time taken: %.4g ms\n",
           1e3 * (double)(end_time - start_time) / CLOCKS_PER_SEC);
    printf("Maximum digits: %hu\t Denominator: %hu\n", max_digits,
           max_idx_number);

    return 0;
}
