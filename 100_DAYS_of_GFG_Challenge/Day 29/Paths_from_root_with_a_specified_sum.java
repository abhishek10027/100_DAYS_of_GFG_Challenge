/* 
Task :- 

Task is to complete the function printPaths() that takes the root of the tree and sum as input and 
returns a vector of vectors containing the paths that lead to the sum.
*/



public class Paths_from_root_with_a_specified_sum{
    public static void recurse(Node root,int currentSum ,int sum,
    ArrayList<ArrayList<Integer>> havingSumPaths , ArrayList<Integer> path){
       if(root==null){
           return ;
       }
       path.add(root.data);
       if(currentSum + root.data ==sum){
           havingSumPaths.add(new ArrayList<>(path));
       }
       
       recurse(root.left,currentSum+root.data,sum,havingSumPaths,path);
       recurse(root.right,currentSum + root.data,sum,havingSumPaths,path);
       path.remove(path.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        // code here
        
        ArrayList<ArrayList<Integer>> havingSumPaths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        recurse(root,0,sum,havingSumPaths,path);
        return havingSumPaths;
        
    }

}