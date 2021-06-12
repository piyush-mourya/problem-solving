package stu.piyush.learning;

public class MinHeapImpl {
	
	class MinHeap {
		int[] harr; // pointer to array of elements in the heap
		int capacity; // max possible size of min heap
		int heap_size; // current heap size;
		
		//min heap position methods
		
		int parent(int i) { return harr[(i-1)/2]; }
		int left(int i) { return harr[( (2*i) + 1 )];}
		int right(int i) {return harr[( (2*i) + 2 )];}
		int getMin() { return harr[0];}
		
		// method to replace root with new node x and heapify() new root
		void replaceMin(int x) {
			this.harr[0] = x;
			minHeapify(0);
		}
		
		MinHeap(int a[], int size){
			heap_size = size;
			harr = a; // store address of array
			int i = (heap_size - 1)/2;
			while(i >= 0) {
				minHeapify(i);
				i--;
			}
		}
		
		// Method to remove minimum element (or root) from min heap
		int extractMin() {
			if (heap_size == 0) {
				return Integer.MIN_VALUE;
			}
			
			// Store the minimum value
			int root = harr[0];
			
			// if more than 1 items, move the last item to root and call heapify
			if(heap_size > 1) {
				harr[0] = harr[heap_size - 1];
				minHeapify(0);
			}
			heap_size--;
			return root;
		}
		
		// A recursive method to heapify a subtree with root at given index
	    // This method assumes that the subtrees are already heapified
		void minHeapify(int i) {
			int l = left(i);
			int r = right(i);
			int smallest = i;
			if( l < heap_size && harr[l] < harr[i]) {
				smallest = l;
			}
			if ( r < heap_size && harr[r] < harr[smallest]) {
				smallest = r;
			}
			if(smallest != i) {
				int t = harr[i];
				harr[i] = harr[smallest];
				harr[smallest] = t;
				minHeapify(smallest);
			}
		}
		
	}
}
