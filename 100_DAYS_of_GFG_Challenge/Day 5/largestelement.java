// Largest elements of the array

import java.util.*;
public class largestelement{
    static int printelement(int arr[]){
        int n=arr.length;
        Arrays.sort(arr);
        int largest=0;
        for(int i=0;i<n;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }

    public static void main(String args[]){
        int arr[]={1, 8, 7, 56, 90};
        int res=printelement(arr);
        System.out.println("The largest element is : "+ res);
    }
}