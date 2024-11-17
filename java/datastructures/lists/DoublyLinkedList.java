package com.thealgorithms.datastructures.lists;

public final class DoublyLinkedList {

    protected Link head;
    
    private Link tail;
    
    private LinkOperations linkOperations;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public DoublyLinkedList(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        for (int i : array) {
            linkOperations.insertTail(i, this);
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void display() { 
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackwards() {
        Link current = tail;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}

class Link {

    public int value;
    
    public Link next;
    
    public Link previous;

    Link(int value) {
        this.value = value;
    }

    public void displayLink() {
        System.out.print(value + " ");
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        LinkOperations linkOperations = new LinkOperations();
        linkOperations.insertHead(13, myList);
        linkOperations.insertHead(7, myList);
        linkOperations.insertHead(10, myList);
        myList.display(); 
        myList.displayBackwards();

        linkOperations.insertTail(11, myList);
        myList.display(); 
        myList.displayBackwards();

        linkOperations.deleteTail();
        myList.display(); 
        myList.displayBackwards();

        linkOperations.delete(7);
        myList.display(); 
        myList.displayBackwards();

        linkOperations.insertOrdered(23, myList);
        linkOperations.insertOrdered(67, myList);
        linkOperations.insertOrdered(3, myList);
        myList.display(); 
        linkOperations.insertElementByIndex(5, 1, myList);
        myList.display(); 
        myList.displayBackwards();
        linkOperations.reverse(); 
        myList.display();

        linkOperations.clearList();
        myList.display();
        myList.displayBackwards();
        linkOperations.insertHead(20, myList);
        myList.display();
        myList.displayBackwards();
    }
}

class LinkOperations {

    private Link head;
    
    private Link tail;

    private int size;

    public void insertHead(int x, DoublyLinkedList doublyLinkedList) {
        Link newLink = new Link(x); 
        if (doublyLinkedList.isEmpty()) { 
            tail = newLink;
        } else {
            head.previous = newLink; 
        }
        newLink.next = head; 
        head = newLink; 
        ++size;
    }

    public void insertTail(int x, DoublyLinkedList doublyLinkedList) {
        Link newLink = new Link(x);
        newLink.next = null; 
        if (doublyLinkedList.isEmpty()) { 
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink; 
            newLink.previous = tail; 
            tail = newLink; 
        }
        ++size;
    }

    public void insertElementByIndex(int x, int index, DoublyLinkedList doublyLinkedList) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertHead(x, doublyLinkedList);
        } else {
            if (index == size) {
                insertTail(x, doublyLinkedList);
            } else {
                Link newLink = new Link(x);
                Link previousLink = head; 
                for (int i = 1; i < index; i++) { 
                    previousLink = previousLink.next;
                }
                
                previousLink.next.previous = newLink;
                newLink.next = previousLink.next;
                newLink.previous = previousLink;
                previousLink.next = newLink;
            }
        }
        ++size;
    }

    public Link deleteHead() {
        Link temp = head;
        head = head.next; 

        if (head == null) {
            tail = null;
        } else {
            head.previous = null; 
                                  
        }
        --size;
        return temp;
    }

    public Link deleteTail() {
        Link temp = tail;
        tail = tail.previous; 

        if (tail == null) {
            head = null;
        } else {
            tail.next = null; 
        }
        --size;
        return temp;
    }

    public void delete(int x) {
        Link current = head;

        while (current.value != x) { 
            if (current != tail) {
                current = current.next;
            } else { 
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }

        if (current == head) {
            deleteHead();
        } else if (current == tail) {
            deleteTail();
        } else { 
            current.previous.next = current.next; 
            current.next.previous = current.previous; 
        }
        --size;
    }

    public void insertOrdered(int x, DoublyLinkedList doublyLinkedList) {
        Link newLink = new Link(x);
        Link current = head;
        while (current != null && x > current.value) { 
            current = current.next;
        }

        if (current == head) {
            insertHead(x, doublyLinkedList);
        } else if (current == null) {
            insertTail(x, doublyLinkedList);
        } else { 
            newLink.previous = current.previous; 
            current.previous.next = newLink; 
            newLink.next = current; 
            current.previous = newLink; 
        }
        ++size;
    }

    public void deleteNode(Link z) {
        if (z.next == null) {
            deleteTail();
        } else if (z == head) {
            deleteHead();
        } else { 
            z.previous.next = z.next; 
            z.next.previous = z.previous; 
        }
        --size;
    }

    public void removeDuplicates(DoublyLinkedList l) {
        Link linkOne = l.head;
        while (linkOne.next != null) { 
            Link linkTwo = linkOne.next; 
            while (linkTwo.next != null) {
                if (linkOne.value == linkTwo.value) { 
                    delete(linkTwo.value); 
                }
                linkTwo = linkTwo.next; 
            }
            linkOne = linkOne.next; 
        }
    }

    public void reverse() {
        
        Link thisHead = this.head;
        Link thisTail = this.tail;

        this.head = thisTail;
        this.tail = thisHead;

        Link nextLink = thisHead;
        while (nextLink != null) {
            Link nextLinkNext = nextLink.next;
            Link nextLinkPrevious = nextLink.previous;
            nextLink.next = nextLinkPrevious;
            nextLink.previous = nextLinkNext;

            nextLink = nextLinkNext;
        }
    }

    public void clearList() {
        head = null;
        tail = null;
        size = 0;
    }
}
