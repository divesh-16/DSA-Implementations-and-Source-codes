package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class CircularSinglyLinkedList 
{
	private Node first;
	private Node last;
	private int count;
	
	private static class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			this.next = this;
		}
	}
	
	public CircularSinglyLinkedList()
	{
		this.first = null;
		this.last = null;
		this.count = 0; 
	}
	
	
	public void add(int element)
	{
		// When List is empty
		if(first == null)
		{
			Node T = new Node(element);
			first = T;
			last = T;
			last.next = first;
			count++;
		}
		else
		{
			// Adding at last
			
			Node T = new Node(element);
			
			T.next = first;
			last.next = T;
			
			last = last.next;
			
			count++;
		}
	}
	
	public void display()
	{
		Node T = first;
		
		for(; T != last; T = T.next)
		{
			System.out.print(T.data+"->");
		}
		
		System.out.println(T.data+"->head");
	}
	
	
	public int size()
	{
		return count;
	}
	
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		Node T = first;
		
		for(; T != last; T = T.next)
		{
			sj.add(String.valueOf(T.data));
		}
		
		sj.add(String.valueOf(T.data));
		
		return sj.toString();
	}
	
	
	public void addFirst(int element)
	{
		if(first == null)
		{
			Node T = new Node(element);
			
			first = T;
			last = T;
			
			last.next = first;
			
			count++;
		}
		else
		{
			Node T = new Node(element);
			
			T.next = first;
			
			last.next = T;
			
			first = T;
			
			count++;
		}
	}
	
	public void addLast(int element)
	{
		add(element);
	}
	
	
	private Node getNodeAt(int index)
	{
		if(index<0 || index>=count)
		{
			throw new IndexOutOfBoundsException("Invalid Index '"+index+"'");
		}
		
		Node T = first;
		for(int i=0; i<count; i++)
		{
			if(i==index)
			{
				return T;
			}
			T = T.next;
		}
		
		return null;
	}
	
	
	public int getElement(int index)
	{
		Node T = getNodeAt(index);
		return T.data;
	}
	
	public int setElement(int index, int element)
	{
		Node T = getNodeAt(index);
		int item = T.data;
		T.data = element;
		return item;
	}
	
	
	public void add(int index, int element)
	{
		if(index <0 || index > count)
		{
			throw new IndexOutOfBoundsException("Invalid Index '"+index+"'");
		}
		
		if(index == 0)
		{
			addFirst(element);
		}
		else if(index == count)
		{
			addLast(element);
		}
		else
		{
			Node T = new Node(element);
			Node S = getNodeAt(index-1);
			
			T.next = S.next;
			S.next = T;
			
			count++;
		}
	}
	
	
	public int indexOf(int element)
	{
		int i=0;
		Node T = null;
		for(T = first; T != last; T = T.next, i++)
		{
			if(T.data == element)
			{
				return i;
			}
		}
		
		if(T.data == element)
		{
			return i;
		}
		
		return -1;
	}
	
	public int lastIndexOf(int element)
	{
		int i=0;
		int rindex=-1;
		Node T = null;
		for(T = first; T != last; T = T.next, i++)
		{
			if(T.data ==element)
			{
				rindex = i;
			}
		}
		
		if(T.data ==element)
		{
			rindex = i;
		}
		
		return rindex;
	}
	
	public int remove()
	{
		if(first == null)
		{
			throw new NoSuchElementException("LinkedList is Empty");
		}
		
		if(first == last)
		{
			int item = first.data;
			first = null;
			last = null;
			count--;
			return item;
		}
		
		Node T = first;
		first = first.next;
		T.next = null;
		
		last.next = first;
		
		count--;
		
		return T.data;
		
	}
	
	public int removeFirst()
	{
		return remove();
	}
	
	
	public int removeLast()
	{
		if(first == null)
		{
			throw new NoSuchElementException("LinkedList is Empty");
		}
		
		if(first == last)
		{
			int item = first.data;
			first = null;
			last = null;
			count--;
			return item;
			
		}
		int item = last.data;
		Node T = getNodeAt(count-2);
		
		last.next = null;
		T.next = first;
		last = T;
		count--;
		return item;
		
	}
	
	public int remove(int index)
	{
		if(index<0 || index >=count)
		{
			throw new IndexOutOfBoundsException("Index :"+index+", Size : "+count);
		}
		
		if(first == null)
		{
			throw new NoSuchElementException("LinkedList is Empty");
		}
		
		if(index == 0)
		{
			return removeFirst();
		}
		else if(index == count-1)
		{
			return removeLast();
		}
		else
		{
			Node T = getNodeAt(index);
			Node S = getNodeAt(index-1);
			
			S.next = T.next;
			T.next = null;
			count--;
			return T.data;
			
		}
	}
	
	
	
	
	public boolean removeElement(int element)
	{
		int index = indexOf(element);
		
		if(index == -1)
		{
			return false;
		}
		
		remove(index);
		return true;
	}
	
	public boolean removeFirstOccurrence(int element)
	{
		return removeElement(element);
	}
	
	public boolean removeLastOccurrence(int element)
	{
		int index = lastIndexOf(element);
		
		if(index == -1)
		{
			return false;
		}
		
		remove(element);
		return true;
	}
	
	
	public boolean removeAllOccurrence(int element)
	{
		boolean status = false;
		
		while(removeElement(element))
		{
			status = true;
		}
		
		return status;
	}
	
	public int indexOf(int occurrence, int element)
	{
		if(first == null)
		{
			throw new NoSuchElementException("LinkedList is Empty");
		}
		
		if(occurrence < 1)
		{
			throw new NoSuchElementException("Occurrence should be greater than 0");
		}
		
		
		int cnt = 0;
		int i=0;
		Node T = first;
		for(; T!=last; T = T.next)
		{
			if(T.data == element)
			{
				cnt++;
				if(cnt == occurrence)
				{
					return i;
				}
			}
			i++;
		}
		
		if(T.data == element)
		{
			cnt++;
			if(cnt == occurrence)
			{
				return i;
			}
		}
		i++;
		
		return -1;
	}
}
