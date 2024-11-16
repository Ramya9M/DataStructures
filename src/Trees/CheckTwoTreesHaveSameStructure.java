package Trees;

public class CheckTwoTreesHaveSameStructure {


    public  boolean isSameStructure(Node a, Node b ){

        if(a==null && b==null)
            return (a==b);


        return (a.data==b.data && isSameStructure(a.left,b.left) &&
                    isSameStructure(a.right, b.right));


    }

    public static void main(String[] args) {

        CheckTwoTreesHaveSameStructure chk = new CheckTwoTreesHaveSameStructure();

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);


        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(9);
        root2.left.left = new Node(0);

        System.out.println(chk.isSameStructure(root1,root2));


    }
}
