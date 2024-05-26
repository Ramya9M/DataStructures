package LinkedList;

public class MergeTwoSortedLinkedList {

     public static int findLength(Node head){

         int length = 0;
         while(head!=null){
             length++;
             head = head.next;
         }
         return length;
     }

     public static Node mergeSort(Node head1,Node head2){

         Node temp1 = head1;
         Node temp2 = head2;

         Node dummyNode = new Node();
         Node temp = dummyNode;

         while(temp1!=null && temp2!=null){

             if(temp1.data<temp2.data){
                 temp.next = temp1;
                 temp  = temp1;
                 temp1 = temp1.next;
             }
             else{
                 temp.next = temp2;
                 temp  = temp2;
                 temp2 = temp2.next;
             }
         }

         while(temp1!=null){
             temp.next = temp1;
             temp  = temp1;
             temp1 = temp1.next;
         }
         while(temp2!=null){
             temp.next = temp2;
             temp  = temp2;
             temp2 = temp2.next;
         }
         return dummyNode.next;
     }

     public static void main(String args[]){

         int a1[] = new int[]{0,1,5,6};
         int a2[] = new int[]{2,4,8};

         Node head1 = generateLLFromArray.convertToLL(a1);
         Node head2 =  generateLLFromArray.convertToLL(a2);


         Node head = mergeSort(head1,head2);

         while(head!=null){
             System.out.println(head.data);
             head = head.next;

         }
     }
}
