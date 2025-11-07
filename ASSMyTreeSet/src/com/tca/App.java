package com.tca;

import java.util.TreeSet;

import com.tca.tree.MyTreeSet;

public class App {

	public static void main(String[] args) 
	{
		int a[] = {34,67,45,12,78,55,43,90,11};
		
		
		MyTreeSet set = new MyTreeSet();
		
		for(int i=0; i<a.length; i++)
		{
			set.add(a[i]);
		}
		
		
		System.out.println("No of Nodes : "+set.size());
		
		set.inorder();
		System.out.println();
		set.preorder();
		System.out.println();
		set.postorder();
		System.out.println();
		System.out.println("Leaf Nodes : ");
		set.printLeafNodes();
		System.out.println();
		System.out.println("Non Leaf Nodes : ");
		set.printNonLeafNodes();
		System.out.println();
		System.out.println("Zero Degree Nodes : ");
		set.printZeroDegreeNodes();
		
		System.out.println();
		System.out.println("Level wise : ");
		set.printLevelWise();
		System.out.println();
		System.out.println("No of Nodes : "+set.countNodes());
		
		System.out.println("No of leaf Nodes : "+set.countLeafNodes());
		System.out.println("No of Non leaf Nodes : "+set.countNonLeafNodes());
		System.out.println("Sum of Nodes : "+set.sumOfTree());
		System.out.println();
		
		MyTreeSet ob = set.mirror();
		ob.printLevelWise();
		System.out.println();
		set.printLevelWise();
		set.mirror();
		System.out.println();
		set.printLevelWise();
		

		TreeSet<Integer> s1 = new TreeSet<>();
	}

}
