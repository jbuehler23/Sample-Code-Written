
//the queue is going to be a queue of Integers so no parsing will be necessary for this project. can change to any
public class Queue1<E> implements MyQueue1<E>{
	private node<E> d;
	private int size;

	public Queue1() {
		d = new node<E>();
		d.pr= d;
		d.ne = d;
		size = 0;
	}

	//checks if queue is empty
	public boolean isEmpty() {
		return (size == 0);
	}

	//remove an element to the queue
	public synchronized E deQueue() {
		if(size == 0)
			return null;
		node<E> temp = d.ne;
		E hold = temp.data;
		temp = temp.ne;
		d.ne = temp;
		temp.pr = d;
		size--;
		return hold;
	}

	//add an element
	public synchronized void enQueue(E obj) {
		node<E> hold = d.pr;
		node<E> temp = new node<E>(obj, hold, d);
		hold.ne = temp;
		d.pr = temp;
		size++;
	}

	//show item at the front of the queue
	public synchronized E front() {
		if(size == 0)
			return null;
		node<E> temp = d.ne;
		return temp.data;
	}

	public int size() {
		return size;
	}



	/*********************
		     node
	**********************/
	private static class node<E>{
		private E data;
		private node<E> pr;
		private node<E> ne;

		public node() {
			pr = ne = null;
		}

		//Copy Constructor
		public node(E obj, node<E> prevNode, node<E> nextNode) {
			data = obj;
			pr = prevNode;
			ne = nextNode;
		}

		public node(node<E> other) {
			data = other.data;
			pr = other.pr;
			ne = other.ne;
		}
	}
}//end queue class


