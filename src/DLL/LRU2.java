package DLL;


import java.util.*;
public class LRU2 {

   int MAX_Cap;
   Node head = new Node(0,0);
   Node tail = new Node(0, 0);

   HashMap<Integer, Node> hm = new HashMap<>();

   LRU2(int cap){
       this.MAX_Cap = cap;
       head.next = tail;
       tail.prev = head;
   }

   class Node{
       int key;
       int value;
       Node prev;
       Node next;
       Node(int key, int val){
           this.key = key;
           this.value = val;
           this.prev = this.next = null;
       }
   }


   //insert
    public void insert(Node node){
       hm.put(node.key, node);
       node.next = head.next;
       node.next.prev = node;
       head.next = node;
       node.prev = head;
    }

    //remove
    public void remove(Node node){
       hm.remove(node.key, node);
       node.next.prev = node.prev;
       node.prev.next = node.next;
    }

    //getKey
    public int getKey(int key){
       if(hm.containsKey(key)){
           Node node = hm.get(key);
           remove(node);
           insert(node);
           return node.value;
       }
       return  -1;
    }

    //put
    public void put(int key, int val){
       if(hm.containsKey(key))
           remove(hm.get(key));
       if(hm.size()==MAX_Cap)
           remove(tail.prev);
       insert(new Node(key,val));
    }

    public static void main(String[] args) {
        LRU1 lruCache = new LRU1(3);
        lruCache.put(1,10);
        lruCache.put(3,15);
        lruCache.put(2,12);
        System.out.println(lruCache.getKey(3));
        lruCache.put(4,20);
        System.out.println(lruCache.getKey(2));
        lruCache.put(4,25);
    }
}
