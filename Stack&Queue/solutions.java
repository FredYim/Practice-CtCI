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

/////////////////////////////Question Solution//////////////////////////

//question 3.1
public class stackarray {
	static int stackSize = 100;
	static int[] buffer = new int [stackSize * 3];
	static int[] stackPointer = {-1, -1, -1};

	static void push(int stackNum, int value) throws Exception {
		if (stackPointer[stackPointer[stackNum]+1>=stackSize]) {
			throw new FullStackException();
		}
		stackPointer[stackNum]++;
		buffer[topOfStack(stackNum)] = value;
	}

	static int pop(int stackNum) throws Exception {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int value = buffer[topOfStack(stackNum)];
		buffer[topOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}

	static int topValue(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return buffer[topOfStack(stackNum)];
	}

	static boolean isEmpty(int stackNum) {
		return stackPointer[stackNum]-1;
	}
	static int topOfStack(int stackNum) {
		return stackNum * stackSize+stackPointer[stackNum];
	}
}

//question 3.2
class NodeWithMin {
	private int value;
	private int min;
	
	public NodeWithMin(int v, int min) {
		value = v;
		this.min = min;
	}

	public value() {return value;}
	public min() {return value;}
}

public class StackwithMin extends Stack<NodeWithMin> {
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return peek().min;
		}
	}
}

//using a stack in the class to record the current min, don't need to store current min in each node.
public class StackwithMin extends Stack<Integer> {
	Stack<Integer> s2;

	public StackwithMin() {
		s2 = new Stack<Integer>;
	}

	public void push(int value) {
		if (value<=min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public int pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else {
			return s2.peek();
		}
	}
}

//question 3.3
public class SetOfStack {
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;

	public SetOfStack(int capacity) {
		this.capacity = capacity;
	}

	public Stack getLastStack() {
		if (stacks.size()==0) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}

	public void push(int v) {
		Stack last = getLastStack();
		if (last !=null && !last.isFull()) {
			last.push(v);
		} else {
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop() {
		Stack last = getLastStack();
		int v = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size-1);
		}
		return v;
	}

	public int popAt(int index) {
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop) {
		Stack stack = stack.get(index);
		int removed_item;
		if (removeTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else {
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return removed_item;
	}

	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
}

public class Stack {
	private int capacity;
	public Node top;
	public Node bottom;
	public int size = 0;

	public Stack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public void join(Node above, Node below) {
		if (below != null) below.above = above;
		if (above != null) above.below = below;
	}

	public boolean push(int v) {
		if (size >= capacity) return false;
		size++;
		Node n = new Node(v);
		if (size == 1) bottom = n;
		join(n, top);
		top = n;
		return true;
	}

	public int pop() {
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int removeBottom() {
		Node b = below;
		bottom = bottom.above;
		if (bottom != null) bottom.below = null;
		size--;
		return b.value;
	}
}

public class Node{
	public Node above;
	public Node below;
	public int value;
	public Node(int v) {
		this value = v;
	}
}

//question 3.4
public class question {
	public static void main(String[] args) {
		int n = 5;
		Tower[] towers = new Tower[3];
		for (int i=0; i<3; i++) {
			towers[i] = new Tower(i);
		}
		for (int i = n-1; i>=0; i--) {
			towers[0].add(i)
		}

		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}

public class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>;
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty()&& disks.peek()<=d) {
			System.out.println("Error placing disk" + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
	}

	public void print() {
		System.out.println("Contents of Tower "+ index()+":"+disks.toString()); 
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n>0) {
			String tag = "move "+n+" disks from "+this.index+" to "+destination.index+" with buffer "+buffer.index;
			System.out.println("<"+tag+">");

			moveDisks(n-1, Tower buffer, Tower destination);

			System.out.println("<move top from "+this.index+" to "+destination.index+">");
				System.out.println("<before>");
					System.out.println("<source print>");
						this.print();
					System.out.println("</source print>");
					System.out.println("<destination print>");
						destination.print();
					System.out.println("</destination print>");
				System.out.println("</before>");

				moveTopTo(destination);

				System.out.println("<after>");
					System.out.println("<source print>");
						this.print();
					System.out.println("</source print>");
					System.out.println("<destination print>");
						destination.print();
					System.out.println("</destination print>");
				System.out.println("</after>");
			System.out.println("</move top from "+this.index+" to "+destination.index+">");

			buffer.moveDisks(n-1, Tower destination, this);
			System.out.println("</"+tag+">");
		}
	}
}