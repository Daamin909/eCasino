import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class TukTikTak extends JFrame implements ActionListener{    
			public static JButton[] buttons= new JButton[9];
			public static JPanel pane;
			public static ImageIcon x, o, Lose, Win, Draw;
			public static int rand, turnChk, send; 
			public static int[] chk, antiDC;
			public static Random random = new Random();
			public static TukTikTak tt;
			public static boolean lose, win;
		//below are the methods
		public void RandResponse(){
			rand= random.nextInt(9);
			for (int sus=0; sus<=8; sus++){
				if (antiDC[rand]!=0){
					rand= random.nextInt(9);
				}
			}
			for (int w=0; w<=8; w++){
				if (rand==w){
					if (antiDC[w]<1){
						turnChk++;
						buttons[w].setIcon(o);
						antiDC[w]++;
						chk[w]=1;
						return;
					}
				}
			}
		}
		public void CompResponse(){
			WinOrLose();
			for (int j=0; j<9; j=j+3){
				if ((chk[j]==1)&&(chk[j+1]==1)&&(chk[j+2]==0)){
					buttons[j+2].setIcon(o);
					chk[j+2]=1;
					antiDC[j+2]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j]==1)&&(chk[j+2]==1)&&(chk[j+1]==0)){
					buttons[j+1].setIcon(o);
					chk[j+1]=1;
					antiDC[j+1]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j+1]==1)&&(chk[j+2]==1)&&(chk[j]==0)){
					buttons[j].setIcon(o);
					chk[j]=1;
					antiDC[j]++;
					turnChk++;
					WinOrLose();
					return;
				}
			}
			// horizontal rows ie 012, 345, 678
			for (int j=0; j<3; j++){
				if ((chk[j]==1)&&(chk[j+3]==1)&&(chk[j+6]==0)){
					buttons[j+6].setIcon(o);
					chk[j+6]=1;
					antiDC[j+6]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j]==1)&&(chk[j+6]==1)&&(chk[j+3]==0)){
					buttons[j+3].setIcon(o);
					chk[j+3]=1;
					antiDC[j+3]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j+3]==1)&&(chk[j+6]==1)&&(chk[j]==0)){
					buttons[j].setIcon(o);
					chk[j]=1;
					antiDC[j]++;
					turnChk++;
					WinOrLose();
					return;
				}
			}
			// vertical columns ie 036, 147, 258
			if ((chk[0]==1) && (chk[4]==1)&& chk[8]==0){
				buttons[8].setIcon(o);
				antiDC[8]++;
				turnChk++;
				chk[8]=1;
				WinOrLose();
				return;
			}
			else if ((chk[0]==1) && (chk[8]==1)&& chk[4]==0){
				buttons[4].setIcon(o);
				antiDC[4]++;
				turnChk++;
				chk[4]=1;
				WinOrLose();
				return;
			}
			else if ((chk[4]==1) && (chk[8]==1)&& chk[0]==0){
				buttons[0].setIcon(o);
				antiDC[0]++;
				turnChk++;
				chk[0]=1;
				WinOrLose();
				return;
			}
			// diagonal ie 048
			if ((chk[2]==1) && (chk[4]==1)&& chk[6]==0){
				buttons[6].setIcon(o);
				antiDC[6]++;
				turnChk++;
				chk[6]=1;
				WinOrLose();
				return;
			}
			else if ((chk[2]==1) && (chk[6]==1)&& chk[4]==0){
				buttons[4].setIcon(o);
				antiDC[4]++;
				turnChk++;
				chk[4]=1;
				WinOrLose();
				return;
			}
			else if ((chk[4]==1) && (chk[6]==1)&& chk[2]==0){
				buttons[2].setIcon(o);
				antiDC[2]++;
				turnChk++;
				chk[2]=1;
				WinOrLose();
				return;
			}
			// diagonal ie 246
			for (int j=0; j<9; j=j+3){
				if ((chk[j]==2)&&(chk[j+1]==2)&&(chk[j+2]==0)){
					buttons[j+2].setIcon(o);
					chk[j+2]=1;
					antiDC[j+2]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j]==2)&&(chk[j+2]==2)&&(chk[j+1]==0)){
					buttons[j+1].setIcon(o);
					chk[j+1]=1;
					antiDC[j+1]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j+1]==2)&&(chk[j+2]==2)&&(chk[j]==0)){
					buttons[j].setIcon(o);
					chk[j]=1;
					antiDC[j]++;
					turnChk++;
					WinOrLose();
					return;
				}
			}
			// horizontal rows ie 012, 345, 678
			for (int j=0; j<3; j++){
				if ((chk[j]==2)&&(chk[j+3]==2)&&(chk[j+6]==0)){
					buttons[j+6].setIcon(o);
					chk[j+6]=1;
					antiDC[j+6]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j]==2)&&(chk[j+6]==2)&&(chk[j+3]==0)){
					buttons[j+3].setIcon(o);
					chk[j+3]=1;
					antiDC[j+3]++;
					turnChk++;
					WinOrLose();
					return;
				}
				else if ((chk[j+3]==2)&&(chk[j+6]==2)&&(chk[j]==0)){
					buttons[j].setIcon(o);
					chk[j]=1;
					antiDC[j]++;
					turnChk++;
					WinOrLose();
					return;
				}
			}
			// vertical columns ie 036, 147, 258
			if ((chk[0]==2) && (chk[4]==2)&& chk[8]==0){
				buttons[8].setIcon(o);
				antiDC[8]++;
				turnChk++;
				chk[8]=1;
				WinOrLose();
				return;
			}
			else if ((chk[0]==2) && (chk[8]==2)&& chk[4]==0){
				buttons[4].setIcon(o);
				antiDC[4]++;
				turnChk++;
				chk[4]=1;
				WinOrLose();
				return;
			}
			else if ((chk[4]==2) && (chk[8]==2)&& chk[0]==0){
				buttons[0].setIcon(o);
				antiDC[0]++;
				turnChk++;
				chk[0]=1;
				WinOrLose();
				return;
			}
			// diagonal ie 048
			if ((chk[2]==2) && (chk[4]==2)&& chk[6]==0){
				buttons[6].setIcon(o);
				antiDC[6]++;
				turnChk++;
				WinOrLose();
				chk[6]=1;
				return;
			}
			else if ((chk[2]==2) && (chk[6]==2)&& chk[4]==0){
				buttons[4].setIcon(o);
				antiDC[4]++;
				turnChk++;
				chk[4]=1;
				WinOrLose();
				return;
			}
			else if ((chk[4]==2) && (chk[6]==2)&& chk[2]==0){
				buttons[2].setIcon(o);
				antiDC[2]++;
				turnChk++;
				chk[2]=1;
				WinOrLose();
				return;
			}
			// diagonal ie 246
			RandResponse();
		}
		public void WinOrLose(){
			int b=0;
			// the below is for X's checking
			for (b=0; b<9; b=b+3){
				if ((chk[b]==2)&&(chk[b+1]==2)&&(chk[b+2]==2)){
					win=true;
				}
			}
			if ((chk[0]==2)&&(chk[4]==2)&&(chk[8]==2)){
				win=true;				
			}
			else if ((chk[2]==2)&&(chk[4]==2)&&(chk[6]==2)){
				win=true;
			}
			for (b=0; b<3; b++){
				if ((chk[b]==2)&&(chk[b+3]==2)&&(chk[b+6]==2)){
					win=true;
				}
			}
			//the below is for O's checking
			for (b=0; b<9; b=b+3){
				if ((chk[b]==1)&&(chk[b+1]==1)&&(chk[b+2]==1)){
					lose=true;
				}
			}
			if ((chk[0]==1)&&(chk[4]==1)&&(chk[8]==1)){
				lose=true;				
			}
			else if ((chk[2]==1)&&(chk[4]==1)&&(chk[6]==1)){
				lose=true;
			}
			for (b=0; b<3; b++){
				if ((chk[b]==1)&&(chk[b+3]==1)&&(chk[b+6]==1)){
					lose=true;
				}
			}
			if (lose==true){
				JOptionPane.showMessageDialog(null, "Better luck next time☹☹☹", "O Wins!!!", JOptionPane.PLAIN_MESSAGE, Lose);
				this.dispose();
			}
			else if (win==true){
				JOptionPane.showMessageDialog(null, "Congratulations, you have won 10 tokens", "X Wins!!!", JOptionPane.PLAIN_MESSAGE, Win);
				this.dispose();
			}
			if ((chk[0]>0)&&(chk[1]>0)&&(chk[2]>0)&&(chk[3]>0)&&(chk[4]>0)&&(chk[5]>0)&&(chk[6]>0)&&(chk[7]>0)&&(chk[8]>0)){
				JOptionPane.showMessageDialog(null, "It's a DRAW", "DRAW", JOptionPane.PLAIN_MESSAGE, Draw);
				this.dispose();
				chk = new int[9];
			}
		}
		public void Sender(){
			antiDC[send]++;
			if (antiDC[send]==1){
				buttons[send].setIcon(x);
				chk[send]=2;
				turnChk++;
				WinOrLose();
				if (turnChk==1){
					RandResponse();
				}
				else if (turnChk>1){
					CompResponse();
				}
			}
		}
		TukTikTak(){
			super("Tuk-Tik-Tak");
			setSize(500, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			pane=new JPanel();
			chk = new int[9];
			antiDC=new int[9];
			Font customFont = new Font("Roboto", Font.BOLD, 40);
			Color bgColor = Color.decode("#01820");
			UIManager.put("OptionPane.messageFont", customFont);
			UIManager.put("OptionPane.buttonFont", customFont);
			UIManager.put("OptionPane.background", bgColor);
			UIManager.put("Panel.background", bgColor);
			UIManager.put("Button.background", bgColor);
			UIManager.put("OptionPane.messageForeground", Color.WHITE);
			UIManager.put("Button.foreground", Color.WHITE);
			Image icon = Toolkit.getDefaultToolkit().getImage("E:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\\\icon.png");  
			setIconImage(icon);
			o=new ImageIcon ("D:\\Programming\\VS Code\\Java\\eCasino\\Resources\\o.jpg");
			x=new ImageIcon ("D:\\Programming\\VS Code\\Java\\eCasino\\Resources\\X.jpg");
			Lose=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\blnt.jpg");
			Win=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\cong.jpg");
			Draw=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\draw.jpg");
			Image scaledImage = Lose.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Image scaledImage1 = Win.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Image scaledImage4 = Draw.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Lose = new ImageIcon(scaledImage);
			Win = new ImageIcon(scaledImage1);
			Draw = new ImageIcon(scaledImage4);
			pane.setLayout(new GridLayout(3, 3));
			for (int s=0; s<=8; s++){
				buttons[s]= new JButton();
				buttons[s].addActionListener(this);
				buttons[s].setBackground(Color.BLACK);
				buttons[s].setFocusPainted(false);
				pane.add(buttons[s]);
			}
			add(pane);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent evt){ 
			Object source=evt.getSource();
			for (int q=0; q<=8; q++){
				if (source==buttons[q]){
					send=q;
					Sender();
					WinOrLose();
					return;
				}	
			}
		}		
	public static void main(String[] args){
		tt= new TukTikTak();	
	}
}