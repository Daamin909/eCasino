import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class PeePooFart extends JFrame implements ActionListener{    
        public static JPanel pane;
        public static JButton pee, poo, fart, image;
        public static JLabel text;
        public static Font font;
        public static Random rand;
        public static Boolean drew=false, won=false, lost=false;
        public static ImageIcon Lose, Win, Draw;
        public static String compSource;
		PeePooFart(){
			super("PeePooFart");
			setSize(1100, 630);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            font= new Font("Roboto", Font.PLAIN, 28);
            text= new JLabel("Choose your Weapon!!");
            pane= new JPanel();
            Lose=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\blnt.jpg");
			Win=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\cong.jpg");
			Draw=new ImageIcon ("D:\\\\Programming\\\\VS Code\\\\Java\\\\eCasino\\\\Resources\\draw.jpg");
			Image scaledImage = Lose.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Image scaledImage1 = Win.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			Image scaledImage4 = Draw.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            UIManager.put("OptionPane.messageFont", font);
			UIManager.put("OptionPane.buttonFont", font);
			UIManager.put("OptionPane.background", Color.decode("#000000"));
			UIManager.put("OptionPane.messageForeground", Color.WHITE);
			UIManager.put("Panel.background", Color.decode("#000000"));
			UIManager.put("Button.background", Color.decode("#000000"));
            UIManager.put("Button.foreground", Color.decode("#ffffff"));
			Lose = new ImageIcon(scaledImage);
			Win = new ImageIcon(scaledImage1);
			Draw = new ImageIcon(scaledImage4);
            image= new JButton("PeePooFart");
            pane.setLayout(null);
            image.setLayout(null);
			pee = new JButton("🚽 PEE 🚽");
			poo = new JButton("💩 POO 💩");
			fart = new JButton("💨 FART 💨");
            pee.addActionListener(this);
            poo.addActionListener(this);
            fart.addActionListener(this);
            pane.add(image);
            pane.add(text);
			pane.add(pee);
			pane.add(poo);
			pane.add(fart);
            text.setFont(font);
            pee.setFont(font);
            poo.setFont(font);
            fart.setFont(font);  
            image.setBounds(350, 50, 400, 300);
            text.setBounds(400, 500, 500, 50);
            pee.setBounds(150, 430, 200, 50);
            poo.setBounds(450, 430, 200, 50);
            fart.setBounds(750, 430, 200, 50);
			add(pane);
			setVisible(true);
            Generate();
		}

		public void actionPerformed(ActionEvent evt){ 
            Object source = evt.getSource();
            if(source==pee){
                if (compSource=="pee"){
                    drew=true;
                }
                else if (compSource=="poo"){
                    won=true;
                }
                else if (compSource=="fart"){
                    lost=true;
                }
            }
            else if(source==poo){
                if (compSource=="pee"){
                    lost=true;
                }
                else if (compSource=="poo"){
                    drew=true;
                }
                else if (compSource=="fart"){
                    won=true;
                }
            }
            else if(source==fart){
                if (compSource=="pee"){
                    won=true;
                }
                else if (compSource=="poo"){
                    lost=true;
                }
                else if (compSource=="fart"){
                    drew=true;
                }
            }
            Result();
		}	
        public static void Generate(){
            rand = new Random();
            String[] buttons = {"pee", "poo", "fart"};
            compSource = buttons[rand.nextInt(0, 2)]; 
            for (int x=0; x<=3; x++){
                System.out.println(compSource);
            }
        }
        public void Result(){
            if (won){
                JOptionPane.showMessageDialog(null, "Congratulations, you have won 10 tokens", "You win!!!", JOptionPane.PLAIN_MESSAGE, Win);
                this.dispose();
            }
            else if (lost){
                JOptionPane.showMessageDialog(null, "Better luck next time☹☹☹", "Computer Wins!!!", JOptionPane.PLAIN_MESSAGE, Lose);
                this.dispose();
            }
            else if (drew){
                JOptionPane.showMessageDialog(null, "It's a DRAW", "DRAW", JOptionPane.PLAIN_MESSAGE, Draw);
                this.dispose();            
            }
        }
	public static void main(String[] args){
		new PeePooFart();	
	}
}