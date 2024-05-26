package LinkedList;

public class lengthOfLL {
    public static Node convertToLL(int[] a){
        Node head = new Node(a[0]);
        Node mover = head;
        for(int i=1; i<a.length; i++){
            Node temp = new Node(a[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void main(String args[]){
        int[] arr = new int[]{0,1,2,3,4,5};
        Node head = convertToLL(arr);
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        System.out.println(count);
    }
}
