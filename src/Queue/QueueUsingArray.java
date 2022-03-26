package Queue;

public class QueueUsingArray {

    /*
     * Created by Saad Ahmed on 27-March, 2022
     * Making a Queue Class using Array
     * */

    public static class Queue{
        int[] array;
        int size;
        int rear = -1;

        Queue(int size){
            array = new int[size];
            this.size = size;
        }

        public boolean isEmpty(){
            return rear == -1;
        }

        public void enQueue(int data){
            if (rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            array[rear] = data;
        }

        public int deQueue(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int front = array[0];

            for (int i=0; i<rear; i++){
                array[i] = array[i+1];
            }
            rear--;

            return front;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return  array[0];
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
