package Walmart;

import static Walmart.ReverseLL.reverseLL;

public class ReverseLLByK {

    public static Node reverseLLByK(Node head, int k){

        Node temp = head;
        Node prevLast = null;

        while(temp != null){

            Node kThNode = getKthNode(temp,k);
            if(kThNode == null){
                prevLast.next = temp;
                break;
            }

            Node nextNode = kThNode.next;
            kThNode.next = null;

            reverseLL(temp);

            if(temp==head)
                head = kThNode;
            else{
                prevLast.next = kThNode;
            }

            prevLast = temp;
            temp = nextNode;


        }

       return  head;

    }

    private static Node getKthNode(Node temp, int k){

        k= k-1;

        while(temp != null && k>=0){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
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
        head = reverseLLByK(head,2);

        while(head!= null){
            System.out.println(head.data);
            head = head.next;
        }


    }
}
