
/*
Task :- 

Complete the Insert and Search functions for a Trie Data Structure. 

Insert: Accepts the Trie's root and a string, modifies the root in-place, and returns nothing.

Search: Takes the Trie's root and a string, returns true if the string is in the Trie, otherwise false.

Note: To test the correctness of your code, the code-judge will be inserting a list of N strings called into the Trie, and 
then will search for the string key in the Trie. The code-judge will generate 1 if the key is present in the Trie, else 0. 

*/



public class Insert_and_Search_in_a_Trie{
    static void insert(TrieNode root, String key) 
{
    // Your code here
    for(char ch: key.toCharArray()){
        if(root.children[ch-'a'] == null){
            root.children[ch-'a'] = new TrieNode();
        }
        root = root.children[ch-'a'];
    }
    root.isEndOfWord = true;
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key)
{
    // Your code here
    for(char ch: key.toCharArray()){
        if(root.children[ch-'a'] == null){
            return false;
        }
        root = root.children[ch-'a'];
    }
    return root.isEndOfWord;
}
}