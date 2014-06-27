
public class ListStack<E> implements MyStack<E>
{
  private ListDeque<E> data;

  public ListStack()
  { data = new ListDeque<E>(); }

  public E pop()
  { return data.popFront(); }

  public void push(E o)
  { data.pushFront(o); }

  public E peek()
  { return data.front(); }

  public boolean isEmpty()
  { return data.isEmpty(); }

  public int size()
  {return data.size();}

}











