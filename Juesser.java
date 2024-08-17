import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class Juesser extends JFrame implements ActionListener{    
		public static JButton[] guess= new JButton[3];
		public static  JPanel[] pane= new JPanel[4];
		public static  JTextField[] numField= new JTextField[3];
		public static int[] num= new int[3];
		public static JTabbedPane modes;
		public static Random rand= new Random();
		public static String answer;
		public static JLabel namePlate;
		public static JTextArea text;
		public static int answerInt;
		public static Font customFont, customFontTab;
		public static JPanel contPanel;
		void generator(){
			num[0]=rand.nextInt(0, 101);
			num[1]=rand.nextInt(0, 501);
			num[2]=rand.nextInt(0, 1001);
		}
		void cleaner(){
			for (int j=0; j<=2;j++){
				numField[j].setText("");
			}
		}
        public void formatter(){
			for (int x=0; x<=2;x++){
				pane[x]= new JPanel();
				pane[x].setLayout(new BorderLayout());
				numField[x]= new JTextField (10); 
				guess[x]= new JButton("Guess");
				guess[x].addActionListener(this);
				guess[x].setBackground(Color.decode("#01820"));
				guess[x].setForeground(Color.decode("#FF5733"));
				numField[x].setBackground(Color.decode("#01820"));
				numField[x].setForeground(Color.WHITE);
				numField[x].setFont(customFont);
				guess[x].setFont(customFont);
				pane[x].setLayout(null);
				pane[x].add(numField[x]);
				pane[x].add(guess[x]);
				pane[x].setBackground(Color.BLACK);
				pane[x].setBorder(BorderFactory.createLineBorder(Color.decode("#01829"),10));
				guess[x].setFocusable(false);
				numField[x].setBounds(30, 42, 300, 50);
				guess[x].setBounds(400, 42, 200, 50 );	
			}
			namePlate= new JLabel("How to play...");
			namePlate.setForeground(Color.WHITE);
			text= new JTextArea("Guess the correct number and win. There are 3 modes in this game: Easy (1 to 100), Medium (1 to 500) and Hard (1 to 1000). Guess the number and win points accordingly. Easy gives 1 point, Medium gives 5 points and the hardest of 'em all gives 10 points. All the best!! Choose your gamemode from the above menu");
			text.setEditable(false);
			text.setBorder(null);
			text.setWrapStyleWord(true);
			text.setLineWrap(true);
			text.setForeground(Color.WHITE);
			text.setBackground(Color.BLACK);
			namePlate.setFont(customFontTab);
			text.setFont(new Font("Roboto", Font.ITALIC, 16));
			pane[3]= new JPanel();
			pane[3].setLayout(new GridLayout(2,1));
			pane[3].add(namePlate);
			pane[3].add(text);
			pane[3].setBackground(Color.BLACK);
			pane[3].setBorder(BorderFactory.createLineBorder(Color.decode("#01829"),10));	
			UIManager.put("TabbedPane.contentAreaColor", Color.BLACK);
       		UIManager.put("TabbedPane.tabAreaBackground", Color.BLACK);
        	UIManager.put("TabbedPane.border", BorderFactory.createEmptyBorder());
			UIManager.put("TabbedPane.selectedTabBackground", Color.BLACK);
			contPanel= new JPanel();
			contPanel.setLayout(new BorderLayout());
			contPanel.setBackground(Color.BLACK);
			modes= new JTabbedPane();
			modes.setBounds(0, 0,800,200);
			modes.addTab("How to play?", null,  pane[3], "How to play Jeusser");
			modes.addTab("Easy", null,  pane[0], "1 to 100");
			modes.addTab("Medium",null, pane[1], "1 to 500");
			modes.addTab("Hard",null, pane[2], "1 to 1000");
			modes.setFont(customFontTab);
			modes.setForeground(Color.decode("#FF5733"));
			modes.setBackground(Color.BLACK);
			modes.setFocusable(false);
			modes.setBorder(BorderFactory.createLineBorder(Color.decode("#01820"),10));
			contPanel.add(modes, BorderLayout.CENTER);
			add(contPanel);
		}
		Juesser(){
            super("Juesser");
			setSize(670, 250);
			setLayout(new BorderLayout());
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			generator();
			customFont= new Font("Roboto", Font.BOLD, 28);
			customFontTab = new Font("Roboto", Font.BOLD, 20);
			formatter();
			add(contPanel);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent evt){ 
			System.out.println(num[0]);			
			System.out.println(num[1]);			
			System.out.println(num[2]);
			int index=modes.getSelectedIndex();
			for (int y=1; y<=3; y++){
				if (index==y){
					answer=numField[y-1].getText();
					try{
						answerInt=Integer.parseInt(answer);
					}
					catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Enter a valid input!", "Error 304", JOptionPane.ERROR_MESSAGE);
						cleaner();
						return;
					}
					if (answerInt==num[y-1]){
						JOptionPane.showMessageDialog(null, "Congratulations, you have guessed the number!!", "Congrats!!", JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect guess, try again!!", "Try again!!", JOptionPane.INFORMATION_MESSAGE);
					}
					cleaner();
				}
			}
		}	
	public static void main(String[] args){
		new Juesser();	
		System.out.print(num[0]);
	}
}