
package GoldmanSachs;

import java.util.*;

public class QueueUsingStack {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void push(int x){
        input.push(x);
    }

    int pop(){
        if(!output.isEmpty())
            return output.pop();
        else{
            while (!input.isEmpty()){
                int temp = input.pop();
                output.push(temp);
            }
            return output.pop();
        }
    }

    int top(){
        if(!output.isEmpty())
            return output.peek();
        else{
            while(!input.isEmpty()){
                int temp = input.pop();
                output.push(temp);
            }
            return output.peek();
        }
    }

    public static void main(String[] args) {

        QueueUsingStack qs = new QueueUsingStack();
        qs.push(1);
        qs.push(5);
        qs.push(2);
        qs.push(9);
        qs.push(3);
        System.out.println(qs.pop());
        System.out.println(qs.top());
        qs.push(1);
        System.out.println(qs.pop());
    }

}
