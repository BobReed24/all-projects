package com.thealgorithms.datastructures.heaps;

public class FibonacciHeap {

    private static final double GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2;
    private HeapNode min;
    private static int totalLinks = 0;
    private static int totalCuts = 0;
    private int numOfTrees = 0;
    private int numOfHeapNodes = 0;
    private int markedHeapNodesCounter = 0;

    public FibonacciHeap() {
        this.min = null;
    }

    public FibonacciHeap(int key) {
        this.min = new HeapNode(key);
        this.numOfTrees++;
        this.numOfHeapNodes++;
    }

    public boolean empty() {
        return (this.min == null);
    }

    public HeapNode insert(int key) {
        HeapNode toInsert = new HeapNode(key); 
        if (this.empty()) {
            this.min = toInsert;
        } else { 
            min.setNext(toInsert);
            this.updateMin(toInsert);
        }
        this.numOfHeapNodes++;
        this.numOfTrees++;
        return toInsert;
    }

    public void deleteMin() {
        if (this.empty()) {
            return;
        }
        if (this.numOfHeapNodes == 1) { 
            this.min = null;
            this.numOfTrees--;
            this.numOfHeapNodes--;
            return;
        }
        
        if (this.min.child != null) { 
            HeapNode child = this.min.child;
            HeapNode tmpChild = child;
            child.parent = null;
            while (child.next != tmpChild) {
                child = child.next;
                child.parent = null;
            }
        }
        
        if (this.numOfTrees > 1) {
            (this.min.prev).next = this.min.next;
            (this.min.next).prev = this.min.prev;
            if (this.min.child != null) {
                (this.min.prev).setNext(this.min.child);
            }
        } else { 
            this.min = this.min.child;
        }
        this.numOfHeapNodes--;
        this.successiveLink(this.min.getNext());
    }

    public HeapNode findMin() {
        return this.min;
    }

    public void meld(FibonacciHeap heap2) {
        if (heap2.empty()) {
            return;
        }
        if (this.empty()) {
            this.min = heap2.min;
        } else {
            this.min.setNext(heap2.min);
            this.updateMin(heap2.min);
        }
        this.numOfTrees += heap2.numOfTrees;
        this.numOfHeapNodes += heap2.numOfHeapNodes;
    }

    public int size() {
        return this.numOfHeapNodes;
    }

    public int[] countersRep() {
        if (this.empty()) {
            return new int[0]; 
        }
        int[] rankArray = new int[(int) Math.floor(Math.log(this.size()) / Math.log(GOLDEN_RATIO)) + 1]; 
        rankArray[this.min.rank]++;
        HeapNode curr = this.min.next;
        while (curr != this.min) {
            rankArray[curr.rank]++;
            curr = curr.next;
        }
        return rankArray;
    }

    public void delete(HeapNode x) {
        this.decreaseKey(x, x.getKey() + 1); 
        this.deleteMin(); 
    }

    private void decreaseKey(HeapNode x, int delta) {
        int newKey = x.getKey() - delta;
        x.key = newKey;
        if (x.isRoot()) { 
            this.updateMin(x);
            return;
        }
        if (x.getKey() >= x.parent.getKey()) {
            return;
        } 
        HeapNode prevParent = x.parent;
        this.cut(x);
        this.cascadingCuts(prevParent);
    }

    public int potential() {
        return numOfTrees + (2 * markedHeapNodesCounter);
    }

    public static int totalLinks() {
        return totalLinks;
    }

    public static int totalCuts() {
        return totalCuts;
    }

    private void updateMin(HeapNode posMin) {
        if (posMin.getKey() < this.min.getKey()) {
            this.min = posMin;
        }
    }

    private void cascadingCuts(HeapNode curr) {
        if (!curr.isMarked()) { 
            curr.mark();
            if (!curr.isRoot()) {
                this.markedHeapNodesCounter++;
            }
        } else {
            if (curr.isRoot()) {
                return;
            }
            HeapNode prevParent = curr.parent;
            this.cut(curr);
            this.cascadingCuts(prevParent);
        }
    }

    private void cut(HeapNode curr) {
        curr.parent.rank--;
        if (curr.marked) {
            this.markedHeapNodesCounter--;
            curr.marked = false;
        }
        if (curr.parent.child == curr) { 
            if (curr.next == curr) { 
                curr.parent.child = null;
            } else { 
                curr.parent.child = curr.next;
            }
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = curr;
        curr.prev = curr;
        curr.parent = null;
        this.min.setNext(curr);
        this.updateMin(curr);
        this.numOfTrees++;
        totalCuts++;
    }

    private void successiveLink(HeapNode curr) {
        HeapNode[] buckets = this.toBuckets(curr);
        this.min = this.fromBuckets(buckets);
    }

    private HeapNode[] toBuckets(HeapNode curr) {
        HeapNode[] buckets = new HeapNode[(int) Math.floor(Math.log(this.size()) / Math.log(GOLDEN_RATIO)) + 1];
        curr.prev.next = null;
        HeapNode tmpCurr;
        while (curr != null) {
            tmpCurr = curr;
            curr = curr.next;
            tmpCurr.next = tmpCurr;
            tmpCurr.prev = tmpCurr;
            while (buckets[tmpCurr.rank] != null) {
                tmpCurr = this.link(tmpCurr, buckets[tmpCurr.rank]);
                buckets[tmpCurr.rank - 1] = null;
            }
            buckets[tmpCurr.rank] = tmpCurr;
        }
        return buckets;
    }

    private HeapNode fromBuckets(HeapNode[] buckets) {
        HeapNode tmpMin = null;
        this.numOfTrees = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                this.numOfTrees++;
                if (tmpMin == null) {
                    tmpMin = buckets[i];
                    tmpMin.next = tmpMin;
                    tmpMin.prev = tmpMin;
                } else {
                    tmpMin.setNext(buckets[i]);
                    if (buckets[i].getKey() < tmpMin.getKey()) {
                        tmpMin = buckets[i];
                    }
                }
            }
        }
        return tmpMin;
    }

    private HeapNode link(HeapNode c1, HeapNode c2) {
        if (c1.getKey() > c2.getKey()) {
            HeapNode c3 = c1;
            c1 = c2;
            c2 = c3;
        }
        if (c1.child == null) {
            c1.child = c2;
        } else {
            c1.child.setNext(c2);
        }
        c2.parent = c1;
        c1.rank++;
        totalLinks++;
        return c1;
    }

    public class HeapNode {

        public int key;
        private int rank;
        private boolean marked;
        private HeapNode child;
        private HeapNode next;
        private HeapNode prev;
        private HeapNode parent;

        public HeapNode(int key) {
            this.key = key;
            this.marked = false;
            this.next = this;
            this.prev = this;
        }

        public int getKey() {
            return this.key;
        }

        private boolean isMarked() {
            return this.marked;
        }

        private void mark() {
            if (this.isRoot()) {
                return;
            } 
            this.marked = true;
        }

        private void setNext(HeapNode newNext) {
            HeapNode tmpNext = this.next;
            this.next = newNext;
            this.next.prev.next = tmpNext;
            tmpNext.prev = newNext.prev;
            this.next.prev = this;
        }

        private HeapNode getNext() {
            return this.next;
        }

        private boolean isRoot() {
            return (this.parent == null);
        }
    }
}
