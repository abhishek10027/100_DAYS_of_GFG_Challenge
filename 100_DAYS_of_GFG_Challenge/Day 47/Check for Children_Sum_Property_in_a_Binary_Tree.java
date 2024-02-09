
/* 
Task:

The task is to complete the function isSumProperty() that takes the root Node of the binary tree as input and 
returns 1 if all the nodes in the tree satisfy the following properties, else it returns 0.

*/



public class Check for Children_Sum_Property_in_a_Binary_Tree{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        return childsum(root)?1:0;
        
        
    }
    
    public static boolean childsum(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        
        int sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right !=null) sum+=root.right.data;
        
        return (root.data==sum && childsum(root.left) && childsum(root.right));
    }
}