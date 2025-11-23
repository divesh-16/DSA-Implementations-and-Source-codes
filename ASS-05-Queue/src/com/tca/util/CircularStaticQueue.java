package com.tca.util;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

/*
 * Why Circular Queue : 
 * In Static-Queue, insertion happens from one end(rear) and deletion happens from another(front).
 * When queue is full(i.e rear at n-1) and 'front' has deleted some element,
 * logically the queue is full but practically it is not.
 * If we try to insert an element, it will say Queue is full, which actually is not a case.
 * 
 * */

/*
 * We use wrap-around technique to implement Circular queue.
 * 
 * "Wrap-around" : 
 * 	- When either the front or rear field is increased to the point where it would index past the end of the array
 * 	- It sets rear to 0.
 * 	- Thus, the state is reached where the front section of the queue is in the higher indexed section of the array
 *  and the rear section of the queue in the lower indexed section.
 * */

public class CircularStaticQueue 
{
	private int queue[];
	private int front,rear,capacity,size;
	private static final int CAPACITY = 16;
	
	public CircularStaticQueue()
	{
		this(CAPACITY);
	}
	
	public CircularStaticQueue(int cap)
	{
		capacity = cap;
		size = 0;
		front = 0;
		rear = 0;
		queue = new int[capacity];
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
	
	public boolean add(int item)
	{
		if(isFull())
		{
			throw new IllegalStateException();
		}
		else
		{
			size++;
			
			queue[rear] = item;
			
			rear = (rear+1) % capacity;
			
			return true;
		}
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
			
			int item = queue[(front%capacity)];
			//queue[front] = Integer.MIN_VALUE;
			
			front = (front+1)%capacity;
			
			return item;
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
				
				queue[rear] = item;
				
				rear = (rear+1) % capacity;
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
				int item = queue[(front%capacity)];
				//queue[front] = Integer.MIN_VALUE;
				
				front = (front+1)%capacity;
				
				return item;
			}
		}
	
	public int size()
	{
		return size;
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
