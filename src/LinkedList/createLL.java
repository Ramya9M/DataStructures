package LinkedList;

class Node{
    int data;
    Node next;

    Node(){

    }

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}
public class createLL {

    public static void main(String args[]) {


    int[] arr = new int[]{1, 2, 3, 4};
    Node x = new Node(arr[0]);
    System.out.println(x.data);
    System.out.println(x.next);
}

}
