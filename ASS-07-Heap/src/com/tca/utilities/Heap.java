package com.tca.utilities;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class Heap 
{
	private int[] heap;
	private int count;
	private int capacity;
	public static int CAPACITY = 16;
	
	public Heap()
	{

		this.capacity = CAPACITY;
		this.count = 0;
		this.heap = new int[capacity];
	}
	
	public Heap(int capacity)
	{
		this.capacity = capacity;
		this.count = 0;
		this.heap = new int[capacity];
	}
	
	public int getParent(int index)
	{		
		 if (index == 0)
		 {
			 throw new NoSuchElementException("Root has no parent");
		 }
		    return heap[getParentIndex(index)];
	}
	
	private int getParentIndex(int index)
	{
		if(heap == null)
		{
			throw new NullPointerException("Heap is Null");
		}
		
		if(index <=0 || index>count)
		{
			throw new IllegalArgumentException("Invalid Index");
		}
		
		return (index-1)/2;
	}
	
	private int getLeftChildIndex(int index)
	{
		if(heap == null)
		{
			throw new NullPointerException("Heap is Null");
		}
		
		if(index < 0)
		{
			throw new IllegalArgumentException("Invalid should be greater than 0");
		}
		
		int left = 2 * index + 1;
		if(left >= count)
		{
			throw new NoSuchElementException("Left child is not present");
		}
		return left;
	}
	
	private int getRightChildIndex(int index)
	{
		if(heap == null)
		{
			throw new NullPointerException("Heap is Null");
		}
		
		if(index < 0)
		{
			throw new IllegalArgumentException("Invalid should be greater than 0");
		}
		
		int right = 2 * index + 2;
		if(right >= count)
		{
			throw new NoSuchElementException("Right child is not present");
		}
		return right;
	}
	
	public int getLeftChild(int index)
	{
		return heap[getLeftChildIndex(index)];
	}
	
	public int getRightChild(int index)
	{
		return heap[getRightChildIndex(index)];
	}
	
	public boolean isEmpty()
	{
		return count == 0 ;
	}
	
	public int getMaximum()
	{
		if(heap == null)
		{
			throw new NullPointerException("Heap is Null");
		}
		
		if(isEmpty())
		{
			throw new NoSuchElementException("Heap is empty");
		}
		
		return heap[0];
	}
	
	
	private void heapify(int index)
	{
		int largest = index;
	    int left = 2 * index + 1;
	    int right = 2 * index + 2;

	    if (left < count && heap[left] > heap[largest])
	        largest = left;

	    if (right < count && heap[right] > heap[largest])
	        largest = right;

	    if (largest != index)
	    {
	        int t = heap[index];
	        heap[index] = heap[largest];
	        heap[largest] = t;
	        heapify(largest);
	    }
		
	}
	
	
	public int deleteMax()
	{
		if(heap == null || count == 0)
		{
			throw new NoSuchElementException("Heap is Empty");
		}
		
		int data = heap[0];
		heap[0] = heap[count-1];
		count--;
		heapify(0);
		return data;
	}
	
	public void insert(int data)
	{
		int index;
	
		if(count == capacity)
		{
			resizeHeap();
		}
		count++;
		index = count-1;
		heap[index] = data;
		if(index == 0)	// inserting first element.
		{
			return;
		}
		
		while (index > 0 && data > getParent(index))
		{
		    heap[index] = heap[getParentIndex(index)];
		    index = getParentIndex(index);
		}

		
		heap[index] = data;
	}
	
	private void resizeHeap()
	{
		
	    int[] old = heap;
	    heap = new int[capacity * 2];

	    if (old != null)
	    {
	        System.arraycopy(old, 0, heap, 0, count);
	    }

	    capacity *= 2;
	}
	
	public String toString()
	{
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(int i=0; i<count; i++)
		{
			sj.add(String.valueOf(heap[i]));
		}
		
		return sj.toString();
	}
	
	public void buildHeap(int a[])
	{
		int n = a.length;
		this.count = n;
		this.capacity = n;
		heap = a;
		
		for(int i = n/2-1; i>=0; i--)	// last non-leaf node.
		{
			heapify(i);
		}
	}
	private void heapify(int a[], int n,int i)
	{
		int largest = i;
		int lc = 2*i+1;
		int rc = 2*i+2;
		
		if(lc < n && a[lc] > a[largest])
		{
			largest = lc;
		}
		
		if(rc < n && a[rc] > a[largest])
		{
			largest = rc;
		}
		
		if(largest != i)
		{
			int t = a[i];
			a[i] = a[largest];
			a[largest] = t;
			heapify(a,n,largest);
		}
	}
	
	public void heapSort(int a[])
	{
		int n = a.length;
		
		for(int i=n/2-1; i>=0; i--)		// building heap
		{
			heapify(a,n,i);
		}
		
		for(int i=n-1; i>=0; i--)
		{
			int t = a[0];
			a[0] = a[i];
			a[i] = t;
			heapify(a,i,0);
		}
		
	}
	
	
	
}
