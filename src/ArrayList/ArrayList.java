public class ArrayList {

    /**
     * Created by Saad Ahmed on April 16, 2022
     */

    int list[] = new int[2];
    int size = 0;

    public void add(int data){
        if (list.length == size){
            int newList[] = new int[list.length * 2];
            for (int i=0; i<list.length; i++){
                newList[i] = list[i];
            }
            list = newList;
        }

        list[size] = data;
        size++;
    }

    public void add(int index, int data){

        if(index == size){
            System.out.println("Index cannot be greater than " + (size-1));
            return;
        }

        int newList[] = new int[list.length + 1];

        for (int i=0, j=0; i<newList.length; i++){
            if (i == index){
                newList[i] = data;
            }
            else {
                newList[i] = list[j];
                j++;
            }
        }
        list = newList;
        size++;
    }

    public void remove(int index){

        if(index == size){
            System.out.println("Index cannot be greater than " + (size-1));
            return;
        }

        int newList[] = new int[list.length];

        for (int i=0, j=0; i<list.length; i++){
            if (i != index){
                newList[j] = list[i];
                j++;
            }
        }
        list = newList;
        size--;
    }

    public void replace(int index, int data){

        if(index == size){
            System.out.println("Index cannot be greater than " + (size-1));
            return;
        }

        int newList[] = new int[list.length];

        for (int i=0; i<list.length; i++){
            if (i == index){
                newList[i] = data;
            }
            else {
                newList[i] = list[i];
            }
        }

        list = newList;
    }

    public int get(int index){
        return list[index];
    }

    public int size(){
        return size;
    }

    public void clear(){
        int newList[] = new int[2];
        list = newList;
        size = 0;
    }
    
}
