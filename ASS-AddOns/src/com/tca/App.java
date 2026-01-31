package com.tca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.tca.comparators.NameComparator;
import com.tca.comparators.RnoComparator;
import com.tca.entities.Student;

public class App 
{
	private static List<List<Integer>> parent = new LinkedList<>();
	public static void subsequence(int index, int a[],int n,LinkedList<Integer> ds)
	{
		if(index == n)
		{
			System.out.println(ds);
			return;
		}
		
		ds.add(a[index]);
		subsequence(index+1,a,n,ds);
		ds.removeLast();
		
		subsequence(index+1,a,n,ds);
	}
	
	public static void sumOfSubWithK(int index, LinkedList<Integer> ds,int a[] ,int sum,int k,int n)
	{
		if(index==n)
		{
			if(sum == k)
			{
				System.out.println(ds);
			}
			
			return;
		}
		
		ds.add(a[index]);
		sum += a[index];
		sumOfSubWithK(index+1, ds, a, sum, k, n);
		
		ds.removeLast();
		sum -= a[index];
		sumOfSubWithK(index+1, ds, a, sum, k, n);
	}
	
	public static void combination(int index, LinkedList<Integer> ds,int a[] ,int sum,int n)
	{
		if(index==n)
		{
			if(sum == 0)
			{

				List<Integer> child = new ArrayList<>(ds);
				parent.add(child);
			}
			
			return;
		}
		
		if(a[index]<=sum)
		{
			ds.add(a[index]);
			combination(index, ds, a, sum-a[index], n);
			ds.removeLast();
		}
		
		combination(index+1, ds, a, sum, n);
	}

	public static void main(String[] args) 
	{
//		int a[] = {1,2,1};
//		
//		LinkedList<Integer> ds = new LinkedList<>();
//		int n=3;
//		//subsequence(0, a, n, ds);
//		int k = 2;
//		
//		sumOfSubWithK(0, ds, a, 0, k, n);
//		combination(0, ds, a, 2, n);
//		System.out.println(parent);
		
		
		Student s1 = new Student(101,"AAA",60.0);
		Student s2 = new Student(103,"BBB",70.0);
		Student s3 = new Student(102,"CCC",50.0);
		
		List<Student> L = new ArrayList<>();
		L.add(s1);
		L.add(s2);
		L.add(s3);
		
		
		System.out.println(L);
		System.out.println("-------------------------------------------------------------------");
		Collections.sort(L,new NameComparator());
		System.out.println(L);
		System.out.println("-------------------------------------------------------------------");
		Collections.sort(L,new RnoComparator());
		System.out.println(L);
	}

}
