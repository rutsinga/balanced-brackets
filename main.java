

public class Main {
    public static void main(String[] args) {
        SLinkedList<Integer> list = new SLinkedList<>();
        list.addFirst(10);
        list.addFirst(29);
        list.addFirst(20);
        list.addLast(5);
        list.display();

        SLinkedList<Integer> l2 = new SLinkedList<>();
        l2.addFirst(10);
        l2.addFirst(40);
        l2.addFirst(20);
        l2.addLast(5);
        l2.addFirst(30);
        l2.display();

        System.out.println(l2.getFirst());
        System.out.println(l2.getLast());
        System.out.println(l2.contains(20));
        System.out.println(l2.contains(100));
    }
}