package com.tca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tca.graph.GraphUtil;

public class App {

	public static void main(String[] args) 
	{
		
		GraphUtil ob = new GraphUtil();
		System.out.println(ob.hashCode());
		
//		Map<Integer,List<Integer>> map = new HashMap<>();
//	        
//		int edges[][] = {{0,1},{0,2},{3,5},{5,4},{4,3}};
//
//        //addEdge(g,edges[i][0],edges[i][1]);
//		for(int i=0; i<edges.length; i++)
//        {
//            // Adding edges in graph
//            List<Integer> L1 = map.getOrDefault(edges[i][0],new ArrayList<>());
//            L1.add(edges[i][1]);
//            map.put(edges[i][0],L1);
//
//            List<Integer> L2 = map.getOrDefault(edges[i][1],new ArrayList<>());
//            L2.add(edges[i][0]);
//            map.put(edges[i][1],L2);
//        }
//        
//        System.out.println(map);
	}

}
