import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class ArraySet<E extends Comparable<? super E> > implements MySet<E>, Iterable<E>
{
  private ArrayList<E> data;

  public ArraySet()
  { data = new ArrayList<E>(); }

  public ArraySet(MySet<E> otherSet)
  {
    data = new ArrayList<E>();
    for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
    {
        add(itr.next());
    }
  }

  public boolean isEmpty()
  {return data.size() == 0;}

  public int  size()
  {return data.size();}

  public boolean add(E value)
  {
      int foundAt = binarySearch(data, value);
      if(foundAt >= 0)
        return false;
      int pos = -foundAt - 1;
      data.add(pos, value);
      return true;
  }

  public boolean remove(E value)
  {
      int foundAt = binarySearch(data, value);
      if(foundAt < 0)
         return false;
      data.remove(foundAt);
      return true;
  }

  public boolean contains(E value)
  {
      int pos = binarySearch(data, value);
      return(pos >= 0);
  }

  public void clear()
  {data.clear();}

  public String toString()
  {
    StringBuilder result = new StringBuilder("{ ");
    for(int i = 0; i < data.size(); i++)
       result.append(data.get(i)  + "  ");
    result.append(" }");
    return result.toString();
  }

  public boolean equals(Object other)
  {
     if(other == this)
       return true;
     if(! (other instanceof MySet) )
       return false;
     MySet<E> otherSet = (MySet<E>)other;
     if(data.size() != otherSet.size())
        return false;
     for(Iterator<E> itr = iterator(); itr.hasNext(); )
     {
       E temp = itr.next();
       if(!otherSet.contains(temp) )
         return false;
     }
     return true;
  }

  public MySet<E> union(MySet<E> otherSet)
  {
      MySet<E> temp = new ArraySet<E>();

      for(Iterator<E> itr = iterator(); itr.hasNext(); )
      {
        E hold = itr.next();
        temp.add(hold);
      }

      for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
      {
        E hold = itr.next();
        temp.add(hold);
      }

      return temp;
  }

  public MySet<E> intersection(MySet<E> otherSet)
  {
    MySet<E> temp = new ArraySet<E>();
    for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
    {
      E hold = itr.next();
      if(this.contains(hold))
         temp.add(hold);
    }
    return temp;
  }

  public MySet<E> difference(MySet<E> otherSet)
  {
    MySet<E> temp = new ArraySet<E>();
    for(Iterator<E> itr = iterator(); itr.hasNext(); )
    {
      E hold = itr.next();
      if(!otherSet.contains(hold))
        temp.add(hold);
    }
    return temp;
  }

  public boolean hasSubset(MySet<E> otherSet)
  {
    for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
    {
      E hold = itr.next();
      if(!this.contains(hold))
        return false;
    }
    return true;
  }

  private int binarySearch(List<E> table, E key)
  {
     int low = 0, high = table.size() - 1, mid;
     while(low <= high)
     {
        mid = (low + high)/2;
        E hold = table.get(mid);
        int result = key.compareTo(hold);
        if(result == 0)
           return mid;
        else if(result < 0)//key comes before middle
           high = mid - 1;
        else     //key comes after the middle
           low = mid + 1;
     }
     return -low - 1;
  }


  public Iterator<E> iterator()
  {return new ArraySetItr(); }

/**************************************************************************/
  private class ArraySetItr implements Iterator<E>
  {
       private int lastReturned;
       private int next;

       ArraySetItr()
       {
         lastReturned = -1;
         next = 0;
       }

       public boolean hasNext()
       { return(next < data.size()); }

       public E next()
       {
         if (next >= data.size())
            throw new NoSuchElementException();
         lastReturned = next;
         next++;
         return data.get(lastReturned);
       }

       public void remove()
       {
         if (lastReturned == -1)
           throw new IllegalStateException();
         data.remove(lastReturned);
         next--;
         lastReturned = -1;
       }
  }

}
