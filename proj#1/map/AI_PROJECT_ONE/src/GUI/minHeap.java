package GUI;

public class minHeap {
	Node []heap;
	int size;
	public minHeap(int s) {
		super();
		size = 0;
		heap = new Node[s+1];
	}
	
	public void insert(Node x) {
		int i;
		if(heap.length-1 == size)
			System.out.println("full");
		else {
			i=++size;
			while(i>1&&(heap[i/2].element.costEdge>=x.element.costEdge)) {
				heap[i]=heap[i/2];
				i/=2;
			}
			heap[i]=x;
		}
	}
	public Node deleteMin() {
		int j,child;
		if(size==0)
			return null;
		else {
			Node minValue = heap[1];
			Node lastValue = heap[size--];
			for ( j = 1; j*2<= size; j=child) {
				child = j*2;
				if((child<size)&&(heap[child+1].element.costEdge<heap[child].element.costEdge))
					child++;
				if(lastValue.element.costEdge>heap[child].element.costEdge)
					heap[j] = heap[child];
				else
					break;
			}
			heap[j]= lastValue;
			return minValue;
		}
	}
	
}
