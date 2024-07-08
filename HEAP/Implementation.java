class MinHeap {
    private int size;
    private int capacity;
    private int[] minHeap;

    public MinHeap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.minHeap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int k) {
        if (size == capacity)
            return;
        size++;
        int i = size - 1;
        minHeap[i] = k;

        while (i != 0 && minHeap[parent(i)] > minHeap[i]) {
            int temp = minHeap[parent(i)];
            minHeap[parent(i)] = minHeap[i];
            minHeap[i] = temp;
            i = parent(i);
        }
    }

    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < size && minHeap[l] < minHeap[smallest])
            smallest = l;
        if (r < size && minHeap[r] < minHeap[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = minHeap[smallest];
            minHeap[smallest] = minHeap[i];
            minHeap[i] = temp;
            heapify(smallest);
        }
    }

    public int extractMin() {
        if (size == 0)
            return -1;
        if (size == 1) {
            size--;
            return minHeap[0];
        } else {
            int root = minHeap[0];
            minHeap[0] = minHeap[size - 1];
            size--;
            heapify(0);
            return root;
        }
    }

    public int getSize() {
        return size;
    }

    public int getElement(int idx) {
        if (idx >= size || idx < 0)
            return -1;
        return minHeap[idx];
    }

    public void decreaseKey(int i, int new_val) {
        if (i >= size || new_val > minHeap[i])
            return;
        minHeap[i] = new_val;
        while (i != 0 && minHeap[parent(i)] > minHeap[i]) {
            int temp = minHeap[parent(i)];
            minHeap[parent(i)] = minHeap[i];
            minHeap[i] = temp;
            i = parent(i);
        }
    }

    public void delete(int i) {
        if (i >= size)
            return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }
}
