package Queue;

public class CircularQueue {

    /*
     * Created by Saad Ahmed on 27-March, 2022
     * Making a Circular Queue Class using Array
     * */

    public static class Queue{
        int[] array;
        int size;
        int rear = -1;
        int front = -1;

        Queue(int size){
            array = new int[size];
            this.size = size;
        }

        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public boolean isFull(){
            return (rear + 1) % size == front;
        }

        public void enQueue(int data){
            if (isFull()){
                System.out.println("Queue is full");
                return;
            }

            if (front == -1){
                front = 0;
            }

            rear = (rear + 1) % size;
            array[rear] = data;
        }

        public int deQueue(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int res = array[front];

            if (front == rear){
                front = rear = -1;
            }
            else{
                front = (front + 1) % size;
            }

            return res;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return  array[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(4);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.deQueue();
        }
    }
}
