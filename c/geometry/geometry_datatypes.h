

#ifndef __LIBQUAT_H_
#define __LIBQUAT_H_


#define EPSILON 1e-9



typedef struct vec_3d_
{
    float x; 
    float y; 
    float z; 
} vec_3d;




typedef struct mat_3x3_
{
    union
    { 
        float row1[3];
        vec_3d vec1;
    };
    union
    { 
        float row2[3];
        vec_3d vec2;
    };
    union
    { 
        float row3[3];
        vec_3d vec3;
    };
} mat_3x3;




typedef struct quaternion_
{
    union
    {
        float w;  
        float q0; 
    };
    
    union
    {
        vec_3d dual; 
        
        struct
        {
            float q1, q2, q3;
        };
    };
} quaternion;


typedef struct euler_
{
    union
    {
        float roll; 
        float bank; 
    };
    union
    {
        float pitch; 
        float elevation; 
    };
    union
    {
        float yaw;     
        float heading; 
    };
} euler;





typedef struct dual_quat_
{
    quaternion real; 
    quaternion dual; 
} dual_quat;



#endif  


