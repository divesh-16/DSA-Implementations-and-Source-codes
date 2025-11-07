package com.tca.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTreeSet 
{
	private TreeNode root;
	private int count;
	
	private static class TreeNode 
	{
		public TreeNode left;
		public int data;
		public TreeNode right;
		
		public TreeNode(int data)
		{
			this.left = null;
			this.data = data;
			this.right = null;
		}
	}
	
	public MyTreeSet()
	{
		this.root = null;
		this.count = 0;
	}
	
	private MyTreeSet(TreeNode root,int count)
	{
		this.root = null;
		this.count = 0;
	}
	
	public void add(int item)
	{
		this.root = addHelper(item,this.root);
	}
	
	private TreeNode addHelper(int item,TreeNode root)
	{
		TreeNode S = new TreeNode(item);
		if(root==null)
		{
			count++;
			return S;
			
		}
		
		TreeNode P = root;
		TreeNode Q = null;
		
		while(P!=null)
		{
			Q = P;
			
			if(item <= P.data)
			{
				P = P.left;
			}
			else
			{
				P = P.right;
			}
		}
		
		if(item<=Q.data)
		{
			Q.left = S;
			count++;
		}
		else
		{
			Q.right = S;
			count++;
		}
		
		return root;
	}
	
	public int size()
	{
		return count;
	}
	
	public void inorder()
	{
		inorderHelper(root);
	}
	
	private void inorderHelper(TreeNode T) //LDR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			inorderHelper(T.left);
			System.out.print(T.data+" ");
			inorderHelper(T.right);
		}
	}
	
	public void preorder()
	{
		preorderHelper(root);
	}
	
	private void preorderHelper(TreeNode T) //DLR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			System.out.print(T.data+" ");
			preorderHelper(T.left);
			preorderHelper(T.right);
		}
	}
	
	public void postorder()
	{
		postorderHelper(root);
	}
	
	private void postorderHelper(TreeNode T) //DLR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			postorderHelper(T.left);
			postorderHelper(T.right);
			System.out.print(T.data+" ");
		}
	}
	
	public void printLeafNodes()
	{
		printLeafNodes(this.root);
	}
	
	private void printLeafNodes(TreeNode T)
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left==null && T.right==null)
			{
				System.out.print(T.data+" ");
			}
			printLeafNodes(T.left);
			printLeafNodes(T.right);
			
		}
	}
	
	public void printNonLeafNodes()
	{
		printNonLeafNodes(root);
	}
	
	private void printNonLeafNodes(TreeNode T) // LRD
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left!=null || T.right!=null)
			{
				System.out.print(T.data+" ");
			}
			printNonLeafNodes(T.left);
			printNonLeafNodes(T.right);
			
		}
	}
	
	public void printZeroDegreeNodes() // Node with zero child
	{
		printLeafNodes(root);
	}
	
	public void printOneDegreeNodes() // Node with one child
	{
		printOneDegreeNodes(root);
	}
	
	private void printOneDegreeNodes(TreeNode T) // Node with one child
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if((T.left != null && T.right==null) || (T.left == null && T.right!=null))
			{
				System.out.print(T.data+" ");
			}
			
			
			printOneDegreeNodes(T.left);
			printOneDegreeNodes(T.right);
			
		}
	}
	
	public void printTwoDegreeNodes() // Node with two child
	{
		printTwoDegreeNodes(root);
	}
	
	private void printTwoDegreeNodes(TreeNode T) // Node with two child
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left != null && T.right != null)
			{
				System.out.print(T.data+" ");
			}
			
			
			printTwoDegreeNodes(T.left);
			printTwoDegreeNodes(T.right);
			
		}
	}
	
	public void printOnlyLeftChild()
	{
		printOnlyLeftChild(root);
	}
	
	private void printOnlyLeftChild(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			if(T.left!=null && T.right==null)
			{
				System.out.print(T.data+" ");
			}
			
			printOnlyLeftChild(T.left);
			printOnlyLeftChild(T.right);
			
		}
	}
	
	public void printOnlyRightChild()
	{
		printOnlyRightChild(root);
	}
	
	private void printOnlyRightChild(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			if(T.left==null && T.right!=null)
			{
				System.out.print(T.data+" ");
			}
			
			printOnlyLeftChild(T.left);
			printOnlyLeftChild(T.right);
			
		}
	}
	
	public void printBothChildNodes(TreeNode T)	// Nodes which have both child
	{
		printTwoDegreeNodes(T);
	}
	
	
	public void printLeftSkewedTree()
	{
		printLeftSkewedTree(root);
	}
	
	private void printLeftSkewedTree(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			System.out.print(T.data);
			printLeftSkewedTree(T.left);
		}
	}
	
	public void printRightSkewedTree()
	{
		printRightSkewedTree(root);
	}
	
	private void printRightSkewedTree(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			System.out.print(T.data);
			printLeftSkewedTree(T.right);
		}
	}
	
	public void printRoof()
	{
		printRoof(root);
	}
	
	private void printRoof(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			printLeftSkewedTree(T);
			printRightSkewedTree(T.right);
		}
	}
	
	public boolean search(int key)
	{
		TreeNode T = search(root,key);
		if(T!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private TreeNode search(TreeNode T,int key)
	{
		TreeNode P = T;
		
		while(P!=null)
		{
			if(key == P.data)
			{
				return P;
			}
			else if(key <= P.data)
			{
				P = P.left;
			}
			else
			{
				P = P.right;
			}
		}
		
		return null;
	}
	
	public void printLevelWise()
	{
		printLevelWise(root);
	}
	
	private void printLevelWise(TreeNode T)
	{
		if(T==null)
		{
			System.out.println("Tree is empty");
			return;
		}
		else
		{
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(T);
			
			while(!queue.isEmpty())
			{
				TreeNode front = queue.peek();
				System.out.print(front.data+" ");
				
				if(front.left!=null)
				{
					queue.add(front.left);
				}
				
				if(front.right!=null)
				{
					queue.add(front.right);
				}
				
				queue.remove();
			}
		}
	}
	
	public int countNodes()
	{
		return countNodes(root);
	}
	
	private int countNodes(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lcnt = countNodes(T.left);
			int rcnt = countNodes(T.right);
			
			return lcnt + rcnt + 1;
		}
	}
	
	public int countLeafNodes()
	{
		return countLeafNodes(root);
	}
	
	private int countLeafNodes(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lcnt = countLeafNodes(T.left);
			int rcnt = countLeafNodes(T.right);
			
			if(T.left==null && T.right==null)
			{
				return lcnt + rcnt + 1;
			}
			else
			{
				return lcnt + rcnt + 0;
			}
		}
	}
	
	public int countNonLeafNodes()
	{
		return countNonLeafNodes(root);
	}
	
	private int countNonLeafNodes(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lcnt = countLeafNodes(T.left);
			int rcnt = countLeafNodes(T.right);
			
			if(T.left != null || T.right != null)
			{
				return lcnt + rcnt + 1;
			}
			else
			{
				return lcnt + rcnt + 0;
			}
		}
		
		/*
			int total = countNodes(root);
			int leaf = countLeafNodes(root;
			return total - leaf;
			
		*/
	}
	
	
	
	public int sumOfTree()
	{
		return sumOfTree(root);
	}
	
	private int sumOfTree(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lsum = sumOfTree(T.left);
			int rsum = sumOfTree(T.right);
			
			return lsum + rsum + T.data;
		}
	}
	
	public MyTreeSet mirror()
	{
		TreeNode T = mirror(root);
		int count  = countNodes(T);
		
		return new MyTreeSet(T,count);
		
	}
	
	private TreeNode mirror(TreeNode T)
	{
		if(T==null)
		{
			return null;
		}
		else
		{
			TreeNode lc = mirror(T.left);
			TreeNode rc = mirror(T.right);
			
			T.left = rc;
			T.right = lc;
			
			return T;
		}
	}
	
}
