package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class CircularDynamicArrayQueue 
{
	private int queue[];
	private int size,front,rear,capacity;
	private static final int CAPACITY = 16;
	private static int MINCAPACITY = 1 << 15;	// power of two.
	
	public CircularDynamicArrayQueue()
	{
		this(CAPACITY);
	}
	
	public CircularDynamicArrayQueue(int cap)
	{
		queue = new int[cap];
		capacity = cap;
		size = 0;front=0;rear=0;
	}
	
	public boolean isFull()
	{
		return size == capacity;
	}
	
	public boolean isEmpty()
	{
		return size==0;
		// return front==rear;
	}
	
	public int size()
	{
		return size;
	}
	
	private void expand()
	{
		int length = size;
		
		int newQueue[] = new int[length<<1];
		
		
		System.arraycopy(queue, front, newQueue, 0,length );
		
		
		queue = newQueue;
		
		front = 0;
		rear = size;
		
		capacity *= 2;
		
	}
	
	private void shrink()
	{
		int length = size();
		
		// Array should not be reduced then MINCAPACITY, to keep default size and safe.
		if(length<=MINCAPACITY || length <<2 >= length) // 4*length >= length
		{
			return;
		}
		
		if(length < MINCAPACITY )
		{
			length = MINCAPACITY;
		}
		
		int A[] = new int[length];
		capacity = length;
		System.arraycopy(queue, 0, A, 0, length-1);
		
		queue = A;
	}
	
	
	public boolean add(int item)
	{
		if(size == capacity)
		{
			expand();
		}
		
		size++;
		queue[rear] = item;
		
		rear = (rear+1) % capacity;
		
		return true;
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue is Empty");
		}
		else
		{
			size--;
			shrink();
			int data = queue[(front%capacity)];
			
			front = (front+1) % capacity;
			
			return data;
		}
	}
	
	public int capacity()
	{
		return capacity;
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i=0; i<size; i++)
		{
			sj.add(String.valueOf(queue[ (front+i )% capacity]));
		}
		
		return sj.toString();
	}
	

}
