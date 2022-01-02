//My first GUI ApplicationException
//import swing package
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class MyFirstGUI implements ActionListener{
	JPanel p;
	public MyFirstGUI(){
		//create it
		JFrame f = new JFrame("My GUI Vanitas!");
		p = new JPanel();
		
		JButton jb = new JButton("Click Me");
		
		
		
		//configure it
		p.setBounds(0,0,300,300);
		p.setBackground(Color.orange);
		p.setLayout(null);
		
		jb.setBounds(50,50,90,30);
		
		f.setVisible(true);
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setTitle("My First Window ^-^");
		
		
		
		//adding 
		f.add(p);
		p.add(jb);
		jb.addActionListener(this);
	}
	public static void main(String...args){
		MyFirstGUI myWin = new MyFirstGUI();
	}
	
	//listen it
	public void actionPerformed(ActionEvent e){
		int r = (int)(Math.random()*(256));
		int g = (int)(Math.random()*(256));
		int b = (int)(Math.random()*(256));
		Color c = new Color(r,g,b);
		p.setBackground(c);
	}
}