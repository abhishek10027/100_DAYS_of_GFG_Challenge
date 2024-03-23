/* 
Task:
The task is to complete the function insertAtBottom() which takes a stack st and an integer x as inputs and
returns the modified stack after insertion.
*/



import java.util.*;

public class InsertanElementattheBottomofaStack {
    public static Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> s = new Stack<>();
        s.push(x);

        for (int i : st) {
            s.push(i);
        }
        return s;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        System.out.println("Enter the value of X: ");
        int x = sc.nextInt();

        Stack<Integer> res = insertAtBottom(st, x);
        System.out.println("Stack after insertion:");
        for (int j : res) {
            System.out.print(j + " ");
        }
    }
}
