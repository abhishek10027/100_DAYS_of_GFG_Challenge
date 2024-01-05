//Count possible ways to construct buildings


/*  Your Task:
You don't need to read or print anything. Your task is to complete the function TotalWays() 
which takes N as input parameter and returns the total possible ways modulo 109 + 7.*/


import java.util.*;
public class constructbuildings{
    public static int totalway(int N){
        int mod=1000000007;
        long scount=1;
        long bcount=1;

        for(int i=2;i<=N;i++){
            long newbcount=scount;
            long newscount=scount%mod+bcount%mod;

            bcount=newbcount;
            scount=newscount;
        }

        long total=scount%mod+bcount%mod;

        return (int) (total%mod*total%mod)%mod;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your N value: ");
        int n=sc.nextInt();

        int res=totalway(n);

        System.out.println("The total way is : "+res);
    }
}
 