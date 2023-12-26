import java.util.*;
class LeaderinArray{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        int currleader=0;
        
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            if(currleader<=arr[i]){
                currleader=arr[i];
                l.add(0,arr[i]);
                
            }
        }
        return l;
    }

    public static void main(String [] args){
        int A[] = {16,17,4,3,5,2};
        int n=6;
        
        ArrayList<Integer>res=leaders(A,n);
        
        System.out.println("The leaders are :"+res);
        
        
    }
}
