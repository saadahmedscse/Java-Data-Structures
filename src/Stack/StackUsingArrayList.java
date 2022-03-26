package Stack;

import java.util.ArrayList;

public class StackUsingArrayList {

    /*
     * Created by Saad Ahmed on 26-March, 2022
     * Making a Stack Class using ArrayList functionalities
     * */

    public static class Stack{
        private static final ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if (isEmpty()){
                return -1;
            }

            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public static int peek(){
            if (isEmpty()){
                return -1;
            }

            return list.get(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while (!Stack.isEmpty()){
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
