package shu_ju_jie_gou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame implements ActionListener {
    //定义两个按钮
    private JButton btn1,btn2;
    JLabel lb1,lb2;
    public home(){
        //定义按钮的排列方式
        setLayout(null);

        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		
		this.getContentPane().setBackground(Color.decode("#747d8c"));
		this.setTitle("Dijkstra算法");;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenWidth - 500, screenHeight - 300, 1000, 600);

        lb1 = new JLabel("最短路径--Dijkstra算法");
        lb2 = new JLabel("肖雨 201800301241");
        
        lb1.setLocation(100, 20);
        lb1.setSize(800, 200);
        lb1.setFont(new Font("宋体",Font.BOLD,60));
        lb1.setForeground(Color.decode("#dfe6e9"));
        
        lb2.setLocation(300, 120);
        lb2.setSize(800, 200);
        lb2.setFont(new Font("宋体",Font.BOLD,40));
        lb2.setForeground(Color.decode("#dfe6e9"));
        
        
        btn1 = new JButton("开始");
        btn2 = new JButton("退出");
        btn1.setSize(100, 60);
        btn1.setLocation(350, 450);
        btn1.setFont(new Font("宋体",Font.BOLD,30));
        btn2.setSize(100, 60);
        btn2.setLocation(500, 450);
        btn2.setFont(new Font("宋体",Font.BOLD,30));
        btn1.setBackground(Color.decode("#dfe6e9"));
        btn2.setBackground(Color.decode("#dfe6e9"));
        
        this.add(lb1);
        this.add(lb2);
        this.add(btn1);
        this.add(btn2);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new home();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){
            this.dispose();
			try {
				demo.main(null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        if(e.getSource() == btn2){
            this.dispose();
            System.exit(0);
        }
    }
}
