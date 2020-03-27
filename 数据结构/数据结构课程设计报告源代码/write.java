package shu_ju_jie_gou;

import java.io.*;
public class write {
	
	public static void write_txt(){
		String s1 = new String();
		try {
			File f = new File("./scores.txt");
			if(f.exists()){
				f.delete();
				f.createNewFile();
			}else{
			    f.createNewFile();//不存在则创建
			}
			s1 += "添加的内容!";
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
				output.write(s1);
				output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write_txt(int dian, int bian, int[] start1, int[] end, int[] weight) {
		// TODO Auto-generated method stub
		String s1 = "",s2 = "";
		try {
			File f = new File("./scores.txt");
			if(f.exists()){
				f.delete();
				f.createNewFile();
			}else{
			    f.createNewFile();//不存在则创建
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			    s1 += dian + " " + bian + "\n";
				output.write(s1);
				
				for(int i = 0;i < bian; i++) {
					s2 += (start1[i] + 1 ) + " " +( end[i] + 1) + " " + weight[i]  + "\n";
				}
				output.write(s2);
				
				output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
