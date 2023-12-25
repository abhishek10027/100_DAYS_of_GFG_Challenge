public class determinantOfMatrix{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        if(n==1){
            return matrix[0][0];
            
        }
        if(n==2){
            return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
        }
        
        int det=0;
        
        for(int i=0;i<n;i++){
            int cof=(int)Math.pow(-1,i)*matrix[0][i]*determinantOfMatrix(submatrix(matrix,0,i),n-1);
            det=det+cof;
        }
        return det;
        
    }
    
    static int [][] submatrix(int matrix[][],int r,int c){
        int n=matrix.length;
        int arr[][]=new int [n-1][n-1];
        
        int row=0,col=0;
        
        for(int i=0;i<n;i++){
            if(i!=r){
                for(int j=0;j<n;j++){
                    if(j!=c){
                        arr[row][col]=matrix[i][j];
                        col++;
                    }
                    
                }
                col=0;
                row++;
            }
        }
        return arr;
    }

    public static void main(String [] args){
        int mat[][]=
        {
            {1,2,3},
            {4,5,6},
            {7,10,9}

        };

        int n=mat.length;

        int res=determinantOfMatrix(mat,n);

        System.out.println("The determinate of matrix is :- "+res);

        
    }
}