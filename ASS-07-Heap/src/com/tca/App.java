package com.tca;

import java.util.Arrays;

import com.tca.utilities.Heap;

public class App {

	public static void main(String[] args) 
	{
		int a[] = {11,33,66,55,77,44,22};
		Heap h = new Heap(10);
		h.insert(33);
		h.insert(55);
		h.insert(11);
		
		System.out.println(h);
		System.out.println(h.deleteMax());
		System.out.println(h);
		System.out.println(h.deleteMax());
		System.out.println(h);
		System.out.println(h.deleteMax());
		System.out.println(h);
		
		h.buildHeap(a);
		System.out.println(h);
		h.insert(99);
		System.out.println(h);
		h.insert(10);
		System.out.println(h);
		
		
//		System.out.println(Arrays.toString(a));
//		h.heapSort(a);
//		System.out.println(Arrays.toString(a));
		
		// Complete buildHeap and heapsort function
	}

}
