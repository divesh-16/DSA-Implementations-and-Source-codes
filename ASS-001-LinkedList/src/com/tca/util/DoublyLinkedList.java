package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DoublyLinkedList 
{
	private Node first;
	private Node last;
	private int count;
	
	private static class Node
	{
		private Node prev;
		private int data;
		private Node next;
		
		public Node(int data)
		{
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}
	
	public DoublyLinkedList()
	{
		first = null;
		count = 0;
		last = null;
	}
	
	
	public void add(int data)
	{
		if(first == null)
		{
			first = new Node(data);
			last = first;
			count++;
		}
		else
		{
			Node T = new Node(data);
			
			last.next = T;
			T.prev = last;
			
			last = last.next;
			
			count++;
		}
	}
	
	public int size()
	{
		return count;
	}
	
	
	public void display()
	{
		for(Node T = first; T != null; T = T.next)
		{
			System.out.print(T.data+"->");
		}
		System.out.println("null");
	}
	
	
	public void reverseDisplay()
	{
		for(Node T = last; T != null; T = T.prev)
		{
			System.out.print(T.data+"->");
		}
		System.out.println("null");
	}
	
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(Node T = first; T != null; T = T.next)
		{
			sj.add(String.valueOf(T.data));
		}
		
		return sj.toString();
	}
	
	
	public void addFirst(int data)
	{
		if(first == null)
		{
			first = new Node(data);
			last = first;
			count++;
		}
		else
		{
			Node T = new Node(data);
			
			T.next = first;
			first.prev = T;
			
			first = T;
			count++;
		}
	}
	
	public void addLast(int data)
	{
		add(data);
	}
	
	
	private Node getNodeAt(int index)
	{
		if(index < 0 || index >= count)
		{
			throw new IndexOutOfBoundsException("Index :"+index+" Size : "+count);
		}
		else
		{
			Node T = first;
			
			for(int i=0; i<count; i++)
			{
				if(i == index)
				{
					return T;
				}
				
				T = T.next;
			}
			return null;
			
		}
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
	
	
	public void add(int index, int data)
	{
		if(index <0 || index>= count)
		{
			throw new IndexOutOfBoundsException("Index :"+index+" Size : "+count);
		}
		
		if(index == 0)
		{
			addFirst(data);
		}
		else if(index == count)
		{
			addLast(data);
		}
		else
		{
			Node T = new Node(data);
			
			Node S = getNodeAt(index-1);
			
			T.next = S.next;
			T.prev = S;
			S.next.prev = T;
			S.next = T;
			
			count++;
		}
	}
	
	public int indexOf(int element)
	{
		int i=0;
		
		for(Node T = first; T!=null; T=T.next)
		{
			if(T.data == element)
			{
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	public int lastIndexOf(int element)
	{
		int i=0;
		int rindex = -1;
		
		for(Node T = first; T!=null; T=T.next)
		{
			if(T.data == element)
			{
				rindex =  i;
			}
			i++;
		}
		
		return rindex;
		
	}
	
	
	public int remove()
	{
		// Removes First node of List
		
		if(first == null)
		{
			throw new NoSuchElementException("Linkedlist is empty");
		}
		
		if(first == last)
		{
			int item = first.data;
			first = null;
			last = null;
			count--;
			return item;
		}
		
		int item = first.data;
		Node T = first;
		first = first.next;
		first.prev = null;
		T.next = null;
		
		count--;
		
		return item;
	}
	
	public int removeFirst()
	{
		return remove();
	}
	
	public int removeLast()
	{
		if(first == null)
		{
			throw new NoSuchElementException("Linkedlist is empty");
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
		last = last.prev;
		
		last.next.prev = null;
		last.next = null;
		count--;
		
		return item;
				
	}
	
	public int remove(int index)
	{
		if(index <0 || index>= count)
		{
			throw new IndexOutOfBoundsException("Index :"+index+" Size : "+count);
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
			Node S = T.prev;
			
			
			S.next = T.next;
			T.next.prev = S;
			
			T.next = null;
			T.prev = null;
			
			count--;
			
			return T.data;
		}
	}
	
	public boolean removeElement(int element)
	{
		// Removes first found element
		
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
	
	public boolean removeLastOccurrencen(int element)
	{
		int index = lastIndexOf(element);
		
		if(index == -1)
		{
			return false;
		}
		
		remove(index);
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
		if(first==null)
		{
			throw new NoSuchElementException("Linkedlist is empty");
		}
		
		if(occurrence < 1)
		{
			throw new NoSuchElementException("Occurrence should be greater than zero");
		}
		
		int cnt = 0;
		int i = 0;
		
		for(Node T = first; T!= null; T=T.next)
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
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
