package shu_ju_jie_gou;

public class path {

	static String str = "";
	static int MAX = 20;
	static int INF = 0x3f3f3f3f;   
	public static String ShortestPath_DIJ(int vexnum,int[][] arcs, int v0, boolean[][] P, int[] D)
	{
		//求有向图v0到其他顶点的最短路径P，以及带权长度D
		//其中P是二维数组，行号为终点，列号表示经过的路径(P[W][v]为True表示从v0到
		//w要经过v，D是一维数组，表示从v0到某顶点的路径长((D[v] == 10表示
		//从v0到v要经过的路径长度为10） final存放已经求得的路径结果
		//(比如final[v]为TRUE表示已经找到v0到v的最短路径)

		boolean[] final1 = new boolean[MAX];
		int v, w, j;
		for (v = 0; v < vexnum; v++)
		{
			final1[v] = false;
			D[v] =arcs[v0][v];
			for (w = 0; w < vexnum; w++)
			{
				P[v][w] = false;//设空路径
			}
			if (D[v] < INF)
			{
				P[v][v0] = true;
				P[v][v] = true;
			}
		}
		D[v0] = 0;
		final1[v0] = true;//初始化，V0属于S集
		
		str += "初始状态:\n";
		for(int m = 0;m < vexnum;m++) {
			str += v0 +  "到" + m + ":路径长度为" + D[m] + "\n";
		}
		
		str += "*************************";
		
		//开始主循环，依次将其他n-1个顶点加入S集
		for (v = 1; v < vexnum; v++)
		{
			int min = INF;
			for (w = 0; w < vexnum; w++)
			{
				if (!final1[w] && D[w] < min)//w在V-S中，且离v0顶点更近
				{
					min = D[w];
					v = w;
				}
			}
			final1[v] = true;
			
			for (w = 0; w < vexnum; w++)//更新当前最短路径及距离
			{
				//修改D[w]及P[w] 其中w在V-S中
				
				int temp = D[w];
				
				if (!final1[w] && min +arcs[v][w] < D[w])
				{
					D[w] = min +arcs[v][w];
					for (j = 0; j < vexnum; j++)
						P[w][j] = P[v][j];
					P[w][w] = true;
					str += "经过点" + v + ":\n";
					str += v0 +  "到" + w + ":路径长度为" + D[w] + "\n";
				}
			}
//			str += "*************************";
		}
		str += "*************************";
		str += "最终结果:\n";
		
		for (int i = 0; i < vexnum; i++)
		{
			str += v0 +  "到" + i + "的最短路径要经过点:";
			for (int j1 = 0; j1 < vexnum; j1++)
			{
				if (P[i][j1]) {
					str += j1 + " ";
				}
			}
			str +=  ";路径长度为" + D[i] + "\n";
		}
		
//		for(int m = 0;m < vexnum;m++) {
//			str += v0 +  "到" + m + ":路径长度为" + D[m] + "\n";
//		}
		
		str += "\n-------------------------\n\n";
		
		return str;
	}
}
