package com.tca.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterable<Integer>
{
	private ListNode<Integer> head;
	private int n;
	
	private static class ListNode<Integer>
	{
		private Integer data;
		private ListNode<Integer> next;
	}
	
	public MyLinkedList()
	{
		head = null;
		n = 0;
	}
	
	public int size()
	{
		return n;
	}

	
	
	public void add(Integer data)
	{
		ListNode<Integer> oldfirst = head;
		head = new ListNode<Integer>();
		head.data = data;
		head.next = oldfirst;
		n++;
	}
	
	@Override
	public Iterator<Integer> iterator() 
	{
		return new ListIterator(head);
	}
	
	private class ListIterator implements Iterator<Integer>
	{
		private ListNode<Integer> current;
		
		public ListIterator(ListNode<Integer> head)
		{
			current = head;
		}
		
		@Override
		public boolean hasNext() 
		{
			return current != null;
		}

		@Override
		public Integer next() 
		{
			if(!hasNext()) 
				throw new NoSuchElementException();
			
			Integer data = current.data;
			current = current.next;
			
			return data;
			
		}
		
	}
	
}
