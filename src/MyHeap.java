import java.util.ArrayList;

public class MyHeap<T extends Comparable<T>> {
    private ArrayList<T> heap = new ArrayList<>();

    public void add(T item) {
        heap.add(item);
        up(heap.size() - 1);
    }

    public T poll() {
        if (heap.isEmpty()) return null;
        T top = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            down(0);
        }
        return top;
    }

    public T peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void up(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(idx).compareTo(heap.get(parent)) >= 0) break;
            swap(idx, parent);
            idx = parent;
        }
    }

    private void down(int idx) {
        int n = heap.size();
        while (true) {
            int left = idx * 2 + 1, right = idx * 2 + 2, smallest = idx;
            if (left < n && heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
            if (right < n && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
            if (smallest == idx) break;
            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
