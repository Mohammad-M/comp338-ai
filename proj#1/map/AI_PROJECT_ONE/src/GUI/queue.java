package GUI;

public class queue {
	List queue;

	public queue() {
		queue = new List();
	}
	public void inq(Object newObj){
		queue.addFirst(newObj);
	}
	public Object deq(){
		return queue.removeFirst();
	}
	public int size(){
		return queue.getlength();
	}
	public boolean empty() {
		return size()==0;

	}
	public boolean isin(Object newObj) {

		return queue.isin(newObj);
	}

}
