package com.tca.util;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;

public class SinglyLinkedList 
{
	private Node first;
	private Node last;
	private int count;
	
	private static class Node
	{
		public int data;
		public Node next;
		
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	
	public SinglyLinkedList()
	{
		first=null;
		last=null;
		count=0;
	}
	
	private SinglyLinkedList(Node first,Node last,int count)
	{
		this.first=first;
		this.last=last;
		this.count=count;
	}
	
	
	public void add(int data)
	{
		if(first==null)
		{
			Node t = new Node(data);
			first = t;
			last = t;
			count++;
		}
		else
		{
			Node t = new Node(data);
			last.next = t;
			last = last.next;
			count++;
		}
	}
	
	public void addFirst(int data)
	{
		if(first==null)
		{
			Node t = new Node(data);
			first = t;
			last = t;
			count++;
		}
		else
		{
			Node t = new Node(data);
			t.next = first;
			first = t;
			count++;
			
		}
	}
	
	public void addLast(int data)
	{
		add(data);
	}
	
	public int size()
	{
		return count;
	}
	
	
	
	public String toString()
	{
		/*
		//Attempt 1 : Worst Approach as you are creating new object of String(which is immutable) every time when you find data in LinkedList.
        // As String is immutable objects s points to every new String which is being created on Heap.
		String s = "[";
		for(Node T = first; T!=null; T=T.next)
		{
			s = s + T.data+",";
		}
		s = s.substring(0,s.length()-1);
		s = s + "]";
		return s;
		
		*/
										//separator,start,end
		StringJoiner sj = new StringJoiner(",","[","]");
		
		for(Node T = first; T!=null; T=T.next)
		{
			sj.add(String.valueOf(T.data));
		}
		
		return sj.toString();
	}
	
	
	private Node getNodeAt(int index)	//helper - Utility function. Functions which are private but are used to process something internally.
	{
		if(index < 0 || index >= count )
		{
			throw new IndexOutOfBoundsException("Index : "+index+" out of bound for length "+count);
		}
		else
		{
			Node t = first;
			
			for(int i=0; i<count; i++)
			{
				if(i==index)
				{
					return t;
				}
				
				t = t.next;
			}
		}
		
		return null;
	}
	
	public int getElement(int index)
	{
		Node t = getNodeAt(index);
		return t.data;
	}
	
	public int setElement(int index,int element)
	{
		Node t = getNodeAt(index);	// Take the node
		int item = t.data;			// save node's data in item
		t.data = element;			// change node's data by element
		return item;				// return item's data;
	}
	
	public void add(int index, int element)
	{
		if(index < 0 || index > count)
		{
			throw new IndexOutOfBoundsException("Index : "+index+" out of bound for length "+count);
		}
		
		if(index == 0)
		{
			addFirst(element);
		}
		else if(index == count)
		{
			addLast(element);
		}
		
		Node t = new Node(element);
		
		Node s = getNodeAt(index - 1);
		
		//Adhi Joda/Phele Jodo/First Join
		t.next = s.next;
		
		//mag Toda/Phir todo/ break the link
		s.next = t;
		count++;
		
		
	}
	
	
	public int indexOf(int element)
	{
		int i=0;
		for(Node t = first; t!=null; t= t.next)
		{
			if(t.data == element)
			{
				return i;
			}
			
			i++;
		}
		
		return -1;
	}
	
	public int lastIndexOf(int element)
	{
		int i=0;
		int rindex=-1;
		
		for(Node t = first; t!=null; t= t.next)
		{
			if(t.data == element)
			{
				rindex = i ;
			}
			
			i++;
		}
		
		return rindex;
		
	}
	
	public int remove()
	{
		if(first == null)
		{
			throw new NoSuchElementException("Linked List is Empty");
		}
		
		if(first == last)	//When there is only one element int the Linked List
		{
			int item = first.data;
			first = null;
			last = null;
			count = 0;
			return item;
		}
		
		int item = first.data;
		Node t = first; 
		first = first.next;
		t.next = null;
		
		count--;
		
		return item;
		
	}
	
	public int removeFirst()
	{
		return remove();
		
	}
	
