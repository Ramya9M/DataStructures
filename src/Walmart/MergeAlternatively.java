package Walmart;

public class MergeAlternatively {

    public static String merge(String s1, String s2){

        StringBuilder res = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();

        int i=0, j=0;

        while(i<n1 && j<n2){

            res.append(s1.charAt(i));
            res.append(s2.charAt(j));
            i++;
            j++;
        }
        if(i<n1){
            while(i<n1){
                res.append(s1.charAt(i));
                i++;
            }
        }
        if(j<n2){
            while(j<n2){
                res.append(s2.charAt(j));
                j++;
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {

        String s1 = "ABCIO";
        String s2 = "DEF";

        System.out.println(merge(s1,s2));
    }
}
