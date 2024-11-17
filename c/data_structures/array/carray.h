

#pragma once

#ifdef __cplusplus
extern "C"
{
#endif

#define ARRAY_ERASED -1
#define SUCCESS 0
#define INVALID_POSITION 1
#define POSITION_INIT 2
#define POSITION_NOT_INIT 3
#define POSITION_EMPTY 4
#define ARRAY_FULL 5

    typedef struct CArray
    {
        int *array;
        int size;
    } CArray;

    
    
    
    CArray *getCArray(int size);
    CArray *getCopyCArray(CArray *array);

    
    
    
    int insertValueCArray(CArray *array, int position, int value);
    int removeValueCArray(CArray *array, int position);
    int pushValueCArray(CArray *array, int value);
    int updateValueCArray(CArray *array, int position, int value);

    
    
    
    int eraseCArray(CArray *array);

    
    
    
    int switchValuesCArray(CArray *array, int position1, int position2);
    int reverseCArray(CArray *array);

    
    
    
    int bubbleSortCArray(CArray *array);
    int selectionSortCArray(CArray *array);
    int insertionSortCArray(CArray *array);
    int blenderCArray(CArray *array);

    
    
    
    int valueOcurranceCArray(CArray *array, int value);
    CArray *valuePositionsCArray(CArray *array, int value);
    int findMaxCArray(CArray *array);
    int findMinCArray(CArray *array);

    
    
    
    int displayCArray(CArray *array);

#ifdef __cplusplus
}
#endif
