package com.tca.graph;

public class GraphUtil 
{
	public static void addEdge(int g[][], int i, int j)
	{
		if(i != j)
        {
            g[i][j] = 1;
        }
		
		//g[j][i] = 1; --> undirected graph
	}
	
	public static void printGraph(int g[][])
	{
		int n = g.length;
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(g[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int getOutDegree(int g[][], int i)
	{
		int sum=0;
		for(int j=0; j<g.length; j++)
		{
			sum = sum + g[i][j];
		}
		return sum;
	}
	
	public static int getInDegree(int g[][], int j)
	{
		int sum=0;
		for(int i=0; i<g.length; i++)
		{
			sum = sum + g[i][j];
		}
		return sum;
	}
	
	public static void printDegree(int g[][])
	{
		int n = g.length;  // n=4
		
		for(int v=0; v < n; v++)  // Vertex : V0 Indegree = 2 Outdegree=1
		{
			int in = getInDegree(g, v);   // in=2
			int out= getOutDegree(g, v);  // out=1
			
			System.out.println("Vertex : V"+ v + " Indegree : " + in + " Outdegree: "+ out);
			
		}
	}
	
	public static int getVertexForZeroOutDegree(int g[][])
	{
		int n = g.length;
		
		for(int v=0; v < n; v++)
		{
			int out = getOutDegree(g, v);
			if(out == 0)
				return v;
		}
		
		return -1;
	}

}
