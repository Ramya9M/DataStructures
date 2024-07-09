package GoldmanSachs;

public class reverseLinkedList {

    static class Node{
        int data;
        Node next;

        Node(){}

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseLL(Node head){

        Node curr = head;
        Node save = null;
        Node prev = null;

        while(curr!=null){
            save = curr.next;
            curr.next = prev;
            prev = curr;
            curr = save;
        }
        return prev;

    }

    public static void main(String args[]){

        int[] arr = new int[]{1,2,3,4};
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        temp = reverseLL(head);
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
