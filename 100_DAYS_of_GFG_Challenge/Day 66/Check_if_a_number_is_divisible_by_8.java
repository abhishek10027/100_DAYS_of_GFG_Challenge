
/* 
Task:
The task is to complete the function DivisibleByEight() which takes a string s as the input and
 returns 1 if the number is divisible by 8, else it returns -1.


*/




import java.util.*;

public class Check_if_a_number_is_divisible_by_8{
    // Function to check whether the given number is divisible by 8.
    public static int DivisibleByEight(String s) {
        // Extract the last three digits of the string.
        String lastThreeDigits = s.substring(Math.max(s.length() - 3, 0));

        // Convert the last three digits to an integer.
        int lastThreeDigitsInt = Integer.parseInt(lastThreeDigits);

        // Check if the last three digits are divisible by 8.
        if (lastThreeDigitsInt % 8 == 0) {
            return 1; // Return 1 if divisible by 8.
        } else {
            return -1; // Return -1 otherwise.
        }
    }

    // main class 

    public static void main(String args[]){
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter your number :");
        String s=sc.nextLine();
        int res =DivisibleByEight(s);

        if(res==1){
            System.out.println("Output :- \n"+ res + " Means"+" The number is divisible by 8. ");
        }
        else {
            System.out.println("Output :- \n"+ res + " Means"+" The number is not divisible by 8. ");
        }
    }
}