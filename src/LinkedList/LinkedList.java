package LinkedList;

public class LinkedList<T> {

    private Node head;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    private class Node{
        T data;
        Node next;

        Node(T data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    private boolean headIsEmpty(){
        if (head == null){
            System.out.println("List is empty");
            return true;
        }
        return false;
    }

    public void addFirst(T data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void add(T data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void addLast(T data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void deleteFirst(){
        if (!headIsEmpty()){
            size--;
            head = head.next;
        }
    }

    public void deleteLast(){
        if (!headIsEmpty()){
            Node lastNode = head.next;
            Node secondLastNode = head;

            size--;

            if (head.next == null){
                head = null;
                return;
            }

            while (lastNode.next != null){
                lastNode = lastNode.next;
                secondLastNode = secondLastNode.next;
            }

            secondLastNode.next = null;
        }
    }

    public int size(){
        return size;
    }

    public void printList(){
        if (!headIsEmpty()){
            Node currentNode = head;
            System.out.print("[");
            while (currentNode.next != null){
                System.out.print(currentNode.data + ", ");
                currentNode = currentNode.next;
            }

            while (currentNode != null){
                System.out.print(currentNode.data + "]");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }
}
