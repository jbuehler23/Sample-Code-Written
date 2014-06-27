public interface MyQueue1<E> {
	public E deQueue();

	public void enQueue(E obj);

	public E front();

	public boolean isEmpty();

	public int size();
}