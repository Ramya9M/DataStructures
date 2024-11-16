package Tries;

public class LongestCommonPrefix {

    class Node{
        Node[] links;
        int wordCount;
        boolean isLeaf;

        Node(){
            links = new Node[26];
            wordCount = 0;
            isLeaf = false;
        }

        boolean containsKey(char ch){
            return (links[ch-'a']!=null);
        }

        void put(char ch, Node node){
            links[ch-'a'] = node;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        void incrementWC(){
            wordCount++;
        }

        void setLeaf(){
            isLeaf = true;
        }
    }

    private Node root;

    LongestCommonPrefix(){
        root = new Node();
    }

    void insert(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
                node.incrementWC();
            }
            node = node.get(word.charAt(i));
        }
        node.setLeaf();
    }

    int countChildren(Node node){
        int count = 0;
        for(int i=0; i<26; i++){
            if(node.links[i]!=null)
                count++;
        }
        return count;
    }


    char getChar(Node node){

        for(int i=0; i<26; i++){
            if(node.links[i]!=null) {
                node = node.links[i];
                return (char)(i+'a');
            }
        }
        return 0;
    }

    String findPrefix(){

        Node node = root;
        String res = "";

        while(countChildren(node)==1) {
            res += getChar(node);
            node = node.get(getChar(node));

        }
        return res;
    }

    String lcp(String word){

        Node node = root;
        String res = "";
        for(int i=0; i<word.length(); i++){

            if(node.containsKey(word.charAt(i)) && countChildren(node)==1){
                res += getChar(node);
                node = node.get(word.charAt(i));
            }
        }
        return res;
    }

    public static String longestCommonPrefix(String[] strs) {

        LongestCommonPrefix lc = new LongestCommonPrefix();
        String min = strs[0];
        for(String s : strs) {
            if(s.equals(""))
                return "";
            lc.insert(s);
            min = s.length()<min.length()? s : min;
        }

        return lc.lcp(min);
    }


    public static void main(String[] args) {

        String[] s = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s));
    }




}
