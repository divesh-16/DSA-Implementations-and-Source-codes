package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DynamicQueue 
{
	private static class Node
	{
		private Node prev;
		private int data;
		private Node next;
		
		public Node(int data)
		{
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	private Node first;
	private Node last;
	private int count;
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public boolean add(int item)
	{
		Node T = new Node(item);
		
		if(first == null)
		{
			first = T;
			last = T;
			count++;
		}
		else
		{
			last.next = T;
			T.prev = last;
			last = last.next;
			
			count++;
			
		}
		
		return true;
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue is Empty");
		}
		else if(first == last)	// Only one node
		{
			count = 0;
			int item = first.data;
			first = null;
			last = null;
			
			return item;
		}
		else
		{
			int item = first.data;
			Node T = first;
			count--;
			
			first = first.next;
			first.prev = null;
			T.next = null;
			
			return item;
			
		}
	}
	
	
	public Integer peek()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return first.data;
		}
	}
	
	public boolean offer(int item)
	{
		return add(item);
	}
	
	
	public Integer poll()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return remove();
		}
	}
	
	
	public int size()
	{
		return count;
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(Node T = first; T!=null; T=T.next)
		{
			sj.add(String.valueOf(T.data));
		}
		
		return sj.toString();
		
		
	}
}
