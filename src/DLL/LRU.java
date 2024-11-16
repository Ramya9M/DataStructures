package DLL;

public class LRU {

    int MAX_SIZE = 3;
    Node head = null;

    class Node{
        int data;
        Node prev;
        Node next;

        Node(){}
        Node(int data){
            this.data = data;
            this.prev = this.next = null;
        }
    }

    public Node addNode(int data){
        int len = findDLLLength();
        if(null == head){
            Node node = new Node(data);
            head = node;
        }
        else{
            if(len<MAX_SIZE) {
                Node temp = new Node();
                temp = head;
                Node prev = null;
                while (temp != null) {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = new Node(data);
                prev.next.prev = prev;
            }
            else{
                System.out.println("some other node need to be replaced");
            }
        }
        return head;
    }

    public int findDLLLength(){
        Node temp = head;
        int count = 0;
        while(null != temp){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean isCacheContains(int data){
        Node node = head;
        while(null != node){
            if(node.data == data)
                return true;
            node = node.next;
        }
        return false;
    }

    private  void replaceWithFirst(int i) {

        Node temp = head;
        Node req = null;

        while(null != temp){
            if(temp.data==i){
                req = temp;
                break;
            }
            temp=temp.next;
        }

        if(null != req.next) {
            req.next.prev = req.prev;
            req.prev.next = req.next;
        }else{
            req.prev.next=null;
        }
        req.next = head;
        head.prev = req;
        head = req;

    }

    private void addToCacheToFirst(int i) {

        if(null != head) {
            Node req = new Node(i);
            req.next = head;
            head.prev = req;
            head = req;
        }else{
            Node req = new Node(i);
            head = req;
        }

    }

    private void removeAndAdd(int i) {

        Node temp = head;
        Node prev = null;
        while(null != temp){
            prev = temp;
            temp = temp.next;
        }
        prev.prev.next = null;
        prev.prev = null;
        Node req = new Node(i);
        req.next = head;
        head.prev = req;
        head = req;

    }

    public void printDLL(){
        Node node = head;
        while(null != node){
            System.out.println(node.data);
            node = node.next;
        }
    }


    public static void main(String[] args) {

        LRU lru = new LRU();

        int[] search = new int[]{1,2,1,4,1,2};
        for(int i : search){
            System.out.println("****** new search ********");
            if(lru.isCacheContains(i)){
                //swap with least recently used
                System.out.println("Replacing with the first position in cache");
                lru.replaceWithFirst(i);
            }
            else{
                System.out.println("PAGE FAULT");

                if(lru.findDLLLength()< lru.MAX_SIZE)
                    lru.addToCacheToFirst(i);
                else {
                    System.out.println("cache is FULL, replacing elements");
                    lru.removeAndAdd(i);
                }

            }
            lru.printDLL();
        }


//        Node head =  lru.addNode(2);
//        lru.addNode(1);
//        lru.addNode(3);
//        lru.addNode(4);
//        lru.addNode(12);
//
//        Node temp = head;
//        while(null != temp) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//
//        System.out.println(lru.findDLLLength(head));

    }



}
