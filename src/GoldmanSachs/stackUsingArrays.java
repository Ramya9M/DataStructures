package GoldmanSachs;

public class stackUsingArrays {

    int size = 100;
    int arr[] = new int[size];
    int top = -1;

    void push(int x){
        top = top + 1;
        arr[top] = x;
    }

    int pop(){
        if(top != -1){
            int temp = arr[top];
            top = top -1;
            return temp;
        }
        return -1;
    }

    int top(){
        if(top != -1){
            return arr[top];
        }
        return -1;
    }

    int size(){
        return top+1;
    }



    public static void main(String args[]){

        stackUsingArrays stackUsingArrays = new stackUsingArrays();
        stackUsingArrays.push(3);
        stackUsingArrays.push(5);
        stackUsingArrays.push(2);
        stackUsingArrays.push(1);
        System.out.println(stackUsingArrays.pop());
        System.out.println(stackUsingArrays.top());
        System.out.println(stackUsingArrays.size());
        System.out.println(stackUsingArrays.pop());
        System.out.println(stackUsingArrays.pop());
        System.out.println(stackUsingArrays.size());
    }
}
