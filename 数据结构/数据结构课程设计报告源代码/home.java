package shu_ju_jie_gou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame implements ActionListener {
    //����������ť
    private JButton btn1,btn2;
    JLabel lb1,lb2;
    public home(){
        //���尴ť�����з�ʽ
        setLayout(null);

        Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
		Dimension screenSize = kit.getScreenSize(); // ��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width / 2; // ��ȡ��Ļ�Ŀ�
		int screenHeight = screenSize.height / 2; // ��ȡ��Ļ�ĸ�
		
		this.getContentPane().setBackground(Color.decode("#747d8c"));
		this.setTitle("Dijkstra�㷨");;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenWidth - 500, screenHeight - 300, 1000, 600);

        lb1 = new JLabel("���·��--Dijkstra�㷨");
        lb2 = new JLabel("Ф�� 201800301241");
        
        lb1.setLocation(100, 20);
        lb1.setSize(800, 200);
        lb1.setFont(new Font("����",Font.BOLD,60));
        lb1.setForeground(Color.decode("#dfe6e9"));
        
        lb2.setLocation(300, 120);
        lb2.setSize(800, 200);
        lb2.setFont(new Font("����",Font.BOLD,40));
        lb2.setForeground(Color.decode("#dfe6e9"));
        
        
        btn1 = new JButton("��ʼ");
        btn2 = new JButton("�˳�");
        btn1.setSize(100, 60);
        btn1.setLocation(350, 450);
        btn1.setFont(new Font("����",Font.BOLD,30));
        btn2.setSize(100, 60);
        btn2.setLocation(500, 450);
        btn2.setFont(new Font("����",Font.BOLD,30));
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
