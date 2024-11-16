package Trees;

import Trees.traversals.TreeNode;
import com.sun.source.tree.Tree;
import java.util.*;
public class InvertBT {

    public static void invert(TreeNode curr){

        if(curr==null)
            return;

        invert(curr.left);
        invert(curr.right);

        TreeNode t = curr.left;
        curr.left = curr.right;
        curr.right = t;
    }

    public static int finalPositionOfSnake(int n, List<String> commands) {


        int i = 0;
        int j = 0;

        for(int k=0; k<n; k++){

            if(commands.get(k).equals("UP")){
                i--;
            }
            else if(commands.get(k).equals("RIGHT")){
                j++;
            }
            else if(commands.get(k).equals("DOWN")){
                i++;
            }
            else if(commands.get(k).equals("LEFT")){
                j--;
            }
        }
        int  res = ((i*n)+j);
        return res;
    }


    public static void main(String[] args) {

        int n = 2;
        List<String> s = new ArrayList<>();
        s.add("RIGHT");
        s.add("DOWN");
        finalPositionOfSnake(n, s);
    }
}