	public int removeLast()
	{
		if(first == null)
		{
			throw new NoSuchElementException("Linked list is empty");
		}
		
		if(first == last)
		{
			int item = last.data;
			first = null;
			last = null;
			count--;
			
			return item;
					
		}
		
		int item = last.data;
		last = getNodeAt(count - 2);	//tell last to point/refer to one node previous of last node.
		last.next = null;				//remove last node and do count--;
		count--;
		
		return item;
	}
	
	
	public int remove(int index)
	{
		if(index == 0)
		{
			return remove();
		}
		else if(index == count-1)
		{
			return removeLast();
		}
		
		Node t = getNodeAt(index);
		Node s = getNodeAt(index -1);
		int item = t.data;
		s.next = t.next;
		t.next = null;
		
		return item;
		
	}
	
	public boolean remove(Integer element)
	{
		boolean flag = false;
		
		int index = indexOf(element);
		if(index == -1)		//element is not present
		{
			return flag;
		}
		
		flag = true;	//element is present
		int item = remove(index);
		return flag;
			
	}
	
	public boolean removeFirst(Integer element)
	{
		return remove(element);
	}
	
	public boolean removeLast(Integer element)
	{	
		boolean flag = false;
		int index = lastIndexOf(element);
		if(index == -1)		//element is not present
		{
			return flag;
		}
		
		flag = true;	//element is present
		int item = remove(index);
		return flag;
		
	}
	
	public void display()
	{
		/*
		for(Node T = first; T!=null; T=T.next)
		{
			System.out.print(T.data+"->");
		}
		System.out.println("null");
		*/
		
		displayHelper(first);
	}
	
	private void displayHelper(Node head)
	{
		if(head==null)
		{
			return;
		}
		
		System.out.println(head.data);
		displayHelper(head.next);
	}
	
	public void displayReverse()
	{
		displayReverseHelper(first);
	}
	
	private void displayReverseHelper(Node head)
	{
		if(head == null)
		{
			return;
		}
		displayReverseHelper(head.next);
		System.out.println(head.data);
		
	}
	
	public void reverse()
	{
		first = reverseHelper(first);
	}
	
	private Node reverseHelper(Node head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node T = reverseHelper(head.next);
		head.next = null;
		Node S = T;
		while(S.next !=null)
		{
			S = S.next;
		}
		S.next = head;
		
		return T;
		
	}
	
	private static Node createHelper(int n)
	{
		
//		if(n>0)
//		{
//			Scanner sc = new Scanner(System.in);
//			System.out.print("Enter Data : ");
//			int data = sc.nextInt();
//			
//			Node T = new Node(data);
//			
//			T.next = createHelper(n-1);
//			
//			return T;
//			
//			//return new Node(data).next = createHelper(--n);
//			//return new Node(data).next = createHelper(--n);
//		}
//		else
//		{
//			return null;
//		}	
		
		if(n==0)
		{
			return null;
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Data : ");
			int data = sc.nextInt();
			
			Node T = new Node(data);
			
			T.next = createHelper(n-1);
			
			return T;
		}
			
	}
	
	public static SinglyLinkedList create(int n)
	{
		Node first = createHelper(n);
		Node T = first;
		int cnt=0;
		while(T.next != null)
		{
			T = T.next;
			cnt++;
		}
		Node last = T;
		int count = cnt;
		
		SinglyLinkedList ob = new SinglyLinkedList(first,last,count);
		return ob;
		
	}
	
	
	public static SinglyLinkedList createReverse(int n)
	{
		Node first = createReverseHelper(n,null);
		Node T = first;
		int cnt = 0;
		while(T.next!=null)
		{
			T = T.next;
			cnt++;
		}
		
		Node last = T;
		SinglyLinkedList ob = new SinglyLinkedList(first,last,cnt);
		return ob;
	}
	
	private static Node createReverseHelper(int n,Node P)
	{
		if(n==0)
		{
			return P;
		}
		else
		{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Data : ");
			int data = sc.nextInt();
			
			Node T = new Node(data);
						
			T.next = P;
			return createReverseHelper(n-1,T);
			
		
		}
	}
	
}
