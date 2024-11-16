package Walmart;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class ReverseLL {

    public static Node reverseLL(Node head){

        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4};
        Node prev = null;
        Node head = null;

        for(int i=0; i<nums.length; i++){
            Node node = new Node(nums[i]);
            if(i==0){
              prev = node;
              head = node;
            }
            else{
                prev.next=node;
                prev = node;
            }
        }

        prev = head;
        while(prev != null){
            System.out.println(prev.data);
            prev = prev.next;
        }

        prev = reverseLL(head);
        while(prev != null){
            System.out.println(prev.data);
            prev = prev.next;
        }
    }
}
