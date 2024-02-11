/* 
Task:
The task is to complete the function recamanSequence() which takes n as the input parameter and returns the sequence.

Cases :-
a(0) = 0
a(n) = a(n-1) - n, if a(n-1) - n > 0 and is not included in the sequence previously
       =  a(n-1) + n otherwise.
*/


import java.util.*;

public class Recamans_sequence{
    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        Set<Integer>set=new HashSet<>();
        
        al.add(0);
        set.add(0);
        
        for(int i=1;i<n;i++){
            int ans=al.get(i-1)-i;
            
            if(ans>0&&!set.contains(ans)){
                al.add(ans);
                set.add(ans);
            }
            else{
                al.add(al.get(i-1)+i);
                set.add(al.get(i-1)+i);
            }
        }
        return al;
    }


    // Main class 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        
        ArrayList<Integer> sequence = Recamans_sequence.recamanSequence(n);
        
        System.out.println("Recamán Sequence up to n = " + n + ":");
        for (int num : sequence) {
            System.out.print(num + " ");
        }
    }
}