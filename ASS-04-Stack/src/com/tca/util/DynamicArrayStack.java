package com.tca.util;

import java.util.EmptyStackException;
import java.util.StringJoiner;

public class DynamicArrayStack 
{
	// Length of array, used to implement stack.
	private int capacity;
	
	public static int CAPACITY = 16;			//power of 2
	public static int MIN_CAPACITY = 1 << 15;	//power of 2
	
	//Array used to implement stack.
	private int stack[];
	
	// index of top element of the stack in array.
	private int top = -1;
	
	public DynamicArrayStack()
	{
		this(CAPACITY);
	}
	
	public DynamicArrayStack(int capacity)
	{
		this.capacity = capacity;
		stack = new int[capacity];
	}
	
	public int size()
	{
		return top+1;
	}
	
	public int capacity()
	{
		return capacity;
	}
	
	public boolean isEmpty()
	{
		return (top < 0);
	}	
	
	public void push(int item)
	{
		if(size() == capacity)
		{
			expand();
		}
		top++;
		stack[top] = item;
	}
	
	private void expand()
	{
		int length = size();
		int newStack[] = new int[length<<1];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		this.capacity = this.capacity << 1;
	
	}
	
	private void shrink()
	{
		int length = top + 1;
		
		if(length <= MIN_CAPACITY || top<<2 >= length)
		{
			return;
		}
		
		length = length + (top<<1);
		
		if(top<MIN_CAPACITY )
		{
			length = MIN_CAPACITY;
		}
		
		int newStack[] = new int[length];
		
		System.arraycopy(stack, 0, newStack, 0, length);
		
		stack = newStack;
		this.capacity = length;
		
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return stack[top];	
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
			int item = stack[top];
			top--;
			
			shrink();
			
			return item;
		}
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i=0;i<=top; i++)
		{
			sj.add(String.valueOf(stack[i]));
		}
		
		return sj.toString();
	}
}
