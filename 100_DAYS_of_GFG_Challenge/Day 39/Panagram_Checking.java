/* 
Task :-
Given a string s check if it is "Panagram" or not.

A "Panagram" is a sentence containing every letter in the English Alphabet.

*/



import java.util.*;
public class Panagram_Checking{

    public static boolean checkPangram  (String s){
        // check length if less than 26 then return flase/0

        if(s.length()<26) return false;

        // convert upper string into lowercase

        s=s.toLowerCase();

        // using set

        HashSet <Character> st=new HashSet<>();

        for(char i:s.toCharArray()){
            if(i>='a' && i<='z'){
                st.add(i);
            }
        }

        // check set size , if less than 26 than return false

        if(st.size()<26) return false;

        return true;
    }

    // main class 
    public static void main(String args [] ){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your String : ");
        String s=sc.nextLine();
        boolean res=checkPangram(s);

        if(res==true){
            System.out.println("The String Is Panagram String ");
        }
        else{
            System.out.println("The String Is Not A  Panagram String ");
        }
    }
}