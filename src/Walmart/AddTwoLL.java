package Walmart;

class Nod{

    int data;
    Nod next;

    Nod(int data){
        this.data = data;
        this.next = null;
    }


}
public class AddTwoLL {

    public static Nod addLL(Nod head1, Nod head2){

        Nod t1 = head1;
        Nod t2 = head2;
        int carry = 0;
        int sum = 0;
        Nod dummy = new Nod(0);
        Nod temp = dummy;

        while(null!=t1 ||   null!=t2 || carry==1){

            sum = carry;
            if(null != t1){
                sum += t1.data;
            }
            if(null != t2){
                sum += t2.data;
            }
            Nod nn = new Nod(sum%10);
            carry = sum/10;

            temp.next = nn;
            temp = nn;
            if(null!=t1)
             t1 = t1.next;

            if(null != t2)
             t2 = t2.next;

        }

        return dummy.next;

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        Nod prev = null;
        Nod head1 = null;
        Nod head2 = null;


        for(int i=0; i<nums.length; i++){
            Nod node = new Nod(nums[i]);
            if(i==0){
                prev = node;
                head1 = node;
            }
            else{
                prev.next=node;
                prev = node;
            }
        }

        int[] nums2 = new int[]{1,2,3,4,5};

        for(int i=0; i<nums2.length; i++){
            Nod node = new Nod(nums[i]);
            if(i==0){
                prev = node;
                head2 = node;
            }
            else{
                prev.next=node;
                prev = node;
            }
        }

        head1 = addLL(head1,head2);

        while(head1!=null){
            System.out.println(head1.data);
            head1 = head1.next;
        }
    }
}
