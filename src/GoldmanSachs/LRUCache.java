package GoldmanSachs;

import java.util.*;
public class LRUCache {

    int capacity;
    Map<Integer, Node> hashMap = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0,0);

    class Node{

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key   = key;
            this.value = value;
            prev = next = null;
        }
    }

    LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void insert(Node node){
        hashMap.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    void remove(Node node){
        hashMap.remove(node.key,node);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int getKey(int key){
        if(hashMap.containsKey(key)){
            Node node = hashMap.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(hashMap.containsKey(key))
            remove(hashMap.get(key));
        if(hashMap.size() == capacity)
            remove(tail.prev);
        insert(new Node(key,value));
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,10);
        lruCache.put(3,15);
        lruCache.put(2,12);
        System.out.println(lruCache.getKey(3));
        lruCache.put(4,20);
        System.out.println(lruCache.getKey(2));
        lruCache.put(4,25);

    }
}
