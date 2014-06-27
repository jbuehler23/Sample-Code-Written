import java.util.*;

public class myMultiSet<E extends Comparable<? super E> > implements myMultiSet<E>, Iterable<E>
{
	private MyListMap<E, Integer> data;
	public myMultiSet()
	{ data = new myMultiSet<E, Integer>(); }

	public myMultiSet(myMultiSet<E> otherSet)
	{
		data = new myMultiSet<E, Integer>();
		Iterator<E> it = otherSet.iterator();
		while(it.hasNext())
		{
			E temp = it.next();
			add(temp);
		}
	}
	public boolean isEmpty()
	{ return data.isEmpty(); }

	public int size()
	{ return data.size(); }

	public boolean add(E value)
	{
	   return data.put(value, null);
	}

	public boolean remove(E value)
	{
	   return data.remove(value);
	}

	public boolean contains(E value)
	{ return data.contains(value); }

	public void clear()
	{ data.clear(); }
	public String toString()
	{
	    String result = "{ ";
	    Iterator<E> it = iterator();
	    while(it.hasNext())
	    {
	      result += it.next()  + "  ";
	    }
	    result += " }";
	    return result;
	}
	public boolean equals(Object other)
	  {
	     if(other == this)
	        return true;
	     if(! (other instanceof myMultiSet) )
	        return false;
	     myMultiSet<E> otherSet = (myMultiSet<E>)other;
	     if(data.size() != otherSet.size())
	        return false;
	     for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
	     {
	       E temp = itr.next();
	       if(!this.contains(temp))
	          return false;
	     }
	     return true;
	  }
/*********uses the same algorithm for finding union, intersection, difference, and subset as myListSet******/
	  public myMultiSet<E> union(myMultiSet<E> otherSet)
	  {
		
		  myMultiSet<E> temp = new myMultiSet<E>();

	      for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
	      {
	        E hold = itr.next();
	        temp.add(hold);
	      }

	      for(E hold : this)
	        temp.add(hold);
	      return temp;
	  }
	  public myMultiSet<E> intersection(myMultiSet<E> otherSet)
	  {
	        
		  myMultiSet<E> temp = new myMultiSet<E>();

	      for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
	      {
	        E hold = itr.next();
	        temp.add(hold);
	      }

	      for(E hold : this)
	    	  if (temp = itr.next())
	        temp.add(hold);
	      return temp;
		  
	  }

	  public myMultiSet<E> difference(myMultiSet<E> otherSet)
	  {
	        
		  myMultiSet<E> temp = new myMultiSet<E>();

	      for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
	      {
	        E hold = itr.next();
	        temp.add(hold);
	      }

	      for(E hold : this)
	    	  if (temp != itr.next())
	        temp.add(hold);
	      return temp;
		 
	  }
	  public boolean hasSubset(myMultiSet<E> otherSet)
	  {
		  Iterator<E> itr = iterator();
		    while(itr.hasNext())
		    {
		    	for(Iterator<E> itr = otherSet.iterator(); itr.hasNext(); )
		        {
		          E hold = itr.next();
		          temp.add(hold);
		          if (hold.contains(temp))
		        	  return true;
		          else
		          	  return false;
		        }
		    }

	  }
	  public int frequency()
	  {
		  E value;
		  int freq;
		  myMultiSet<E> temp = new myMultiSet<E>();
		  Iterator<E> itr = iterator();
		  while(itr.hasNext())
		  {
			  value = value + itr.next();
			  temp.add(value);
			  freq++;  
		  }
		  return freq;
	  }

	  public Iterator<E> iterator()
	  { return new ListSetIterator(); }

	  /***************************--Iterator--************************************************/
	  private class ListSetIterator implements Iterator<E>
	  {
	        private Iterator<KeyValuePair<E, Integer> > listItr;

	        public ListSetIterator()
	        { listItr = data.iterator(); }

	        public boolean hasNext()
	        { return listItr.hasNext(); }

	        public E next()
	        {
	        return listItr.next();
	        }

	        public void remove()
	        { listItr.remove(); }
	  }
	}
