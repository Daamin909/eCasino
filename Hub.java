import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Hub extends JFrame implements ActionListener{    
	public static JButton game1, game2, game3, game4, game5, game6;
	public static JPanel pane;
	public static JLabel namePlate;
	public void formatting(){
		namePlate= new JLabel("💰💲 eCasino™ 💲💰");
		namePlate.setFont(new Font("Roboto", Font.BOLD, 70));
		namePlate.setHorizontalAlignment(SwingConstants.CENTER);
		namePlate.setVerticalAlignment(SwingConstants.CENTER);
		namePlate.setForeground(Color.LIGHT_GRAY);
		game2= new JButton("🤔 Juesser 🤔");
		game3= new JButton("💩 Pee-Poo-Fart 💩");
		game4= new JButton("❌ Tuk-Tik-Tak ❌");
		pane=new JPanel();
		game2.setFont(new Font("Roboto", Font.BOLD, 25));
		game3.setFont(new Font("Roboto", Font.BOLD, 25));
		game4.setFont(new Font("Roboto", Font.BOLD, 25));
		game4.setBounds(86, 353, 260, 50); 
		game2.setBounds(520, 353, 320, 50); 
		game3.setBounds(979, 353, 315, 50); 
		game2.setBackground(Color.decode("#154360"));
		game2.setForeground(Color.decode("#FFDB58"));
		game2.setOpaque(true);
		game2.setBorderPainted(false);
		game3.setBackground(Color.decode("#01820"));
		game3.setForeground(Color.decode("#FEE715"));
		game3.setOpaque(true);
		game3.setBorderPainted(false);
		game4.setBackground(Color.decode("#990011"));
		game4.setForeground(Color.decode("#FCF6F5"));
		game4.setOpaque(true);
		game4.setBorderPainted(false);
		pane.setBackground(Color.BLACK);
		pane.setLayout(null);
		namePlate.setBounds(183, 100, 1000, 100);
	}
	Hub(){
		super("eCasino™");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1350, 600);
		formatting();
		Image bg = Toolkit.getDefaultToolkit().getImage("Resources\\BG.png");  
		setIconImage(bg);
		game2.addActionListener(this);
		game3.addActionListener(this);
		game4.addActionListener(this);
		pane.add(game2);
		pane.add(game3);
		pane.add(game4);
		pane.add(namePlate);
		add(pane);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent evt){ 
		Object source=evt.getSource();
		if (source==game4){
			new TukTikTak();
		}	
		else if (source==game2){
			new Juesser();
		}		
		else if (source==game3){
			new PeePooFart();
		}
	}	
public static void main(String[] args){
	new Hub();	
}
}