
// Task is to find second largest element in given array.

public class SecondLargest{
    public static int secondlargest(int arr[],int n){
        int largest=0;
        int second=-1;

        for(int i=1;i<n;i++){
            if(arr[i]>arr[largest]){
                second=arr[largest];
                largest=i;
            }
            else if(arr[i]!=arr[largest]){
                if(arr[i]>second||second==-1){
                    second=arr[i];
                }
            }
        }
        return second;
    }

    // main class

    public static void main(String args[]){
        int Arr[] = {12, 35, 1, 10, 34, 1};
        int n=Arr.length;

        int res=secondlargest(Arr,n);

        System.out.println("The secondlargest element is :-   "+res);
    }

}
