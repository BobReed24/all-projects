


#include <stdio.h>
#include <stdlib.h>




struct node
{
    int data;
    struct node *next;
    struct node *pre;
} * head, *tail, *tmp;




void create();
void enque(int x);
int deque();
int peek();
int size();
int isEmpty();
