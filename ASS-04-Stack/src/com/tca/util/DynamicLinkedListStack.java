package com.tca.util;

import java.util.EmptyStackException;
import java.util.StringJoiner;

public class DynamicLinkedListStack 
{
	private Node first;
	private Node top;
	private int count;
	
	private static class Node
	{
		Node prev;
		int data;
		Node next;
		
		public Node(int data)
		{
			this.prev = null;
			this.data = data;
			this.next = null;
					
		}
	}
	
	public DynamicLinkedListStack()
	{
		first = null;
		top = null;
		count = 0;
	}
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public int size()
	{
		return count;
	}
	
	public void push(int item)
	{
		if(first == null)
		{
			first = new Node(item);
			top = first;
			count++;
		}
		else
		{
			Node T = new Node(item);
			top.next = T;
			T.prev = top;
			top = top.next;
			count++;
		}
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			int item = top.data;
			
			if(top == first) //only one Node
			{
				top = null;
				first = null;
				count--;
				return item;
			}
			else
			{
				Node T = top;
				top = top.prev;
				top.next = null;
				T.prev = null;
				count--;
				
				return item;
			}
		}
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return top.data;
		}
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(Node T = first; T!=null; T = T.next)
		{
			sj.add(String.valueOf(T.data));
		}
		
		return sj.toString();
	}
	
}
