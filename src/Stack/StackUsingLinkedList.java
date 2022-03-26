package Stack;

public class StackUsingLinkedList {

    /*
    * Created by Saad Ahmed on 26-March, 2022
    * Making an Stack Class using Linked List functionalities
    * */

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public class Stack {
        private static Node head;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            int top = head.data;

            if (isEmpty()) {
                return -1;
            }
            head = head.next;

            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while (!Stack.isEmpty()) {
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
