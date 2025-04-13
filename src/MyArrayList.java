import Interfaces.MyList;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr;
    private int len;

    public MyArrayList() {
        arr = new Object[5];
        len = 0;
    }

    private void grow() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < len; i++) newArr[i] = arr[i];
        arr = newArr;
    }


    public void add(T item) {
        if (len == arr.length) grow();
        arr[len++] = item;
    }

    @Override
    public void add(T item, int index) {

    }


    public void add(int idx, T item) {
        if (idx < 0 || idx > len) return;
        if (len == arr.length) grow();
        for (int i = len; i > idx; i--) arr[i] = arr[i - 1];
        arr[idx] = item;
        len++;
    }


    public void set(int idx, T item) {
        if (idx < 0 || idx >= len) return;
        arr[idx] = item;
    }


    public void addFirst(T item) {
        add(0, item);
    }


    public void addLast(T item) {
        add(item);
    }


    public T get(int idx) {
        if (idx < 0 || idx >= len) return null;
        return (T) arr[idx];
    }


    public T getFirst() {
        return get(0);
    }


    public T getLast() {
        return get(len - 1);
    }


    public T remove(int idx) {
        if (idx < 0 || idx >= len) return null;
        for (int i = idx; i < len - 1; i++) arr[i] = arr[i + 1];
        len--;
        return null;
    }

    @Override
    public boolean remove(T item) {
        return false;
    }


    public void removeFirst() {
        remove(0);
    }


    public void removeLast() {
        remove(len - 1);
    }


    public void clear() {
        arr = new Object[5];
        len = 0;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }


    public int size() {
        return len;
    }


    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }


    public int indexOf(Object o) {
        for (int i = 0; i < len; i++) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }


    public void sort() {
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                Comparable a = (Comparable) arr[i];
                Comparable b = (Comparable) arr[j];
                if (a.compareTo(b) > 0) {
                    Object tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public Object[] toArray() {
        Object[] result = new Object[len];
        for (int i = 0; i < len; i++) result[i] = arr[i];
        return result;
    }


    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int cur = 0;
            public boolean hasNext() {
                return cur < len;
            }
            public T next() {
                return (T) arr[cur++];
            }
        };
    }
}
