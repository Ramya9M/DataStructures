package Tries;

public class Trie {

    class Node{

        Node(){

            links = new Node[26];
            countPrefix = 0;
            countEndsWith = 0;
        }
        Node[] links;
        int countPrefix;
        int countEndsWith;
        boolean flag = false;

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch, Node node){
            links[ch-'a']=node;
        }

        Node get(char ch){
           return links[ch-'a'];
        }

        void setFlag(){
            flag = true;
        }

        boolean getFlag(){
            return flag;
        }

        void increasePrefix(){
            countPrefix++;
        }

        void reducePrefix(){
            countPrefix--;
        }

        void increaseEndsWith(){
            countEndsWith++;
        }

        void decreaseEndsWith(){
            countEndsWith--;
        }
    }

    private Node root;

    Trie(){
        root = new Node();

    }

    void insert(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();

        }
        node.setFlag();
        node.increaseEndsWith();
    }

    boolean search(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i)))
                return false;

            node = node.get(word.charAt(i));
        }
        return node.getFlag();
    }

    boolean startsWith(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        return node!=null;
    }

    int countWordsEqualTo(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i)))
                return 0;
            node = node.get(word.charAt(i));
        }
        return node.countEndsWith;
    }

    int countWordsStartingWith(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){

            if(!node.containsKey(word.charAt(i)))
                return 0;

            node = node.get(word.charAt(i));
        }
        return  node.countPrefix;
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("applx");
        trie.insert("applx");
        trie.insert("applx");
        System.out.println(trie.countWordsEqualTo("apple"));
    }
}
