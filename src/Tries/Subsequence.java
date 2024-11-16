package Tries;

public class Subsequence {

    class Node{
        Node[] links;
        boolean endsWith;
        Node(){
            links = new Node[26];
            endsWith = false;
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
            endsWith = true;
        }
    }

    private Node root;

    Subsequence(){
        root = new Node();
    }

    void insert(String word){

        String temp = word;
        Node node = root;
        while(temp.length()>0){

            for(int i=0; i<temp.length();i++){

                if(!node.containsKey(temp.charAt(i)))
                    node.put(temp.charAt(i),new Node());
                node = node.get(temp.charAt(i));
            }
            node.setEnd();
            temp = temp.substring(1);
            node = root;
        }
    }

    int isSubsequence(String[] words){
        Node node = root;
        int count = 0;
        for(int j=0; j<words.length; j++){

            String temp = words[j];
            boolean flag = true;
            int i=0;
            while(i<temp.length()){

                if(node.endsWith==true && i!=temp.length()) {
                    flag = false;
                    break;
                }
                else if(node.get(temp.charAt(i))!=null) {
                    node = node.get(temp.charAt(i));
                    i++;
                }
            }
            if(flag)
                count++;
            node = root;
        }
        return count;
    }

    public static void numMatchingSubseq(String s, String[] words) {

        Subsequence sub = new Subsequence();
        sub.insert(s);
        System.out.println(sub.isSubsequence(words));
    }


    public static void main(String[] args) {
       String  s = "abcde";
       String[] words = new String[]{"a","bb","acd","ace"};
       numMatchingSubseq(s,words);
    }
}
