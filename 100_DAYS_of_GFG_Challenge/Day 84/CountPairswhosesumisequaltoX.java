/* 
Task:
To implement the given function countPairs() that take two linked list head1 and head2 and 
return the count of distinct pairs whose sum is equal to x.
*/

import java.util.*;

public class CountPairswhosesumisequaltoX {
    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : head1) {
            hm.put(i, 1);
        }

        for (int j : head2) {
            if (hm.containsKey(x - j))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input:");
        System.out.print("head1 = ");
        String head1Input = scanner.nextLine();
        LinkedList<Integer> head1 = new LinkedList<>();
        String[] head1Elements = head1Input.split("->");
        for (String element : head1Elements) {
            head1.add(Integer.parseInt(element));
        }

        System.out.print("head2 = ");
        String head2Input = scanner.nextLine();
        LinkedList<Integer> head2 = new LinkedList<>();
        String[] head2Elements = head2Input.split("->");
        for (String element : head2Elements) {
            head2.add(Integer.parseInt(element));
        }

        System.out.print("x = ");
        int x = scanner.nextInt();

        int result = countPairs(head1, head2, x);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
