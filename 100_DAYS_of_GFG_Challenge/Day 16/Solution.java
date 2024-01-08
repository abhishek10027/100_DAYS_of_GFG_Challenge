/// Search Pattern (KMP-Algorithm)

/* Your task is to complete the function search() which takes the string txt and the string pat as inputs and 
returns an array denoting the start indices (1-based) of substring pat in the string txt. */



class Solution {
    ArrayList<Integer> search(String pat, String S) {
        ArrayList<Integer> indexes = new ArrayList<>();
        int index = 0;

        while (index != -1) {
            index = S.indexOf(pat, index);

            if (index != -1) {
                indexes.add(index + 1);
                index += 1; // Move one character ahead to avoid overlapping
            }
        }

        if (indexes.isEmpty()) {
            indexes.add(-1);
        }

        return indexes;
    }
}
