class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next!=null) {
			n = n.next;
		}
		n.next = end;
	}
}

Node deleteNode(Node head, int d) {
	Node n = head;

	if (n.data == d) {
		return head.next;
	}

	while (n.next != null) {
		if (n.next.data = d) {
			n.next = n.next.next;
			return head;
		}
		n = n.next;
	}
	return head;
}

////////////////Questions///////////////////

//2.1
public static void deleteDups(LNode n) {
	Hashtable hash = new Hashtable();
	LNode result = null;
	while (n != null) {
		if (hash.check(n.data)) {

		}
		else {
			hash.put(n.data, true);
			result.append(n);
		}
		n = n.next;
	}
}

//2.1 follow up
public static void deleteDups(LNode n) {
	LNode curr = n;
	LNode runner;

	if (curr == null) return;
	while (curr != null) {
		runner = curr;
		while (runner.next!=null) {
			if (runner.next.data==curr.data) {
				runner.next = runner.next.next;
			}
			else runner = runner.next;
		}
		curr = curr.next;
	}
}

//2.2
public int nthToLast(LNode curr, int k) {
	if (curr = null) return 0;

	int i = nthToLast(curr.next,k)+1
	if (i==k) {
		//output the node
	}
	return i;
}

//Create a Wrapper class
public class IntWrapper {
	public int value = 0;
}

LNode nthToLast(LNode curr, int k, IntWrapper i) {
	if (head == null) {
		return null;
	}
	LNode node = nthToLast(curr.next, k, i);
	i.value = i.value+1;
	if (i.value = k) {
		return curr;
	}
	return curr;
}

//using two pointer
public LNode nthToLast(LNode curr, int k) {
	LNode p1 = curr;
	LNode p2 = curr;

	if (k<=0) return null;

	for (int i=0; i<k; i++) {
		if (p2 == null) return null;
		p2 = p2.next;
	}
	if (p2==null)return null;

	while (p2.next != null) {
		p1 = p1.next;
		p2 = p2.next;
	}

	return p1;
}

//2.3
public static boolean deleteNode(LNode n) {
	if (n==null || n.next ==null) {
		return false;
	}
	LNode next = n.next;
	n.data = next.data;
	n.next = next.next;
	return true;
}

//2.4
public LNode partition(LNode node, int x) {
	LNode lHead = null;
	LNode rHead = lHead;
	LNode lTail = null;
	LNode rTail = rHead;

	while (node != null) {
		if (node.data<x) {
			lTail = lTail.next = node;
		}
		else {
			rTail = rTail.next = node;
		}
		node = node.next;
	}

	lTail.next = rHead;
	return lHead;
}

//2.5
public LList sumation(LList l1, LList l2) {
	int addition = 0;
	LList result = new LList();

	while ((l1!=null)&&(l2!=null)) {
		int a = l1.element();
		int b = l2.element();
		result.append((a+b+addition)%10);
		addition = (a+b+addition)/10;
		l1 = l1.next();
		l2 = l2.next();
	}

	return result;
}

//follow up
public class PartialSum {
	public LNode sum = null;
	public int carry = 0;
}

LNode addList(LList l1, LList l2) {
	int len1 = l1.length();
	int len2 = l2.length();

	if (len1<len2) l1 = padList(l1, len2-len1);
	else l2 = padList(l2, len1-len2);

	PartialSum sum = addListHelper(l1.curr(), l2.curr());

	if (sum.carry==0) {
		return sum.sum;
	} else {
		LNode result = insertBefore(sum.sum, sum.carry);
		return result;
	}
}

PartialSum addListHelper(LNode l1, LNode l2) {
	if (l1==null && l2==null) {
		PartialSum sum = new PartialSum();
		return sum;
	}
	PartialSum sum = addListHelper(l1.next(),l2.next());

	int val = sum.carry+l1.element()+l2.element();

	LNode full_result = insertBefore(sum.sum, val %10);

	sum.sum = full_result;
	sum.carry = val / 10;
	return sum;
}

LNode insertBefore(LNode list, int data) {
	LNode node = new LNode(data, null);
	if (list != null) {
		list.prev = node;
		node.next = list;
	}
	return node;
}

LList padList(LList l, int pad) {
	for (int i = 0; i<pad; i++) {
		l.moveToHead();
		l.insert(0);
	}
	return l;
}

//2.6
LNode findloop(LNode head) {
	LNode slow = head;
	LNode fast = head;

	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;

		if (slow = fast) {
			break;
		}
	}

	if (fast == null || fast.next == null) {
		return null;
	}

	slow = head;
	while  (slow != fast) {
		slow = slow.next;
		fast = fast.next;
	}

	return fast;
}

//2.7
boolean isPalindrome(LList list) {
	LNode slow = list.head().next();
	LNode fast = list.head().next();

	Stack stack = new Stack();

	while (fast != null && fast.next() != null) {
		stack.push(slow);
		slow = slow.next;
		fast = fast.next.next;
	}

	if (fast != null) {
		slow = slow.next;
	}

	while (slow != null) {
		int first = stack.pop().value();

		if (first!=slow.data) {
			return false;
		}
		slow = slow.next;
	}
	return true;
}