package GUI;

public class List {
	private lNode first, last;
	int c = 0;
	
	public List() {
		super();
	}

	public Object getFirst() {
		if (c == 0)
			return null;
		else
			return first.element;
	}

	public lNode getFirstNode() {
		if (c == 0)
			return null;
		else
			return first;
	}
	public lNode getLastNode() {
		if (c == 0)
			return null;
		else
			return last;
	}
	public Object getLast() {
		if (c == 0)
			return null;
		else
			return last.element;
	}

	public void addFirst(Object o) {
		if (c == 0)
			first = last = new lNode(o);
		else {
			lNode temp = new lNode(o);
			temp.Next = first;
			first = temp;
		}
		c++;
	}

	public void addLast(Object o) {
		if (c == 0)
			first = last = new lNode(o);
		else {
			last.Next = new lNode(o);
			last = last.Next;
		}
		c++;
	}

	public void add(Object o, int index) {
		if (index == 0)
			addFirst(o);
		else if (index >= c)
			addLast(o);
		else {
			lNode carrent = first;
			for (int i = 0; i < index - 2; i++) {
				carrent = carrent.Next;
			}
			lNode temp = new lNode(o);
			temp.Next = carrent.Next;
			carrent.Next = temp;
			c++;
		}

	}

	public Object removeFirst() {
		if (c == 0)
			return null;
		else {
			lNode t = first;
			if (c == 1) {
				first = last = null;
			} else
				first = first.Next;
			c--;
			return t.element;
		}
	}

	public Object removeLast() {
		if (c == 0)
			return false;
		else {
			if (c == 1) {
				first = last = null;
			} else {
				lNode carrent = first;
				for (int i = 0; i < c - 2; i++) {
					carrent = carrent.Next;
				}
				carrent.Next = null;
				last = carrent;
			}
			c--;
			return true;
		}
	}

	public Object removeIndex(int index) {
		if (index == 0)
			return removeFirst();
		else {
			if (index == c)
				return removeLast();
			else if (index >= 0 && index < c) {
				lNode carrent = first;
				for (int i = 0; i < index - 2; i++)
					carrent = carrent.Next;
				carrent.Next = carrent.Next.Next;
				c--;
				return true;
			}
			return false;
		}
	}
	public Object removeEdge(Object o){
		if(c==0)
			return false;
		if(c==1){
			if(first.element == o)
				return removeFirst();
		}else{
			if(first.element == o)
				return removeFirst();
			if(last.element == o)
				return removeLast();
			lNode c = first;
			while(c.Next!=null){
				if(c.Next.element==o){
					c.Next=c.Next.Next;
					this.c--;
				}
				
				c=c.Next;
			}
		}
		return false;
			
	}
	public Object removeObject(Object o) {
		if (c == 0)
			return false;
		else if (first.element == o)
			return removeFirst();
		else {
			lNode carrent = first;
			int i;
			for (i = 0; i < c; i++) {
				if (carrent.Next.element == o)
					break;
				else
					carrent = carrent.Next;
			}
			if (i == c)
				return false;
			else {
				if (carrent.Next == last) {
					carrent.Next = null;
					last = carrent;
				} else {
					carrent.Next = carrent.Next.Next;
				}
				c--;
				return true;
			}
		}
	}

	public int getlength() {
		return c;
	}
	public boolean isin(Object o){
		lNode temp = first;
		while(temp != null){
			if(temp.element == o){
				return true;
			}
			temp = temp.Next;
		}
		return false;
	}
	
}
