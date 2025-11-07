package com.tca.util;

import java.util.EmptyStackException;
import java.util.StringJoiner;

public class StaticStack 
{
	//Length of array to implement stack
	private int capacity;
	
	//Array used to implement stack
	private int stack[];
	
	//Index of top element of stack
	private int top=-1;
	
	//Deafult Array Capacity
	public static int CAPACITY = 10;
	
	public StaticStack()
	{
		this.capacity = CAPACITY;
		stack = new int[capacity];
		top = -1;
	}
	
	public StaticStack(int capacity)
	{
		if(capacity < 1)
		{
			throw new IllegalArgumentException("Capacity should be greater than 0 !");
		}
		
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1;
	}
	
	//How much elements in stack
	public int size()
	{
		return top+1;
	}
	
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public boolean isFull()
	{
		return top == (capacity)-1;
	}
	
	
	public void push(int item)
	{
		if(isFull())
		{
			throw new StackOverflowError("Stack is Overflow");
		}
		else
		{
			top++;
			stack[top] = item;
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
			return item;
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
			return stack[top];	
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
