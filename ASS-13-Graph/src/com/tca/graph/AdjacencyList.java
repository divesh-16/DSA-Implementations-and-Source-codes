package com.tca.graph;

import java.util.Stack;

public class AdjacencyList 
{
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;
	private int E;
	private MyLinkedList adjList[];
	
	public AdjacencyList(int V)
	{
		if(V < 0)
		{
			throw new IllegalArgumentException("Too few Vertices");
		}
		
		this.V = V;
		this.E = 0;
		adjList = new MyLinkedList[V];
		
		for(int i = 0; i < V; i++)
		{
			adjList[i] = new MyLinkedList();
		}
		
	}
	
	public AdjacencyList(AdjacencyList g)
	{
		this(g.V());
		this.E = g.E();
		
		for(int i = 0; i<g.V(); i++)
		{
			Stack<Integer> stk = new Stack<>();
			for(int j : g.adjList[i])
			{
				stk.push(j);
			}
			
			for(int j : stk)
			{
				adjList[i].add(j);
			}
		}
	}
	
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	private void validateVertex(int u)
	{
		if(u < 0 || u>=V)
		{
			throw new IllegalArgumentException("Vertex "+u+" is not between 0 and "+(V-1));
		}
	}
	
	public void addEdge(int u, int v)
	{
		validateVertex(u);
		validateVertex(v);
		E++;
		adjList[u].add(v);
		adjList[v].add(u);
	}
	
	public Iterable<Integer> adjList(int u)
	{
		validateVertex(u);
		return adjList[u];
	}
	
	public int degree(int u)
	{
		validateVertex(u);
		return adjList[u].size();
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Undirected graph "+NEWLINE);
		sb.append(V+" vertices, "+E+" edges"+NEWLINE);
		
		for(int i=0; i<V; i++)
		{
			sb.append(i +" : ");
			for(int v : adjList[i])
			{
				sb.append(v+" ");
			}
			sb.append(NEWLINE);
		}
		
		return sb.toString();
	}

}
