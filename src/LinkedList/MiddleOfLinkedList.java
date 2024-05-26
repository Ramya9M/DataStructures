package LinkedList;

import java.util.*;

public class MiddleOfLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public static Node createLL(int[] arr){

        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){

            Node newNode = new Node(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }

    public static void main(String args[]){

        int[] arr = new int[]{1,2,3,44,5};
        Node head = createLL(arr);

//        while(head != null){
//            System.out.println(head.data);
//            head = head.next;
//        }

        Node middle = getMiddle(head);
        System.out.println(middle.data);

    }

    public static Node getMiddle(Node head){

        List<Node> ls = new ArrayList<>();

        while(head!=null){
            ls.add(head);
            head=head.next;
        }

        int middle = ls.size()/2;

        return ls.get(middle);

    }
}
