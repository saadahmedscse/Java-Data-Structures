package Queue;

public class QueueUsingLinkedList {

    /*
     * Created by Saad Ahmed on 27-March, 2022
     * Making a Queue Class using Linked List functionalities
     * */

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public static class Queue{
        private static Node head;
        private static Node tail;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        public static void enQueue(int data){
            Node newNode = new Node(data);

            if (tail == null){
                tail = head = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public static int deQueue(){
            if (isEmpty()){
                System.out.println("Queue is empty");;
                return -1;
            }

            int front = head.data;

            if (head == tail){
                tail = null;
            }

            head = head.next;
            return front;
        }

        public static int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");;
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {

        Queue.enQueue(1);
        Queue.enQueue(2);
        Queue.enQueue(3);
        Queue.enQueue(4);
        //Queue.deQueue();

        while (!Queue.isEmpty()){
            System.out.println(Queue.peek());
            Queue.deQueue();
        }
    }
}
