package Trees;

import java.util.*;
class Nodes{

    int data;
    Nodes left;
    Nodes right;
    Nodes nxt;

    Nodes(int data){
        this.data = data;
        left = right= nxt = null;
    }
}
public class NextPointer {

    public static void nextPointer(Nodes root){

        if(root == null)
            return ;

        Queue<Nodes> queue = new LinkedList<Nodes>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            Nodes prev = null;

            while (size > 0) {

                Nodes node = queue.remove();

                if (prev != null) {
                    prev.nxt = node;
                }
                prev = node;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                size--;
            }
        }
    }

    public static void main(String args[]){

        Nodes root = new Nodes(1);
        root.left = new Nodes(2);
        root.right = new Nodes(3);
        nextPointer(root);
    }
}
