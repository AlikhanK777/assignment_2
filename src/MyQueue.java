public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void offer(T item) {
        list.addLast(item);
    }

    public T poll() {
        if (list.size() == 0) return null;
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
