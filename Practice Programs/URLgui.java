//My first GUI ApplicationException
//import swing package
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.net.*;
public class URLgui implements ActionListener{
	JPanel p;
	JTextField jtb;
	JLabel jl1;
	public URLgui(){
		//create it
		JFrame f = new JFrame("My GUI Vanitas!");
		p = new JPanel();
		JLabel jl=new JLabel("Url:");
		jl1=new JLabel("Ip Address:");
		jtb=new JTextField();
		JButton jb = new JButton("Get IP Address");
		
		
		
		//configure it
		p.setBounds(0,0,300,300);
		//p.setBackground(Color.orange);
		p.setLayout(null);
		
		jl.setBounds(30,50,90,30);
		jtb.setBounds(50,50,90,30);
		jb.setBounds(40,100,90,30);
		jl1.setBounds(40,120,90,30);
		
		f.setVisible(true);
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setTitle("My First Window ^-^");
		
		
		
		//adding 
		f.add(p);
		p.add(jl);
		p.add(jtb);
		p.add(jl1);
		p.add(jb);
		jb.addActionListener(this);
	}
	public static void main(String...args){
		URLgui myWin = new URLgui();
	}
	
	//listen it
	public void actionPerformed(ActionEvent e){
		String s=jtb.getText();
		InetAddress id=null;
		try{
		id=InetAddress.getByName(s); 
		}
		catch (UnknownHostException ex) {
            			ex.printStackTrace();
       		 }		
		jl1.setText(id.getHostAddress());
		
		
	}
}