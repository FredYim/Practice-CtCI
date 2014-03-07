class Queue {
	Node head;
	Node tail;
	int size;

	void clear() {
		head = tail = null;
		size = 0;
	}
	void enqueue(int i) {
		tail.setNext(new Node(t, null));
		tail = =tail.next();
		size++;
	}
	int dequeue() {
		if (head!=null) {
			Node temp = head;
			head = head.next();
			size--;
			return temp;
		}
		return null;
	}
	int length() {return size;}
	int frontValue() {return head;}
}

class Stact {
	Node top;
	int size;

	void clear() {
		top = null;
		size = 0;
	}
	void push(int i) {
		Node temp = new Node(i, top);
		top = temp;
		size++
	}
	Node pop() {
		if (top != null) {
			Node temp = top;
			top = top.next();
			size--;
			return temp;
		}
		return null;
	}
	int length() {return size;}
	Node topValue() {return top;}
}

/////////////////////////////Question Solution///////////////////////////
