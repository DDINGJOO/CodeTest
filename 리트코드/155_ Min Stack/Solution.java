class MinStack {
    private int[] values = new int[16];
    private int[] mins = new int[16];
    private int size;
    private int minSize;

    public MinStack() {
    }
    
    public void push(int val) {
        if (size == values.length) {
            int[] next = new int[size << 1];
            System.arraycopy(values, 0, next, 0, size);
            values = next;
        }

        values[size++] = val;

        if (minSize == 0 || val <= mins[minSize - 1]) {
            if (minSize == mins.length) {
                int[] next = new int[minSize << 1];
                System.arraycopy(mins, 0, next, 0, minSize);
                mins = next;
            }

            mins[minSize++] = val;
        }
    }
    
    public void pop() {
        int removed = values[--size];

        if (removed == mins[minSize - 1]) {
            minSize--;
        }
    }
    
    public int top() {
        return values[size - 1];
    }
    
    public int getMin() {
        return mins[minSize - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
