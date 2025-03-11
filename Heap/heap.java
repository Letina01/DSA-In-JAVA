package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.List;

//impilentation of heap using arraylist
class Heap{
    static ArrayList<Integer> heap = new ArrayList<>();
    public void add(int data){
        heap.add(data);//ading last index
        int x=heap.size()-1;//last index
        int par=(x-1)/2;
        while(x!=0 && heap.get(x)<heap.get(par)){
            //swap
          int temp=heap.get(x);
          heap.set(x, heap.get(par));
          heap.set(par, temp);
        }
    }
   //peak
   public int peak(){
    return heap.get(0);//heap max element is root for max heap
   }
   //heapify// log(n)
   //max heap
   public void heapify(){
    for(int i=1;i<heap.size();i++){
       int left=2*i+1;
       int right=2*i+2;
       int max=i;//max of root and child
       if(left<heap.size() && heap.get(left)<heap.get(i)){
        max=left;
       }
       if(right<heap.size() && heap.get(right)<heap.get(max)){
        max=right;
       }
       if(max!=i){//if max indx value is changed
        //swap
        int temp=heap.get(i);
        heap.set(i, heap.get(max));
        heap.set(max, temp);
        
        heapify();//recursion
       }
    }
}
   //delete
   public int delete(){//deleteing max element means root
    int data=heap.get(0);
    //swap first and last
    heap.set(0, heap.get(heap.size()-1));
    heap.remove(heap.size()-1);
    heapify();
    return data;
   
   }
   //heap sort//nlogn
   //min heap
   public static void Heapfiy(int heap[],int i,int size){
       int left=2*i+1;
       int right=2*i+2;
       int max=i;
       if(left<size && heap[left]>heap[i]){
           max=left;
       }
       if(right<size && heap[right]>heap[max]){
           max=right;
       }
       if(max!=i){
           int temp=heap[i];
           heap[i]=heap[max];
           heap[max]=temp;
           Heapfiy(heap,max,size);
       }
      public static void heapSort(int heap[]){
       //build heap
       int n=heap.length;
       for(int i=n/2;i>=0;i--){
           Heapfiy(heap,i,n);
       }
       //heap sort
       //PUSH largest element to end
       for(int i=n-1;i>0;i--){
           int temp=heap[0];
           heap[0]=heap[i];
           heap[i]=temp;
           Heapfiy(heap,0,i);
    }
   }
   //kth largest element
   public int kthLargest(int k,int arr[]) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();// // Create a min-heap
    for (int i = k; i < arr.length; i++) {// Add the first k elements to the heap
        pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++) {// Add the remaining elements to the heap
            if (pq.peek() < arr[i]) {// If the root of the heap is smaller than the current element
                pq.poll();// Remove the root
                pq.add(arr[i]);// Add the current element
            }
        }
        return pq.peek();// Return the kth largest element root of the heap
    }
    //kth smallest element
    public int kthSmallest(int k,int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());// Create a max-heap
        for (int i = 0; i < k; i++) {// Add the first k elements to the heap
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {// Add the remaining elements to the heap
            if (pq.peek() > arr[i]) {// If the root of the heap is greater than the current element
                pq.poll();// Remove the root
                pq.add(arr[i]);// Add the current element
            }
        }
        return pq.peek();// Return the kth smallest element root of the heap
    }
    //merge k sorted arrays
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        // Write your code here.
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0;i<K;i++){
            pq.add(new int[]{arr[i][0],i,0});
        }
        ArrayList<Integer> result=new ArrayList<>();
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int value=curr[0];
            int arridx=curr[1];
            int elementidx=curr[2];
            result.add(value);
            
            if(elementidx+1<arr[arridx].length){
                pq.add(new int[]{arr[arridx][elementidx+1],arridx,elementidx+1});
            }
        }
        
        return result;
        
    }
    //merge k list
    public ListNode mergeKLists(ListNode[] lists) {
        // Write your code here.
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)-> a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
        
    }


    

}
public class heap {
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(40);
        h.add(50);
        System.out.println(h.peak());
        h.delete();
        System.out.println(h.peak());
       
      
    }
    
}
