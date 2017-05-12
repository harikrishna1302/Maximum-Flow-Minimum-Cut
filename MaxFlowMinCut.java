import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.LinkedList;

class MaxFlowMinCut
{
	
	static final int V = 8; 
    static LinkedList<Integer> cut = new LinkedList<>();
	boolean bfs(int residualGraph[][], int s, int t, int parent[])
	{
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; ++i)
			visited[i]=false;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s]=-1;

		
		while (queue.size()!=0)
		{
			int u = queue.poll();

			for (int v=0; v<V; v++)
			{
				if (visited[v]==false && residualGraph[u][v] > 0)
				{
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		return (visited[t] == true);
	}

	int FordFulkerson(int graph[][], int s, int t)
	{
		int u, v;
		int residualGraph[][] = new int[V][V];

		for (u = 0; u < V; u++)
			for (v = 0; v < V; v++)
				residualGraph[u][v] = graph[u][v];
		int parent[] = new int[V];

		int max_flow = 0; 
		while (bfs(residualGraph, s, t, parent))
		{
			int path_flow = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
	        LinkedList<Integer> path = new LinkedList<>();
			path.add(t);
			int a= Integer.MAX_VALUE;
			int b= Integer.MAX_VALUE;
			int c= Integer.MAX_VALUE;
			for (v=t; v!=s; v=parent[v])
			{
				u = parent[v];
				path.add(u);
				if(residualGraph[u][v]<min){
			    min = residualGraph[u][v];
				a= u;
				b= v;
				c= residualGraph[u][v];
				}

				path_flow = Math.min(path_flow, residualGraph[u][v]);
			}
			
			cut.add(a);
			cut.add(b);
			cut.add(c);
			Iterator<Integer> itr = path.descendingIterator();
			System.out.println("The augment path of the Residual Graph is:");
			System.out.print(itr.next());
			while(itr.hasNext()){
			System.out.print("--->"+itr.next());
			}
			
			System.out.println();
			System.out.println("The augment flow of the above path is : "+path_flow);
			System.out.println();
			for (v=t; v != s; v=parent[v])
			{
				u = parent[v];
				residualGraph[u][v] -= path_flow;
				residualGraph[v][u] += path_flow;
			}
			max_flow += path_flow;
		}
		return max_flow;
	}

	public static void main (String[] args) throws FileNotFoundException
	{
		Scanner inputfile = new Scanner(new File("input.txt"));
		int[][] graph = new int[8][8];
		for(int i=0;i<8;i++){
		for(int j=0;j<8;j++){
		graph[i][j] = 0;
		}
		}

		for(int i=0;i<14;i++){
		int source = inputfile.nextInt();
		int destination = inputfile.nextInt();
		int length = inputfile.nextInt();
		graph[source][destination] = length;
		}

		MaxFlowMinCut m = new MaxFlowMinCut();
        System.out.println("MAXIMUM FLOW :");
		System.out.println();
		System.out.println("The Maximum possible Flow is " +
						m.FordFulkerson(graph, 0, 7));
        
        System.out.println();
		System.out.println("MINIMUM CUT");
		System.out.println("The Minimum Cut Edges are :");
		Iterator<Integer> itrcut = cut.iterator();
		int cutsum=0;
		while(itrcut.hasNext()){
		System.out.println(itrcut.next()+"-----"+itrcut.next());
		cutsum= cutsum + itrcut.next();
		}

		System.out.println("The Capacity of the Minimum Cut is :"+cutsum);

	}
}
