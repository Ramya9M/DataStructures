package Tries;

import java.util.*;
public class WordBreak {

    class Node{

        Node[] links;
        boolean isend;

        Node(){
            links = new Node[26];
            isend = false;
        }

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void setEnd(){
            isend = true;
        }
    }

    private Node root;

    WordBreak(){
        root = new Node();
    }

    void insert(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i)))
                node.put(word.charAt((i)),new Node());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    boolean isPossible(String word){

        Node node = root;
        while(word.length()>0){
            int st = 0;
            node = root;
            for(int i=0; i<word.length(); i++){

                if(!node.containsKey(word.charAt(i)))
                    return false;
                node = node.get(word.charAt(i));
                if(node.isend) {
                    st = i;
                    break;
                }
            }
            word = word.substring(st+1);
        }
        if(node.isend)
         return true;
        else
            return false;
    }

    public boolean wordBreak(String s, List<String> w) {
        WordBreak wb = new WordBreak();
        for(String  str : w)
            wb.insert(str);
        return (wb.isPossible(s));
    }
    public static void main(String[] args) {

       WordBreak wb = new WordBreak();
       String s = "aaaaaaa";
       String[] wordDict = new String[]{"aaaa","aaa"};
       for(String  str : wordDict)
           wb.insert(str);
        System.out.println(wb.isPossible(s));
    }
}
