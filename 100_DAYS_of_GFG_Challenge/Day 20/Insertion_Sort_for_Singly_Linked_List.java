


public class Insertion_Sort_for_Singly_Linked_List{
    public static Node insertionSort(Node head_ref)
    {
        //code here
        int size =0;
        Node curr =head_ref;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        int arr[] = new int[size];
        curr = head_ref;
        int i=0;
        while(curr!=null){
            arr[i] = curr.data;
            i++;
            curr= curr.next;
        }
        Arrays.sort(arr);
        Node node = new Node(0);
        Node head1 = node;
        curr = head1;
        int j=0;
        while(j!=arr.length){
            Node newnode = new Node(arr[j]);
            curr.next = newnode;
            curr = curr.next;
            j++;
        }
        head1 = head1.next;
        return head1;
    }
}
