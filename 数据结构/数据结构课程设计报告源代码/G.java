package shu_ju_jie_gou;

public class G {
	
	static int vexnum;
	static int arcnum;
	static int MAX = 20;
	static int INF = 9999;
	public static int[][] arcs = new int[MAX+1][MAX+1];
	public static char[] vexs = new char[MAX + 1];
	public static boolean[][] PathMatrix = new boolean[MAX + 1][MAX + 1];
	public static int[] ShortPathTable = new int[MAX + 1];
	
}
