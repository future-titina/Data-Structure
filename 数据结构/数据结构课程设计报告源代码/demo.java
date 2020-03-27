package shu_ju_jie_gou;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class demo {
	
	private static JButton b3;
	static int v0;
	static int tm = 0;
	public demo() throws Exception{
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		
		JFrame f = new JFrame("Dijkstra算法");
		f.setBounds(screenWidth - 500, screenHeight - 300, 1000, 600);
		f.setLayout(null);
		f.getContentPane().setBackground(Color.decode("#01a3a4"));
		
		JPanel pInput = new JPanel();
		pInput.setBackground(Color.decode("#c8d6e5"));
		pInput.setSize(450,600);
		pInput.setLocation(3, 3);
		pInput.setLayout(new FlowLayout());
		
		JLabel dian = new JLabel("点数:");
		JTextField dian_num = new JTextField(4);
		dian.setFont(new Font("楷体",Font.BOLD,30));
		dian_num.setFont(new Font("楷体",Font.BOLD,30));
		
		JLabel bian = new JLabel("边数:");
		JTextField bian_num = new JTextField(4);
		bian.setFont(new Font("楷体",Font.BOLD,30));
		bian_num.setFont(new Font("楷体",Font.BOLD,30));
		
		JLabel all = new JLabel("输入点(格式:1,2,3):");
		JTextField all_num = new JTextField(24);
		all.setFont(new Font("楷体",Font.BOLD,30));
		all_num.setFont(new Font("楷体",Font.BOLD,30));
		
		JLabel start = new JLabel("起点 终点 权值(格式: 1 2 2,1 3 4):");
		JTextField start_num = new JTextField(24);
		start.setFont(new Font("楷体",Font.BOLD,23));
		start_num.setFont(new Font("楷体",Font.BOLD,30));
		
		JLabel src = new JLabel("源点:");
		JTextField src_num = new JTextField(4);
		src.setFont(new Font("楷体",Font.BOLD,30));
		src_num.setFont(new Font("楷体",Font.BOLD,30));
		
		JButton b1 = new JButton("确定");
		b1.setFont(new Font("楷体",Font.BOLD,30));
        b1.setSize(100, 60);
		b1.setLocation(280, 300);
		b1.setBackground(Color.decode("#dfe6e9"));
		
		JButton b2 = new JButton("随机生成");
		b2.setFont(new Font("楷体",Font.BOLD,30));
        b2.setSize(200, 60);
		b2.setLocation(20, 300);
		b2.setBackground(Color.decode("#dfe6e9"));
		
		b3 = new JButton("过程演示");
		b3.setFont(new Font("楷体",Font.BOLD,30));
        b3.setSize(200, 60);
		b3.setLocation(20, 400);
		b3.setBackground(Color.decode("#dfe6e9"));
		
		JButton b4 = new JButton("返回");
		b4.setFont(new Font("楷体",Font.BOLD,30));
        b4.setSize(100, 60);
		b4.setLocation(280, 400);
		b4.setBackground(Color.decode("#dfe6e9"));
		
		
		pInput.add(dian);
		pInput.add(dian_num);
		pInput.add(bian);
		pInput.add(bian_num);
		pInput.add(all);
		pInput.add(all_num);
		pInput.add(start);
		pInput.add(start_num);
		pInput.add(src);
		pInput.add(src_num);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		//文本域
        JTextArea show = new JTextArea();
        show.setLocation(500, 90);
        show.setSize(450,600);
        show.setFont(new Font("楷体",Font.BOLD,30));
        show.setEditable(false);
        show.setLineWrap(true);
        show.setCaretPosition(show.getDocument().getLength());
        
        JScrollPane scroll = new JScrollPane(show); 
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setLocation(500, 20);
        scroll.setSize(450,500);
        
		f.add(pInput);
		f.add(scroll);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    
	    
		//鼠标监听
	   b1.addActionListener(new ActionListener() {

		   
		   String str = "";
		   @Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    	   
				   String str_show = "";
		    	   String s1 = bian_num.getText();
		    	   int bian = 0;
		    	   if(s1.length() != 0) {
		    		   bian = Integer.parseInt(s1);
		    	   }else {
		    		   str_show += "边数不能为空\n";
		    	   }
				
		    	   String s2 = dian_num.getText();
		    	   int dian = 0;
		    	   if(s2.length() != 0) {
		    		   dian = Integer.parseInt(s2);
		    	   }else {
		    		   str_show += "点数不能为空\n";
		    	   }
		    	   
		    	   String s3 = all_num.getText();
		    	   String[] string = s3.split(",");
		    	   int[] array	= new int[string.length];
		    	   for(int i=0;i<string.length;i++){
		    			array[i]= Integer.parseInt(string[i]);
		    		}
		    	   
		    	   String s4 = start_num.getText();
		    	   String[] string1 = s4.split(",");
		    	   int[] start1	= new int[string1.length];
		    	   int[] end = new int[string1.length];
		    	   int[] weight	= new int[string1.length];
		    	   for(int i=0;i<string1.length;i++){
		    		   String[] string2 = string1[i].split(" ");
		    		   start1[i]= Integer.parseInt(string2[0]);
		    		   end[i]= Integer.parseInt(string2[1]);
		    		   weight[i]= Integer.parseInt(string2[2]);
		    		}
		    	   
					String s = src_num.getText();
			    	v0 = 0;
			    	if(s.length() != 0) {
			    		v0 = Integer.parseInt(s);
			    	}else {
			    		str_show += "源点不能为空";
			    	}
			    	
			    	
			    	if(str_show.length() != 0) {
			    		JOptionPane.showMessageDialog(f, str_show);
			    	}
			    	
			      write.write_txt(dian,bian,start1,end,weight);
			    
//			      showtu.set_src_dian(v0 + 1);
			      
			      Gra.set_sstt(v0 + 1);
			      
		    	  str = grapic.gene(v0,dian, bian,array,start1,end,weight);
		    	  
		    	  show.setText(str);
		    	  
		    	  tm = 1;
		    	  
//	    	      show.replaceRange(str, 0, show.getDocument().getLength());
			   }
	   });
	   
	   b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int d = (1 + (int)(Math.random()*20));
			String d_num= "" + d;
			dian_num.setText(d_num);
			
			int b = (1 + (int)(Math.random()*d));
			String b_num= "" + b;
			bian_num.setText(b_num);
			
			String dnum = "";
			String bnum = "";
			for(int i = 0; i < d; i++)
				dnum += i + ",";
			all_num.setText(dnum);
			
			for(int i = 0; i < b; i++) {
				bnum += (int)(Math.random()*d) + " " + (int)(Math.random()*d) + " " + (int)(1 + Math.random()*20) + ",";
			}
			start_num.setText(bnum);
			
		}
	});
		
	   b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
        	Gra.set_sstt(v0 + 1);
        	try {
				Graph g1 = new Graph();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	   
	   b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	            f.dispose();
	            new home();
			}
		});
	}
	
//	public void actionPerformed(ActionEvent e) throws Exception {
//        if(e.getSource() == b3){
//        	Gra.set_sstt(v0 + 1);
//   		 	Graph g1 = new Graph();
//        }
//    }
public static void main(String[] args) throws Exception {
		
		new demo();
//		while(tm == 1) {
//			Thread.sleep(20000);
//			Gra.set_sstt(v0 + 1);
//			Graph g1 = new Graph();
//			g1.setVisible(true);
//			tm = 0;
//		}
		
//		Thread.sleep(20000);
//		Gra.set_sstt(v0 + 1);
//		Graph g1 = new Graph();
//		g1.setVisible(true);
	}
		
}
 
 