package com.tca;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.tca.util.SinglyLinkedList;

public class App {

	public static void main(String[] args)
	{
		
		
		Stack<Integer> stk = new Stack<>();
		List<Integer> L = new LinkedList<>();
		
		stk.push(11);
		stk.push(22);
		stk.push(33);
		
		while(!stk.isEmpty())
		{
			L.add(stk.pop());
		}
		System.out.println(L);
		
		/*
		SinglyLinkedList L1 = SinglyLinkedList.createReverse(5);
		System.out.println(L1);
		*/
		
//		SinglyLinkedList L = new SinglyLinkedList();
//		L.add(11);
//		L.add(22);
//		L.add(33);
		
//		
//		System.out.println(L);
//		//L.displayReverse();
//		//L.display();
//		L.reverse();
//		System.out.println(L);
//	
//		SinglyLinkedList l2 = SinglyLinkedList.create(3);
//		System.out.println(l2);
//		System.out.println("Displaying Reverse : ");
//		l2.displayReverse();
//		
//		
//		
//		System.out.println(L);
//		System.out.println(L.size());
//		System.out.println(L.removeFirst((Integer)22));
//		System.out.println(L);
//		
//		
//		System.out.println(L);
//		System.out.println(L.size());
//		System.out.println(L.removeLast((Integer)22));
//		System.out.println(L);
		
		
	}

}
