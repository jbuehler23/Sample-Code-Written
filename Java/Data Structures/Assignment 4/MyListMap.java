import java.util.*;

public class MyListMap<K extends Comparable<? super K>, E>
                         implements MyMap<K,E>, Iterable<KeyValuePair<K, E>>
{
  private ListNode<K, E> dummy;
  private ListNode<K, E> cursor;
  private int size;

  public MyListMap()
  {
      dummy = new ListNode<K,E>();
      dummy.prev = dummy;
      dummy.next = dummy;
      cursor = dummy;
      size = 0;
  }

  public MyListMap(MyMap<K, E> otherMap)
  {
      this();
      for(Iterator<KeyValuePair<K, E>> it = otherMap.iterator(); it.hasNext(); )
      {
          KeyValuePair<K, E> pair = it.next();
          K key   = pair.getFirst();
          E info  = pair.getSecond();
          put(key, info);
      }
  }

  public void clear()
  {
      dummy.prev = dummy;
      dummy.next = dummy;
      cursor = dummy;
      size = 0;
  }

  public int size()
  { return size; }

  public boolean isEmpty()
  {return (size == 0);}

  public boolean contains(K key)
  { return find(key); }

  private boolean find(K k)
  {
      cursor = dummy.next;
      while( cursor != dummy )
      {
          K key = cursor.key;
          int n = k.compareTo(key);
          if(n == 0)
            return true;
          if(n < 0)
            return false;
          cursor = cursor.next;
      }
      return false;
  }

  public E get(K key)
  {
     boolean found = find(key);
     if(!found)
        return null;
     return cursor.info;
  }

  public boolean set(K key, E info)
  {
      boolean found = find(key);
      if(!found)
        return false;
      cursor.info = info;
      return true;
  }

  public boolean put(K key, E info)
  {
      boolean found = find(key);
      if(found)
        return false;
      ListNode<K,E> prev = cursor.prev;

      ListNode<K,E> temp = new ListNode<K,E>(key, info, prev, cursor);
      prev.next = temp;
      cursor.prev = temp;
      size++;
      return true;
  }

  public boolean remove(K key)
  {
    boolean found = find(key);
    if(!found)
      return false;
    ListNode<K,E> hold = cursor.prev;
    cursor = cursor.next;
    cursor.prev = hold;
    hold.next = cursor;
    size--;
    return true;
  }

  private void remove(ListNode<K,E> ptr)
  {
	  ListNode<K,E> p = ptr.prev;
	  ListNode<K,E> n = ptr.next;
	  p.next = n;
	  n.prev = p;
	  size--;
  }

  public Iterator< KeyValuePair<K, E> > iterator()
  {
      Iterator< KeyValuePair<K, E> > itr = new MyListItr();
      return itr;
  }

/*********************************************************************************
         Inner Class: Inorder iterator for the list
**********************************************************************************/
    private class MyListItr implements Iterator<KeyValuePair<K, E>>
    {
      private ListNode<K,E> lastReturned;
      private ListNode<K,E> next;

      MyListItr()
      {
          lastReturned = null;
          next = dummy.next;
      }

      public boolean hasNext()
      { return(next != dummy); }

      public KeyValuePair<K, E> next()
      {
        if(next == null)
          throw new NoSuchElementException();
        lastReturned = next;
        next = next.next;
        KeyValuePair<K, E> pr = new KeyValuePair<K, E>();
        pr.setFirst(lastReturned.key);
        pr.setSecond(lastReturned.info);
        return pr;
      }

      public void remove()
      {
        if (lastReturned == null)
          throw new IllegalStateException();
        MyListMap.this.remove(lastReturned);
        lastReturned = null;
      }

    }

/*********************************************************************************
         Inner Class: Node for the list
**********************************************************************************/
  private static class ListNode<K, E>
  {
    private K key;
    private E info;
    private ListNode<K,E> prev;
    private ListNode<K,E> next;

    public ListNode()
    { prev = next = null; }

    public ListNode(K k, E obj,
                    ListNode<K,E> previousNode, ListNode<K,E> nextNode)
    {
       key  = k;
       info = obj;
       prev = previousNode;
       next = nextNode;
    }

    public ListNode(ListNode<K,E> otherNode)
    {
      key  = otherNode.key;
      info = otherNode.info;
      prev = otherNode.prev;
      next = otherNode.next;
    }

  }
}
