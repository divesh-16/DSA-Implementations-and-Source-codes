package com.tca;

import com.tca.util.DynamicQueue;

public class App {

	public static void main(String[] args)
	{
		
		DynamicQueue q = new DynamicQueue();
		
		q.add(11);
		q.add(22);
		q.add(33);
		
		
		System.out.println(q);
		
		
		
		System.out.println("Removed "+q.remove());
		System.out.println("Removed "+q.remove());
		System.out.println("Removed "+q.remove());

		
		System.out.println(q);
		q.add(33);
		q.offer(44);
		q.offer(55);
		
		System.out.println(q);
		
		System.out.println("Removed "+q.poll());
		System.out.println("Removed "+q.poll());
		System.out.println("Removed "+q.poll());
		System.out.println("Removed "+q.poll());
		
		System.out.println(q);
		
		
		
		
		
		
//		CircularDynamicArrayQueue q = new CircularDynamicArrayQueue();
//		
//		for(int i=1; i<=18; i++)
//		{
//			q.add(i);
//		}
//		
//
//		System.out.println(q.size());
//		System.out.println(q.capacity());
//		System.out.println(q);
//		
//		
//		System.out.println(q.remove());
//		System.out.println(q.remove());
//		System.out.println(q.remove());
//		
//		System.out.println(q.size());
//		System.out.println(q.capacity());
//		System.out.println(q);
//		
//		
		
			
		
		
		
//		CircularStaticQueue q = new CircularStaticQueue();
//		
//		q.add(11);
//		q.add(22);
//		q.add(33);
//		
//		
//		System.out.println(q);
//		
//		
//		
//		System.out.println("Removed "+q.remove());
//		System.out.println("Removed "+q.remove());
//		System.out.println("Removed "+q.remove());
//
//		
//		System.out.println(q);
//		q.add(33);
//		q.offer(44);
//		q.offer(55);
//		
//		System.out.println(q);
//		
//		System.out.println("Removed "+q.poll());
//		System.out.println("Removed "+q.poll());
//		System.out.println("Removed "+q.poll());
//		System.out.println("Removed "+q.poll());
//		
//		System.out.println(q);

		
		
		
		

	}

}
