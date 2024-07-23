package Leetccode;

public class contest {

        public static int maximumEnergy(int[] energy, int k) {

            int n = energy.length;
            int finalAns = 0;
            int flag=0;
            for(int i=0; i<n; i++){
                int tempAns = 0;
                if(energy[i]>=0){
                    flag=1;
                    for(int j=i; j<n; j=j+k){
                        tempAns += energy[j];
                    }
                }
                finalAns = Math.max(finalAns,tempAns);
            }
            if(flag==0 && finalAns==0){
                finalAns = energy[0];
                for(int i=1; i<n; i++){
                    finalAns = Math.max(finalAns, energy[i]);
                }
            }
            return finalAns;
        }
    public static void main(String args[]){
        int[] energy = new int[]{-8,10,-10};
        int k = 1;
        int val = maximumEnergy(energy,k);
        System.out.println(val);
    }
}
