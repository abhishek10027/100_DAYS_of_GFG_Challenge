/* 
Your Task:

Complete the provided function modifyQueue() that takes queue and K as parameters and 
returns a modified queue. The printing is done automatically by the driver code.

 */


public class Reverse First_K_elements_of_Queue{
    
    // Function to reverse first k elements of a queue.
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        
        Stack <Integer> st=new Stack();
        
        for(int i=0;i<k;i++){
            st.push(q.poll());
        }
        
        while(!st.isEmpty()){
            q.add(st.pop());
            
        }
        
        int j=0;
        
        while(j<q.size()-k){
            q.add(q.remove());
            j++;
        }
        
        return q;
    }
}