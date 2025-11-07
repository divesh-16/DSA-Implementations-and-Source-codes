package com.tca;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.tca.bst.BST;
import com.tca.bst.MyTreeNode;
import com.tca.bst.TreeNode;

public class App {

	public static void main(String[] args) 
	{
		TreeNode root = null;
		
		int a[] = {34,67,45,12,78,55,43,90,11};
		
		for(int i=0; i<a.length; i++)
		{
			root = BST.insert(root, a[i]);
		}
		
		MyTreeNode my = BST.create(root, 0, 0);
		BST.inorder(my);
		
		HashMap<Integer, List<Integer>> map = BST.verticalTraversal(my);
		
		Set<Integer> cols = map.keySet();
		List<Integer> set = new LinkedList<>(cols);
		Collections.sort(set);
		
		List<List<Integer>> lists = new LinkedList<>();
		
		for(Integer col : set)
		{
			List<Integer> list = map.get(col);
			lists.add(list);
		}
		
		System.out.println(lists);
		
		
		
		/*
		
		HashMap<TreeNode,Integer> map = new HashMap<>();
		
		BST.getLeafNodes(root, 0, map);
		
		Set<TreeNode> keySet = map.keySet();
		
		for(TreeNode T : keySet)
		{
			System.out.println(T.data+" : "+map.get(T));
		}
		
		System.out.println(keySet.size());
		
		*/
		
		
		
		
		
		/*
		System.out.println("Inorder Recursively : ");
		BST.inorder(root);
		System.out.println();
		System.out.println("Inorder Iteratively : ");
		BST.inorderIteratively(root);
		System.out.println();
		
		System.out.println("Preorder Recursively : ");
		BST.preorder(root);
		System.out.println();
		System.out.println("Preorder Iteratively : ");
		BST.preorderIteratively(root);
		System.out.println();
		
		
		System.out.println("Postorder Recursively : ");
		BST.postorder(root);
		System.out.println();
		System.out.println("Postorder Iteratively : ");
		BST.postorderIteratively(root);
		System.out.println();
		*/
		//BST.printLevelWise(root);
		
		
		/*
		int d = BST.depth(root,43);
		System.out.println("Depth : "+(d-1));
		
		System.out.println("are sibling : "+BST.haveSameParent(root,55,43));
		*/
		/*
		System.out.println("Inorder : ");
		BST.inorder(root);
		System.out.println();

		System.out.println("Preorder : ");
		BST.preorder(root);
		System.out.println();
		
		System.out.println("Postorder : ");
		BST.postorder(root);
		System.out.println();
		
		System.out.println("Zero Degree : ");
		BST.printZeroDegreeNodes(root);
		System.out.println();
	
		System.out.println("One Degree : ");
		BST.printOneDegreeNodes(root);
		System.out.println();
		
		System.out.println("Two Degree : ");
		BST.printTwoDegreeNodes(root);
		System.out.println();
		
		System.out.println("Left Child : ");
		BST.printOnlyLeftChildNodes(root);
		System.out.println();
		
		System.out.println("Right Child : ");
		BST.printOnlyRightChildNodes(root);
		System.out.println();
		
		System.out.println("Nodes with Child : ");
		BST.printBothChildNodes(root);
		System.out.println();
		*/
		
	
	}
	
	

}
