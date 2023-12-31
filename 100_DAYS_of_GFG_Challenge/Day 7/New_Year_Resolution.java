public class New_Year_Resolution{
    public static boolean isPossible(int N, int[] coins) {
        // code here
        return find(0,0,coins);
    }
    
    static boolean find(int ind,int sum,int coins[]){
        if(sum>0 && (sum %20==0 || sum%24==0 || sum==2024)) return true;
        
        if(ind>=coins.length) return false;
        
        return find(ind+1,sum+coins[ind],coins)||find(ind+1,sum,coins);
    }

    public static void main(String args[]){
        int N = 8;
        int [] coins = {5, 8, 9, 10, 14, 2, 3, 5};

        boolean res=isPossible(N,coins);

        System.out.println("The output is :- "  + res);
    }
}
