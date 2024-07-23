package Trees;


public class PostOrderTraversal {


    public static void postOrder(Node root){

        if(root == null)
             return ;

        postOrder(root.left);
        System.out.println(root.data);
        postOrder(root.right);
    }


    public static String clearDigits(String s) {

        StringBuilder str = new StringBuilder(s);
        int i=0;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))){
                str.deleteCharAt(i);
                if(i!=0){
                    str.deleteCharAt(i-1);
                    i=0;
                }
            }
            i++;
        }
        System.out.println("string"+ s);
        return str.toString();
    }

    public static void main(String args[]){

        clearDigits("cb34");
    }
}
