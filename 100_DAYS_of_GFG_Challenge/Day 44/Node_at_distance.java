/* 
Task:
 Complete the function printKDistantfromLeaf() that takes root node and k as inputs and 
returns the number of nodes that are at distance k from a leaf node. 
*/



public class Node_at_distance{
    int c=0;
    //Function to return count of nodes at a given distance from leaf nodes.
    int printKDistantfromLeaf(Node root, int k)
    {
        // Write your code here
        c=0;
        f(root,k,new ArrayList<Node>(),new HashSet<Node>());
        return c;
    }
    void f(Node root, int k, ArrayList<Node> a, HashSet<Node> s)
    {
        if(root==null)
            return;
      
        a.add(root);
        if(root.left==null && root.right==null)
        {
            if(a.size()>k)
            {
                if(!s.contains(a.get(a.size()-k-1)))
                {
                    s.add(a.get(a.size()-k-1));
                    c++;
                }
            }    
        }
        f(root.left,k,a,s);
        f(root.right,k,a,s);
        a.remove(a.size()-1);
    }
}