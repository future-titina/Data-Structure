package shu_ju_jie_gou;

public class grapic {

	static int INF = 9999;
	
	public static String gene(Integer v0,int dian,int bian,int[] array,int[] start,int[] end,int[] wight) {
		
		int i,j;
		G.vexnum = dian;
		G.arcnum = bian;
		for (i = 0; i < G.vexnum; i++)
			for (j = 0; j < G.vexnum; j++)
				G.arcs[i][j] = INF;
		
		for (i = 0; i < G.vexnum; i++)
		{
			G.vexs[i] = (char) array[i];
		}
		
		for (i = 0; i < G.arcnum; i++)
		{
			G.arcs[start[i]][end[i]] = wight[i];
		}
		
		return path.ShortestPath_DIJ(G.vexnum,G.arcs, v0, G.PathMatrix, G.ShortPathTable);
		
	}
	
}
