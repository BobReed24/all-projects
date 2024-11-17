

#ifndef QR_DECOMPOSE_H
#define QR_DECOMPOSE_H

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#ifdef _OPENMP
#include <omp.h>
#endif


void print_matrix(double **A, 
                  int M,      
                  int N)      
{
    for (int row = 0; row < M; row++)
    {
        for (int col = 0; col < N; col++) printf("% 9.3g\t", A[row][col]);
        putchar('\n');
    }
    putchar('\n');
}


double vector_dot(double *a, double *b, int L)
{
    double mag = 0.f;
    int i;
#ifdef _OPENMP

#pragma omp parallel for reduction(+ : mag)
#endif
    for (i = 0; i < L; i++) mag += a[i] * b[i];

    return mag;
}


double vector_mag(double *vector, int L)
{
    double dot = vector_dot(vector, vector, L);
    return sqrt(dot);
}


double *vector_proj(double *a, double *b, double *out, int L)
{
    const double num = vector_dot(a, b, L);
    const double deno = vector_dot(b, b, L);
    if (deno == 0) 
        return NULL;

    const double scalar = num / deno;
    int i;
#ifdef _OPENMP

#pragma omp for
#endif
    for (i = 0; i < L; i++) out[i] = scalar * b[i];

    return out;
}


double *vector_sub(double *a,   
                   double *b,   
                   double *out, 
                   int L        
)
{
    int i;
#ifdef _OPENMP

#pragma omp for
#endif
    for (i = 0; i < L; i++) out[i] = a[i] - b[i];

    return out;
}


void qr_decompose(double **A, 
                  double **Q, 
                  double **R, 
                  int M,      
                  int N       
)
{
    double *col_vector = (double *)malloc(M * sizeof(double));
    double *col_vector2 = (double *)malloc(M * sizeof(double));
    double *tmp_vector = (double *)malloc(M * sizeof(double));
    for (int i = 0; i < N;
         i++) 
    {
        int j;
#ifdef _OPENMP

#pragma omp for
#endif
        for (j = 0; j < i; j++) 
            R[i][j] = 0.;       

            
#ifdef _OPENMP

#pragma omp for
#endif
        for (j = 0; j < M; j++)
        {
            tmp_vector[j] = A[j][i]; 
            col_vector[j] = A[j][i];
        }
        for (j = 0; j < i; j++)
        {
            for (int k = 0; k < M; k++) col_vector2[k] = Q[k][j];
            vector_proj(col_vector, col_vector2, col_vector2, M);
            vector_sub(tmp_vector, col_vector2, tmp_vector, M);
        }
        double mag = vector_mag(tmp_vector, M);

#ifdef _OPENMP

#pragma omp for
#endif
        for (j = 0; j < M; j++) Q[j][i] = tmp_vector[j] / mag;

        
        for (int kk = 0; kk < M; kk++) col_vector[kk] = Q[kk][i];
        for (int k = i; k < N; k++)
        {
            for (int kk = 0; kk < M; kk++) col_vector2[kk] = A[kk][k];
            R[i][k] = vector_dot(col_vector, col_vector2, M);
        }
    }

    free(col_vector);
    free(col_vector2);
    free(tmp_vector);
}

#endif  
