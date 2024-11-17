

#ifndef __DICT__H
#define __DICT__H

#define MAXELEMENTS 1000


typedef struct Dict
{
    
    void *elements[MAXELEMENTS];

    
    int number_of_elements;

} Dictionary;


Dictionary *create_dict(void);


int add_item_label(Dictionary *, char label[], void *);


int add_item_index(Dictionary *, int index, void *);


void *get_element_label(Dictionary *, char[]);


void *get_element_index(Dictionary *, int);


void destroy(Dictionary *);

#endif