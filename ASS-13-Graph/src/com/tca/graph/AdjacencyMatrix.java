package com.tca.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix 
{
	private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;	// no of vertex
	private int E;	// no of edges;
	private boolean graph[][];
	
	public AdjacencyMatrix(int V)
	{
		if(V < 0 ) throw new IllegalArgumentException("Too few vertices");
		
		this.V = V;
		this.E = 0;
		this.graph = new boolean[V][V];
	}
	
	public int getV() 
	{
		return V;
	}
	
	public int getE()
	{
		return E;
	}
	
	
	public void addEdge(int i,int j)
	{
		if(i != j && !graph[i][j])
		{
			E++;
			
			graph[i][j] = true;
			graph[j][i] = true;
		}	
	}
	
	//does the graph contains the edge
	
	public boolean contains(int i,int j)
	{
		return graph[i][j];
	}
	
	public Iterable<Integer> adjMatrix(int i)
	{
		return new AdjIterator(i);
	}
	
	private class AdjIterator implements Iterator<Integer>,Iterable<Integer>
	{
		private int i;
		private int v=0;

		AdjIterator(int i)
		{
			this.i=i;
		}
		
		@Override
		public Iterator<Integer> iterator() 
		{
			return this;
		}

		@Override
		public boolean hasNext() 
		{
			while(v < V)
			{
				if(graph[i][v])
					return true;
				v++;
			}
			return false;
		}

		@Override
		public Integer next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			return v++;
		}
		
			
	}
	
	
	public List<Integer> DFS(int start)
	{
		List<Integer> dfs = new ArrayList<>();
		boolean visited[] = new boolean[V];
		Stack<Integer> stk = new Stack<>();
		int current = start;
		stk.push(current);
		
		
		while(!stk.isEmpty())
		{
			current = stk.pop();
			
			if(!visited[current])
			{
				visited[current] = true;
				dfs.add(current);
				
				// add adjacent
				
				for(int j=0; j<V; j++)
				{
					if(graph[current][j] && !visited[j])
					{
						stk.push(j);
					}
				}
			}
		}
		
		return dfs;
			
	}
	
	
	public List<Integer> BFS(int start)
	{
		boolean[] visited = new boolean[V];
		int current = start;
		List<Integer> bfs = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(current);
		
		while(! q.isEmpty())
		{
			current = q.remove();
			
			if(!visited[current])
			{
				visited[current] = true;
				bfs.add(current);
				
				for(int j=0; j<V; j++)
				{
					if(graph[current][j] && !visited[j])
					{
						q.add(j);
					}
				}
			}
		}
		
		return bfs;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Undirected Graph "+NEWLINE);
		sb.append("Vertices : "+V+" and edges : "+E+NEWLINE);
		
		for(int i=0; i<V; i++)
		{
			sb.append(i+" : ");
			for(int j=0; j<V; j++)
			{
				sb.append(String.format("%7s", graph[j][i]));
			}
			
			sb.append(NEWLINE);
		}
		
		return sb.toString();
	}
		
	
}
