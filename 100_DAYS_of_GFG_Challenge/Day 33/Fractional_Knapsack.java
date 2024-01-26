/* 
Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size N and 
returns a double value representing the maximum value in knapsack.
*/




public class Fractional_Knapsack{
    //Function to get the maximum total value in the knapsack.

    double fractionalKnapsack(int W, Item arr[], int n) 

    {

        // Your code here

         Arrays.sort(arr,(a,b)->Double.compare(b.value*1.0/b.weight,a.value*1.0/a.weight));

         

         int val = 0;

         double finalAns = 0.0;

         

         for(int i=0; i<n; i++){

             if(val + arr[i].weight <= W){

                 val += arr[i].weight;

                 finalAns += arr[i].value;

             }else{

                 int rem = W-val;

                 finalAns += ((double)arr[i].value / (double)arr[i].weight)*(double)rem;

                 break;

             }

         }

         return finalAns;

    }

}