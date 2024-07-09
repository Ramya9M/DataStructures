package GoldmanSachs;

public class DetectCycleInLL {

    static class Node{
        int data;
        Node next;
        Node(){}
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean detectCycle(Node head){

        Node slow = null;
        Node fast = null;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast==slow)
                return true;
        }
        return false;
    }

    public static void main(String args[]){

        int[] arr = new int[]{1,2,3,4,5};
        Node head = new Node(arr[0]);
        Node prev = head;
        Node temp = null;
        Node mid  = null;
        for(int i=1; i<arr.length; i++){
            temp = new Node(arr[i]);
            if(i==3)
                mid = temp;
            prev.next = temp;
            prev = temp;
        }
        temp.next = mid;
        System.out.println(detectCycle(head));
    }
}
