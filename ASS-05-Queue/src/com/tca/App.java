package com.tca;

import com.tca.util.CircularStaticQueue;

public class App {

	public static void main(String[] args)
	{
		CircularStaticQueue q = new CircularStaticQueue();
		
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

		
		
		
		

	}

}
