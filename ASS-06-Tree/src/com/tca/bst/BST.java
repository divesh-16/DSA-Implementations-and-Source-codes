package com.tca.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BST 
{
	private BST() {}	// Utility class
	
	
	public static TreeNode insert(TreeNode root, int item)
	{
		TreeNode S = new TreeNode(item);
		if(root==null)
		{
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
		
		if(item <= Q.data)
		{
			Q.left = S;
		}
		else
		{
			Q.right = S;
		}
		
		return root;
	}
	
	
	public static void inorder(TreeNode T) //LDR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			inorder(T.left);
			System.out.print(T.data+" ");
			inorder(T.right);
		}
	}
	
	public static void inorderIteratively(TreeNode T)
	{
		Stack<TreeNode> stk = new Stack<>();
		TreeNode curr = T;
		
		while(curr!=null || !stk.isEmpty())
		{
			while(curr!=null)
			{
				stk.push(curr);
				curr = curr.left;
			}
			
			curr = stk.pop();
			
			System.out.print(curr.data+" ");
			curr = curr.right;
		}
	}
	
	public static void preorder(TreeNode T) // DLR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			System.out.print(T.data+" ");
			preorder(T.left);
			preorder(T.right);
		}
	}
	
	public static void preorderIteratively(TreeNode T)
	{
		if(T==null)
		{
			return;
		}	
		Stack<TreeNode> stk = new Stack<>();
		stk.push(T);
		
		while(!stk.isEmpty())
		{
			TreeNode curr = stk.pop();
			System.out.print(curr.data+" ");
			
			/*
			 	If we push right first then it will move down in stack and accessed after left.
			 	Which is how a preorder should perform(DLR).
			*/
			
			if(curr.right!=null)
			{
				stk.push(curr.right);
			}
			
			if(curr.left!=null)
			{
				stk.push(curr.left);
			}
		}	
		
	}
	
	public static void postorder(TreeNode T) // LRD
	{
		if(T == null)
		{
			return;
		}
		else
		{
			
			postorder(T.left);
			postorder(T.right);
			System.out.print(T.data+" ");
		}
	}
	
	public static void postorderIteratively(TreeNode T)
	{
		if(T==null)
			return;
		
		Stack<TreeNode> stk = new Stack<>();
		Stack<TreeNode> stk2 = new Stack<>();
		stk.push(T);
		
		while(!stk.isEmpty())
		{
			TreeNode curr = stk.pop();
			stk2.push(curr);
			
			if(curr.left != null)
			{
				stk.push(curr.left);
			}
			
			if(curr.right != null)
			{
				stk.push(curr.right);
			}
		}
		
		while(! stk2.isEmpty())
		{
			System.out.print(stk2.pop().data+" ");
		}
	}
	
	
	public static void printLeafNodes(TreeNode T)
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
	
	public static void printNonLeafNodes(TreeNode T) // LRD
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
	
	public static void printZeroDegreeNodes(TreeNode T) // Node with zero child
	{
		printLeafNodes(T);
	}
	
	public static void printOneDegreeNodes(TreeNode T) // Node with one child
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
	
	public static void printTwoDegreeNodes(TreeNode T) // Node with two child
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
	
	public static void printOnlyLeftChildNodes(TreeNode T) //Nodes which have only left child
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left != null && T.right==null)
			{
				System.out.print(T.data+" ");
			}
			
			
			printOnlyLeftChildNodes(T.left);
			printOnlyLeftChildNodes(T.right);
			
		}
	}
	
	
	public static void printOnlyRightChildNodes(TreeNode T) //Nodes which have only right child
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left == null && T.right!=null)
			{
				System.out.print(T.data+" ");
			}
			
			printOnlyRightChildNodes(T.left);
			printOnlyRightChildNodes(T.right);
			
		}
	}
	
	public static void printBothChildNodes(TreeNode T)	// Nodes which have both child
	{
		printTwoDegreeNodes(T);
	}
	
	public static void printLeftSkewedTree(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			System.out.println(T.data+" ");
			printLeftSkewedTree(T.left);
		}
	}
	
	public static void printRightSkewedTree(TreeNode T)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			System.out.println(T.data+" ");
			printRightSkewedTree(T.right);
		}
	}
	
	public static void printRoof(TreeNode T)
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
	
	public static TreeNode search(TreeNode T, int key)
	{
		TreeNode P = T;
		
		while(P!=null)
		{
			if(P.data == key)
			{
				return P;
			}
			else if(key < P.data)
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
	
	public static void printLevelWise(TreeNode T)
	{
		if(T==null)
		{
			System.out.println("Tree is empty");
			return;
		}
		
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
	
	public static int countNodes(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lcnt = countNodes(T.left);
			int rcnt = countNodes(T.right);
			
			return lcnt+rcnt+1;
		}
	}
	
	public static int countLeafNodes(TreeNode T)
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
				return lcnt+rcnt+1;
			else
				return lcnt+rcnt+0;
		}
	}
	
	public static int countNonLeafNodes(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lcnt = countLeafNodes(T.left);
			int rcnt = countLeafNodes(T.right);
			
			if(T.left!=null || T.right!=null)
				return lcnt+rcnt+1;
			else
				return lcnt+rcnt+0;
		}
	}
	
	public static int sumOfTreeElements(TreeNode T)
	{
		if(T == null)
		{
			return 0;
		}
		else
		{
			int lsum = sumOfTreeElements(T.left);
			int rsum = sumOfTreeElements(T.right);
			
			return lsum + rsum + T.data;
		}
	}
	
	public static TreeNode mirror(TreeNode T)
	{
		if(T==null)
		{
			return T;
		}
		else
		{
			TreeNode lm = mirror(T.left);
			TreeNode rm = mirror(T.right);
			
			T.left = rm;
			T.right = lm;
			
			return T;
		}
	}
	
	public static int heightOfTree(TreeNode T)
	{
		if(T==null)
		{
			return 0;
		}
		else
		{
			int lh = heightOfTree(T.left);
			int rh = heightOfTree(T.right);
			
			if(lh>rh)
			{
				return lh + 1;
			}
			else
			{
				return rh + 1;
			}
		}
	}
	
	public static void printLeftChild(TreeNode T)
	{
		if(T == null)
		{
			return;
		}
		else
		{
			if(T.left != null)
			{
				System.out.print(T.left.data);
			}
			printLeftChild(T.left);
			printLeftChild(T.right);
		}
	}
	
	
	public static void getData(TreeNode T, ArrayList<Integer> a)
	{
		if(T==null)
		{
			return;
		}
		else
		{
			
			if(T.left== null && T.right==null)
			{
				a.add(T.data);
			}
			
			getData(T.left,a);
			
			getData(T.right,a);
		}
		
	}
	
	
	public static int depth(TreeNode T, int item)
	{
		if(T==null)
		{
			return 0;
		}
		else if(T.data == item)
		{
			return 1;
		}
		else
		{
			int lc = depth(T.left,item);
			int rc = depth(T.right,item);
			
			if(lc==0 && rc==0)
			{
				return 0;
			}
			else if(lc>rc)
			{
				return lc+1;
			}
			else
			{
				return rc+1;
			}
		}
	}
	
	
	
	
	public static boolean haveSameParent(TreeNode T, int x,int y)
	{
		if(T==null)
		{
			return false;
		}
		else
		{
			if(T.left != null && T.right != null)
			{
				if((T.left.data==x && T.right.data==y) || (T.left.data==y && T.right.data==x))
					return true;
			}
			
			boolean lc = haveSameParent(T.left, x, y);
			boolean rc = haveSameParent(T.right, x, y);
			
			if(lc==true)
				return lc;
			else
				return rc;
		}
	}
	
	
	public static void getLeafNodes(TreeNode T,int level, Map<TreeNode,Integer> map)
    {
        if(T==null)
        {
        	return;
        }
        else
        {
        	if(T.left == null && T.right==null)
        	{
        		map.put(T,level);
        	}
        	
        	getLeafNodes(T.left,level+1,map);
        	getLeafNodes(T.right,level+1,map);
        	
        }
    }
	
	public static MyTreeNode create(TreeNode T,int row,int col)
	{
		if(T==null)
		{
			return null;
		}
		else
		{
			MyTreeNode my = new MyTreeNode(T.data,row,col);
			
			MyTreeNode lc = create(T.left,row+1,col-1);
			MyTreeNode rc = create(T.right,row+1,col+1);
			
			my.left = lc;
			my.right = rc;
			
			return my;
			
		}
	}
	
	public static void inorder(MyTreeNode T) //LDR
	{
		if(T == null)
		{
			return;
		}
		else
		{
			inorder(T.left);
			System.out.println(T.val+": row : "+T.row+": col : "+T.col);
			inorder(T.right);
		}
	}
	
	
	public static HashMap<Integer,List<Integer>> verticalTraversal(MyTreeNode root) 
	{
        HashMap<Integer,HashMap<Integer,List<Integer>>> map = new HashMap<>();
        HashMap<Integer,List<Integer>> send = new HashMap<>();
        MyTraversal(root,map);
        
       
        Set<Integer> s = map.keySet();
        List<Integer> rows = new LinkedList<>(s);
        Collections.sort(rows);
        
        
        for(Integer row : rows)
        {
        	HashMap<Integer, List<Integer>> map2 = map.get(row);
        	
        	Set<Integer> cols = map2.keySet();
        	List<Integer> set = new LinkedList<>(cols);
        	Collections.sort(set);
        	
        	for(Integer col : set)
        	{
        		List<Integer> list = map2.get(col);
        		
        		Collections.sort(list);
        		
        		List<Integer> exists = send.get(col);
        		if(exists == null)
        		{
        			send.put(col, new LinkedList<>());
        			send.get(col).addAll(list);
        		}
        		else
        		{
        			exists.addAll(list);
        		}
        		
        	}
        }
        	
        
        return send;
    }
	
	
	public static void MyTraversal(MyTreeNode root,HashMap<Integer,HashMap<Integer,List<Integer>>> map) 
	{
		if(root == null)
		{
			return;
		}
		else
		{
			HashMap<Integer,List<Integer>> map2 = map.get(root.row);
			if(map2 == null)
			{
				map2 = new HashMap<>();
				map.put(root.row,map2);
				if(map2.get(root.col)==null)
				{
					map2.put(root.col,new LinkedList<Integer>());
					map2.get(root.col).add(root.val);
				}
				else
				{
					List<Integer> list = map2.get(root.col);
					list.add(root.val);
				}
			}
			else
			{
				if(map2.get(root.col)==null)
				{
					map2.put(root.col,new LinkedList<Integer>());
					map2.get(root.col).add(root.val);
				}
				else
				{
					List<Integer> list = map2.get(root.col);
					list.add(root.val);
				}
			}
			
			
			
			MyTraversal(root.left,map);
			MyTraversal(root.right,map);
			
		}
    }
	
}

