package LinkedList;

import java.util.*;
import static LinkedList.generateLLFromArray.convertToLL;

public class isPalindrome {

    public static boolean isPalin(Node head){

        Node temp = head;

        Stack<Integer> stack = new Stack<Integer>();

        while(temp!=null){
            stack.add(temp.data);
            temp = temp.next;
        }
        boolean flag = true;
        while(head!=null){
            if(stack.pop()==head.data){
                head = head.next;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String args[]){

        int[] arr = new int[]{1,2,2,1};
        Node head = convertToLL(arr);
        System.out.println(isPalin(head));
    }
}
