package shu_ju_jie_gou;

public class path {

	static String str = "";
	static int MAX = 20;
	static int INF = 0x3f3f3f3f;   
	public static String ShortestPath_DIJ(int vexnum,int[][] arcs, int v0, boolean[][] P, int[] D)
	{
		//������ͼv0��������������·��P���Լ���Ȩ����D
		//����P�Ƕ�ά���飬�к�Ϊ�յ㣬�кű�ʾ������·��(P[W][v]ΪTrue��ʾ��v0��
		//wҪ����v��D��һά���飬��ʾ��v0��ĳ�����·����((D[v] == 10��ʾ
		//��v0��vҪ������·������Ϊ10�� final����Ѿ���õ�·�����
		//(����final[v]ΪTRUE��ʾ�Ѿ��ҵ�v0��v�����·��)

		boolean[] final1 = new boolean[MAX];
		int v, w, j;
		for (v = 0; v < vexnum; v++)
		{
			final1[v] = false;
			D[v] =arcs[v0][v];
			for (w = 0; w < vexnum; w++)
			{
				P[v][w] = false;//���·��
			}
			if (D[v] < INF)
			{
				P[v][v0] = true;
				P[v][v] = true;
			}
		}
		D[v0] = 0;
		final1[v0] = true;//��ʼ����V0����S��
		
		str += "��ʼ״̬:\n";
		for(int m = 0;m < vexnum;m++) {
			str += v0 +  "��" + m + ":·������Ϊ" + D[m] + "\n";
		}
		
		str += "*************************";
		
		//��ʼ��ѭ�������ν�����n-1���������S��
		for (v = 1; v < vexnum; v++)
		{
			int min = INF;
			for (w = 0; w < vexnum; w++)
			{
				if (!final1[w] && D[w] < min)//w��V-S�У�����v0�������
				{
					min = D[w];
					v = w;
				}
			}
			final1[v] = true;
			
			for (w = 0; w < vexnum; w++)//���µ�ǰ���·��������
			{
				//�޸�D[w]��P[w] ����w��V-S��
				
				int temp = D[w];
				
				if (!final1[w] && min +arcs[v][w] < D[w])
				{
					D[w] = min +arcs[v][w];
					for (j = 0; j < vexnum; j++)
						P[w][j] = P[v][j];
					P[w][w] = true;
					str += "������" + v + ":\n";
					str += v0 +  "��" + w + ":·������Ϊ" + D[w] + "\n";
				}
			}
//			str += "*************************";
		}
		str += "*************************";
		str += "���ս��:\n";
		
		for (int i = 0; i < vexnum; i++)
		{
			str += v0 +  "��" + i + "�����·��Ҫ������:";
			for (int j1 = 0; j1 < vexnum; j1++)
			{
				if (P[i][j1]) {
					str += j1 + " ";
				}
			}
			str +=  ";·������Ϊ" + D[i] + "\n";
		}
		
//		for(int m = 0;m < vexnum;m++) {
//			str += v0 +  "��" + m + ":·������Ϊ" + D[m] + "\n";
//		}
		
		str += "\n-------------------------\n\n";
		
		return str;
	}
}
