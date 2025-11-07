package com.tca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		int a[] = {1,2,1};
		
		LinkedList<Integer> ds = new LinkedList<>();
		int n=3;
		//subsequence(0, a, n, ds);
		int k = 2;
		
		sumOfSubWithK(0, ds, a, 0, k, n);
		combination(0, ds, a, 2, n);
		System.out.println(parent);
	}

}
