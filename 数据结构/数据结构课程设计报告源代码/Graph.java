package shu_ju_jie_gou;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.lang.Thread;
import java.lang.Runnable;
public class Graph  extends JFrame
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int wait=0;	
	 JButton stop= new JButton("STOP");                                            //暂停按钮
	 JButton go= new JButton("GO");                                                //开始按钮
	 
	
	 public Graph ()throws Exception
	 { 
		 setSize(1380, 900);                                               		   //设定大小   
         this.setBackground(Color.WHITE);										   //背景色	
         this.setTitle("有向图最短路Dijkstra算法动态过程演示系统");
         this.setLayout(null);
          
         JLabel lblNewLabel = new JLabel("<html>最<br>短<br>路<br>算<br>法<br>动<br>态<br>过<br>程");     
 		 lblNewLabel.setFont(new Font("长城行楷体", Font.BOLD, 60));               //标签相关设置
 		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);                     //置顶
 		 lblNewLabel.setForeground(new Color(0, 0, 0));
 		 lblNewLabel. setBounds(20,0,90,800); 
 		 add(lblNewLabel); 
		 
		 Gra temp=new Gra();                                                      // 建图
		 temp.setSize(1290, 800);  
		 temp.setLocation(100,50);
		 temp.readin();
		 add(temp); 
		 this.setVisible(true); 
		 temp.play();                                                             //演示算法过程
	 }	
	 
	 public void close_jf() throws InterruptedException {
		 Thread.sleep(1000);
		this.dispose();
	}
	 public void close_bf() {
		
	}
}
 class Gra extends JPanel  
 {
	     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		int [] head;                   										 //链式前向星存图
	     int [][] edge;															
	     int  nume;
	     int  maxn; 															 //顶点数
	     int  maxm;														   		 //边数
	     int inf=0x3f3f3f3f;                                                     //无穷大
	     static int ss;                                                          //源汇点
		 static int tt;
	     int change;                                                             //开关量
	     int []mark;                                                             //最短路的标记 
	     int []dis;																 //距离	
	     int []got;                                                              //是否需要闪烁标记（正在被更新） 
	     points [] dian;                                                         //点类
	     int [][] lines;
	     int W = 980;
	     int H = 700;
	     double pai = Math.PI;
	     int θ = 1;
	 public Gra()                                                                //初始化构造函数
	 {
		 head=new int [1005];                 								  
		 edge=new int [5000][3];             
		 lines= new int [10000][5];            
		 dis=new int [1006];
		 got=new int [5000];
		 mark=new int [1006];
		 nume=0;
		 change=0;
		 for(int i=0;i<1000;i++)
		 {
		  head[i]=-1;dis[i]=inf;got[i]=mark[i]=0;
		 } 
	 }
 
     public void adde(int i,int j,int w)                                         //添加一条有向边      
	 {
		 edge[nume][0]=j;edge[nume][1]=head[i];head[i]=nume;
		 edge[nume++][2]=w;
	 }
	 void magic0()             													 //延时重画函数
	 {
		 try {
  			Thread.sleep(30);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
		 this.repaint();
	 }
	 
	 
     public static void set_sstt(int s) {
    	 ss = s;
     }
	 void magic()         														 //闪烁控制函数
	 {
		 int cur=5;                                                              //变换次数
		 while(cur!=0)
		 {
			 change=1;         													 //灯开
     		   magic0();
     		change=0; 	     												     //灯灭  
     		   magic0();
         	cur--;
        	//System.out.println(cur);
		 }
	 }
	 public void readin ()throws Exception                                       //读入图函数
	 {
		 java.io.File file= new java.io.File("./scores.txt");                      //读入数据
		// java.io.File file= new java.io.File("scores2.txt");                      //读入数据
		// java.io.File file= new java.io.File("radscores.txt"); 
	     Scanner input =new Scanner(file);	
	     	while(input.hasNext())
	     		{
	     			maxn=input.nextInt();
	     			maxm=input.nextInt();
	     			int from,to,w;
	                for(int i=0;i<maxm;i++)
	                {
	                	from=input.nextInt();
	                	to=input.nextInt();
	                	w=input.nextInt();
	                	adde(from,to,w);
	                }
	                //ss=input.nextInt(); tt=input.nextInt();
//	                ss = 1;
	                
	                dis[ss]=0;
	     		}
	     input.close(); 
	     //java.io.File file2 = new java.io.File("src\\points.txt");                  	//读入坐标点
	    // java.io.File file2 = new java.io.File("points2.txt");
	     //java.io.File file2= new java.io.File("radpoints.txt"); 
	     //Scanner input2 =new Scanner(file2);	
	     dian =new points [maxn+1];
	     for(int i=1;i<=maxn;i++)
	     {
	    	 dian[i] = new points(W/2*(1+Math.cos(2*pai/maxn*i+θ)), H/2*(1+Math.sin(2*pai/maxn*i+θ)));
	    	 //dian[i]=new points(input2.nextInt(),input2.nextInt());
	     }
	 }
	 public void play()                                                           //Dijkstra算法
	 {
         int marks=1;
         while(marks==1)
         {
        	 int mins=inf;
             marks=0;
             int cur=0; 	 
             for(int i=1;i<=maxn;i++)                                          
             {
            	 if(mark[i]==0&&dis[i]<mins)
            	 {
        		   mins=dis[i];
        		    cur=i;
        		    marks=1;
            	 }
             }
  		    got[cur]=1;              											 //点需要闪
  		    magic();                                                              
  		    got[cur]=0;               											 //关闭该点，之后就不再闪
            mark[cur]=1;	
            for(int j=head[cur];j!=-1;j=edge[j][1])
            {
            	int to=edge[j][0];
        	 if(mark[to]==0&&dis[to]>dis[cur]+edge[j][2])
        		 {
        		     dis[to]=dis[cur]+edge[j][2];
        		      lines[j][0]=1;         					 				  //该线已变色
        		      lines[j][1]=1;         				    				  //该线需要闪
        		      magic();
        		      lines[j][1]=0;        				   					  //无需再闪
        		 }
            }
         }
	 }
	 protected void paintComponent( Graphics g)                                   //画图函数
	 {
	       super.paintComponent(g);                                                //清屏    
	       g.setColor(Color.green);                              
	       Font font = new Font("Arial", Font.BOLD, 25);                           //字体大小
	       g.setFont(font);                    
	       for(int i=1;i<=maxn;i++)
	       {
	    	   if(got[i]==1) 														//该点在闪
	    	   {
	    		   if(change==1)                        							//灯开    
	    			   g.setColor(Color.red);
	    		   else  g.setColor(Color.GREEN);          				   			 //灯灭
	    	   }
	    	   else 
	    	   {
	    		   if(mark[i]==1)               									//该点已变
		    		    g.setColor(Color.red);
		    	   else g.setColor(Color.GREEN);
	    	   }
	    	   g.fillOval(dian[i].x, dian[i].y, 50, 50);
	    	   String ts;
	    	   if(dis[i]==inf)
	    		       ts="+∞";
	    	   else    ts=new String().valueOf(dis[i]);
	    	   g.drawString(ts + "--" + (i-1),dian[i].x,dian[i].y);
	       }
	       g.setColor(Color.GRAY);
	       for(int i=1;i<=maxn;i++)
	       {
	    	   for(int j=head[i];j!=-1;j=edge[j][1])
	    	   {
	    		   if(lines[j][1]==1)       							             	   //需要闪烁
	    		   {
	    			   if(change==1)
	    				   g.setColor(Color.BLUE);
	    			   else      g.setColor(Color.GRAY);
	    			 
	    		   }
	    		   else  
	    		   {
	    			   if(lines[j][0]==1)  													//已经变色
	    				   g.setColor(Color.BLUE);
	    			   else   g.setColor(Color.GRAY);
	    		   }
	    		  // g.drawString(new String().valueOf(dis[edge[j][2]]),dian[i].x,dian[i].y);
	    		   Graphics2D g2= (Graphics2D)g;
	    		   drawAL(dian[i].x+25,dian[i].y+25, dian[edge[j][0]].x+25, dian[edge[j][0]].y+25,g2);    //划边
	    	//	   g.drawLine(dian[i].x+25,dian[i].y+25, dian[edge[j][0]].x+25, dian[edge[j][0]].y+25);
	    		  int mx=(dian[i].x+25+dian[edge[j][0]].x+25)/2;
	    		  int my=(dian[i].y+25+dian[edge[j][0]].y+25)/2;
	    		  g.drawString(new String().valueOf(edge[j][2]), mx,my);
	    	   }
	       }     
	 }
	 public static void drawAL(int sx, int sy, int ex, int ey, Graphics2D g2)
		{
			double H = 20; 																			// 箭头高度
			double L = 6; 																			// 底边的一半
			int x3,y3,x4,y4;
			double awrad = Math.atan(L / H); 														// 箭头角度
			double arraow_len = Math.sqrt(L * L + H * H); 											// 箭头的长度
			double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
			double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
			double x_3 = ex - arrXY_1[0]; 															// (x3,y3)是第一端点
			double y_3 = ey - arrXY_1[1];
			double x_4 = ex - arrXY_2[0]; 															// (x4,y4)是第二端点
			double y_4 = ey - arrXY_2[1];
			Double X3 = new Double(x_3);
			x3 = X3.intValue();
			Double Y3 = new Double(y_3);
			y3 = Y3.intValue();
			Double X4 = new Double(x_4);
			x4 = X4.intValue();
			Double Y4 = new Double(y_4);
			y4 = Y4.intValue();                  												  
			g2.drawLine(sx, sy, ex, ey);                                                             // 画线    
			GeneralPath triangle = new GeneralPath();
			triangle.moveTo(ex, ey);
			triangle.lineTo(x3, y3);
			triangle.lineTo(x4, y4);
			triangle.closePath();
			g2.fill(triangle);																		//实心箭头
			//g2.draw(triangle);																	//非实心箭头
		}	 																		   
     public static double[] rotateVec(int px, int py, double ang,                // 计算箭头的左右俩的点
				boolean isChLen, double newLen)
      {
			double mathstr[] = new double[2];
			                                                      // 参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
			double vx = px * Math.cos(ang) - py * Math.sin(ang);
			double vy = px * Math.sin(ang) + py * Math.cos(ang);
			if (isChLen) {
				double d = Math.sqrt(vx * vx + vy * vy);
				vx = vx / d * newLen;
				vy = vy / d * newLen;
				mathstr[0] = vx;
				mathstr[1] = vy;
			}
			return mathstr;
		}
 }
class points 
{
	  int x,y;
	 points(){};
	points(double d,double e)
	{
		this.x=(int) d;
		this.y=(int) e;
	}
}
