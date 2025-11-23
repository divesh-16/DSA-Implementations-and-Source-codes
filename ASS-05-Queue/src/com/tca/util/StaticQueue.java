package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class StaticQueue 
{
	private int queue[];
	private int front,rear,capacity,size=0;
	private static final int CAPACITY = 16;	// Default size if not given.
	
	public StaticQueue() 
	{
		this(CAPACITY);	// If capacity not given by user then assign default capacity;
	}
	
	public StaticQueue(int cap)
	{
		capacity = cap;
		queue = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return front == rear;
		// return size == 0;
	}
	
	public boolean isFull()
	{
		return size == this.capacity;
		// rear == queue.length-1;
	}
	
	// insert element in the Queue from 'rear' AKA - enQueue
	// throws exception if not inserted otherwise true
	public boolean add(int item)
	{
		if(isFull())
		{
			throw new IllegalStateException();
		}
		else
		{
			rear++;
			size++;
			queue[rear] = item;
			return true;
		}
	}
	
	// returns front element if queue is not empty otherwise throws exception
	public int remove()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException("Queue is Empty");
		}
		else
		{
			size--;
			front++;
			return queue[front];
		}
	}
	
	// Add and returns if element is inserted in queue otherwise it returns false.
	public boolean offer(int item)
	{
		if(isFull())
		{
			return false; 
		}
		else
		{
			size++;
			rear++;
			queue[rear] = item;
			return true;
		}
	}
	
	
	// Returns and remove front element queue otherwise returns null.
	public Integer poll()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			size--;
			front++;
			return queue[front];
		}
	}
	
	/*
	 * Returns the front element without removing it otherwise null when queue is empty.
	 * */
	public Integer peek()
	{
		if(isEmpty())
		{
			return null;
		}
		else
		{
			return queue[front+1];
		}
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i = front+1; i<= rear; i++)
		{
			sj.add(String.valueOf(queue[i]));
		}
		
		return sj.toString();
	}
	
}
