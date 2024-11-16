package Tries;

public class SuffixTrie {

    class Node{

        Node[] links;
        int wordCount;

        Node(){
            links = new Node[26];
            wordCount = 0;
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

        void incrementWC(){
            wordCount++;
        }
    }

    private Node root;

    SuffixTrie(){
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
                node.incrementWC();
            }
            temp = temp.substring(1);
            node = root;
        }
    }

    int searchPrefix(String word){

        Node node = root;

        for(int i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i)))
                return 0;
            node = node.get(word.charAt(i));
        }
        return node.wordCount;
    }


    public static void main(String[] args) {

        SuffixTrie st = new SuffixTrie();
        st.insert("kishan");
        st.insert("kis");
        st.insert("kish");
        st.insert("kishj");
        System.out.println(st.searchPrefix("ish"));
    }
}
