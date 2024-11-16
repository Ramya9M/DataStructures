package DLL;

import java.util.*;
public class LRU1 {

    int MAX_CAPACITY;
    Node head  = new Node(0, 0);
    Node tail = new Node(0, 0);

    HashMap<Integer, Node> hm = new HashMap<>();


    LRU1(int cap){
        MAX_CAPACITY = cap;
        head.next = tail;
        tail.prev = head;
    }

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    // insert

    public void insert(Node node){
        hm.put(node.key,node);
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
    public int getKey(int data){
        if(hm.containsKey(data)) {
          Node node = hm.get(data);
          remove(node);
          insert(node);
          return node.value;
        }
        return -1;
    }

    //putKeyValue
    public void put(int data, int val){

        if(hm.containsKey(data))
            remove(hm.get(data));
        if(hm.size()==MAX_CAPACITY)
            remove(tail.prev);
        insert(new Node(data,val));
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
