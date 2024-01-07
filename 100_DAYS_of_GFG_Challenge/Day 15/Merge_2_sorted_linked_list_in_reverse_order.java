
/* The task is to complete the function mergeResult() 
which takes reference to the heads of both linked list and 
returns the pointer to the merged linked list.*/


public class Merge_2_sorted_linked_list_in_reverse_order{
    private static Node reverse(Node head){
        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    Node mergeResult(Node a, Node b)
    {
	// Your code here	
	    Node res = new Node(-1);
	    Node tail = res;
	    while(a != null && b != null){
	        if(a.data <= b.data){
	            tail.next = new Node(a.data);
	            a = a.next;
	        }else{
	            tail.next = new Node(b.data);
	            b = b.next;
	        }
	        tail = tail.next;
	    }
	    if(a == null){
	        tail.next = b;
	    }
	    if(b == null){
	        tail.next = a;
	    }
	    return reverse(res.next);
    }
}