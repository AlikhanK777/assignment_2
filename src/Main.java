public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5, 7);
        list.add(10, 7);
        list.addFirst(1);
        list.addLast(15);
        list.add(2, 7);
        System.out.println("List:");
        for (Integer x : list) System.out.print(x + " ");
        System.out.println();


        MyStack<String> stack = new MyStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("\nStack:");
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        System.out.println();


        MyQueue<Double> queue = new MyQueue<>();
        queue.offer(1.1);
        queue.offer(2.2);
        queue.offer(3.3);
        System.out.println("\nQueue:");
        while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
        System.out.println();


        MyHeap<Integer> heap = new MyHeap<>();
        heap.add(7);
        heap.add(3);
        heap.add(9);
        heap.add(1);
        heap.add(5);
        System.out.println("\nHeap:");
        while (!heap.isEmpty()) System.out.print(heap.poll() + " ");
        System.out.println();
    }
}
