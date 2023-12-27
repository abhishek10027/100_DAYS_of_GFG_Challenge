import java.util.*;
public class Anti_Diagonal_Traversal_of_Matrix{
    public static int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code her
        int n=matrix.length;
        int k=0;
        int x=0;
        
        int arr[]=new int [n*n];
        
        // upper triangle
        for(int i=0;i<n;i++){
            k=0;
            for(int j=i;j>=0;j--){
                arr[x++]=matrix[k++][j];
            }
        }
        
        // lower triangle
        
        for(int i=1;i<n;i++){
            k=i;
            for(int j=n-1;j>=i;j--){
                arr[x++]=matrix[k++][j];
            }
        }
        return arr;

    }

    public static void main(String args[]){
        int arr[][]={
            {3,2,3},
            {4,5,1},
            {7,8,9}
        };
        int res[]=antiDiagonalPattern(arr);
        System.out.println("The output is:- ");
        
        // Arrays.toString() for print the array
        System.out.println(Arrays.toString(res));
    }
}