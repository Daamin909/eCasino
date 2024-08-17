import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Hub extends JFrame implements ActionListener{    
	public static JButton game1, game2, game3, game4, game5, game6;
	public static JPanel pane;
	public static JMenuBar menu;
	public static JMenu acc, redeem, helpMenu;
	public static JMenuItem abt, help, createAcc, login, vouchers, chkBal;
	public static JLabel namePlate;
	public static void formatting(){
		namePlate= new JLabel("💰💲 eCasino™ 💲💰");
		namePlate.setFont(new Font("Roboto", Font.BOLD, 70));
		namePlate.setHorizontalAlignment(SwingConstants.CENTER);
		namePlate.setVerticalAlignment(SwingConstants.CENTER);
		namePlate.setForeground(Color.LIGHT_GRAY);
		game1= new JButton("🔨Whack-a-Doll🔨");
		game2= new JButton("🤔 Juesser 🤔");
		game3= new JButton("🍾 BoutleHunt 🍾");
		game4= new JButton("❌ Tuk-Tik-Tak ❌");
		game5= new JButton("🕕 TimeHalter 🕕");
		game6= new JButton("💲💲 Slotty 💲💲");
		menu= new JMenuBar();
		pane=new JPanel();
		acc=new JMenu("Account");
		redeem= new JMenu("Redeem");
		helpMenu=new JMenu("Help");
		help=new JMenuItem("View Help");
		abt=new JMenuItem("About eCasino™");
		createAcc=new JMenuItem("Create an Account");
		login=new JMenuItem("Login");
		vouchers=new JMenuItem("Redeem Vouchers");
		chkBal=new JMenuItem("Check Balance");
		helpMenu.add(help);
		helpMenu.add(abt);
		acc.add(createAcc);
		acc.add(login);
		redeem.add(vouchers);
		redeem.add(chkBal);
		menu.add(acc);
		menu.add(redeem);
		menu.add(helpMenu);
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
		menu.setBounds(0, 0, 1368, 30); 
		menu.setBackground(Color.decode("#01820"));
		menu.setBorderPainted(false);
		menu.setForeground(Color.WHITE);
		menu.setOpaque(true);
		Font big = new Font("Roboto", Font.BOLD, 16);
		acc.setFont(big);
		redeem.setFont(big);
		helpMenu.setFont(big);
		abt.setFont(big);
		help.setFont(big);
		login.setFont(big);
		createAcc.setFont(big);
		vouchers.setFont(big);
		chkBal.setFont(big);
		acc.setForeground(Color.WHITE);
		redeem.setForeground(Color.WHITE);
		helpMenu.setForeground(Color.WHITE);
		help.setBackground(Color.BLACK);
		abt.setBackground(Color.BLACK);
		abt.setForeground(Color.WHITE);
		help.setForeground(Color.WHITE);
		abt.setOpaque(true);
		help.setOpaque(true);
		abt.setBorderPainted(false);
		help.setBorderPainted(false);
		chkBal.setBackground(Color.BLACK);
		vouchers.setBackground(Color.BLACK);
		vouchers.setForeground(Color.WHITE);
		chkBal.setForeground(Color.WHITE);
		chkBal.setOpaque(true);
		vouchers.setOpaque(true);
		vouchers.setBorderPainted(false);
		chkBal.setBorderPainted(false);
		login.setBackground(Color.BLACK);
		createAcc.setBackground(Color.BLACK);
		createAcc.setForeground(Color.WHITE);
		login.setForeground(Color.WHITE);
		createAcc.setOpaque(true);
		login.setOpaque(true);
		createAcc.setBorderPainted(false);
		login.setBorderPainted(false);
		namePlate.setBounds(183, 100, 1000, 100);
	}
	Hub(){
		super("eCasino™");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1350, 600);
		formatting();
		Image bg = Toolkit.getDefaultToolkit().getImage("D:\\Programming\\VS Code\\Java\\eCasino\\Resources\\Hub\\BG.png");  
		setIconImage(bg);
		game2.addActionListener(this);
		game3.addActionListener(this);
		game4.addActionListener(this);
		pane.add(menu);
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
		else if (source==game2){
			new Juesser();
		}
	}	
public static void main(String[] args){
	new Hub();	
}
}