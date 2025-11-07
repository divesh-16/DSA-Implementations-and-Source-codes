package com.tca.bst;

public class MyTreeNode 
{
	public MyTreeNode left;
	public int val;
	public MyTreeNode right;
	
	public int col;
	public int row;
	
	public MyTreeNode(int val,int row,int col)
	{
		this.val=val;
		this.row=row;
		this.col = col;
		
		this.left = null;
		this.right = null;
	}
	
}
