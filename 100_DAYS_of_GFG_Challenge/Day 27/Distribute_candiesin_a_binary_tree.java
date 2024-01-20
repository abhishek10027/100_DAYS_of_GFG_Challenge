/* 
Task :-

Task is to complete the function distributeCandy() which takes the root of the tree as input and 
returns the number of moves required such that every node has exactly one candy.

*/




public class Distribute_candiesin_a_binary_tree{
    static int num_moves;
    public static int distributeCandy(Node root)
    {
        //code here
        num_moves = 0;
        give_candies(root);
        return num_moves;
    }
    
    public static int give_candies(Node node){
        if(node == null) return 0;
        
        int left = give_candies(node.left);
        int right = give_candies(node.right);
         num_moves += Math.abs(left) + Math.abs(right);
        return node.data + left + right -1;
    }
}