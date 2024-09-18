import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.*;
import javax.swing.border.*;
class PeePooFart extends JFrame implements ActionListener{    
        public static JPanel pane;
        public static JButton pee, poo, fart, help;
        public static ImageIcon peeIcon, poopIcon, fartIcon, shuffle;
        public static JLabel image, imageUser, vs;
        public static Font font;
        public static Random rand;
        public static Boolean drew=false, won=false, lost=false;
        public static ImageIcon Lose, Win, Draw;
        public static String compSource;
        public static int doneOnce;
		PeePooFart(){
			super("PeePooFart");
			setSize(1100, 630);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            font= new Font("Roboto", Font.PLAIN, 28);
            pane= new JPanel();
            Lose=new ImageIcon ("Resources\\blnt.jpg");
			Win=new ImageIcon ("Resources\\cong.jpg");
			Draw=new ImageIcon ("Resources\\draw.jpg");
            shuffle = new ImageIcon("Resources\\Shuffle.gif");
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
            help = new JButton("?");
            help.setFont(font);
            help.setFocusable(false);
            help.setBorderPainted(false);
            peeIcon = new ImageIcon("Resources\\pee.png");
            poopIcon = new ImageIcon("Resources\\poop.png");
            fartIcon = new ImageIcon("Resources\\fart.png");
            image= new JLabel("", JLabel.CENTER);
            image.setBorder(new LineBorder(Color.YELLOW, 1));
            image.setFont(font);
            image.setForeground(Color.WHITE);
            vs= new JLabel("VS", JLabel.CENTER);
            vs.setFont(font);
            vs.setForeground(Color.WHITE);
            imageUser= new JLabel("", JLabel.CENTER);
            imageUser.setBorder(new LineBorder(Color.YELLOW, 1));
            imageUser.setFont(font);
            imageUser.setForeground(Color.WHITE);
            pane.setLayout(null);
			pee = new JButton("🚽 PEE 🚽");
			poo = new JButton("💩 POO 💩");
			fart = new JButton("💨 FART 💨");
            pee.addActionListener(this);
            poo.addActionListener(this);
            fart.addActionListener(this);
            pee.setFocusable(false);
            poo.setFocusable(false);
            fart.setFocusable(false);
            pane.setBackground(Color.decode("#000000"));
            pee.setBorder(new LineBorder(Color.YELLOW, 1));
            poo.setBorder(new LineBorder(Color.YELLOW, 1));
            fart.setBorder(new LineBorder(Color.YELLOW, 1));
            pee.setFont(font);
            poo.setFont(font);
            fart.setFont(font); 
            help.setToolTipText("HELP");
            image.setBounds(600, 50, 400, 400);
            help.setBounds(1030, 15, 50, 30);
            imageUser.setBounds(100, 50, 400, 400);
            vs.setBounds(500, 220, 100, 100);
            pee.setBounds(150, 490, 200, 50);
            poo.setBounds(450, 490, 200, 50);
            fart.setBounds(750, 490, 200, 50);
            pane.add(image);
			pane.add(pee);
			pane.add(poo);
			pane.add(fart);
            pane.add(imageUser);
            pane.add(help);
            pane.add(vs);
			add(pane);
            help.addActionListener(this);
			setVisible(true);
            Generate();
		}
        public void animation(){
            image.setText("");
            image.setIcon(shuffle);
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            Runnable task = new Runnable() {
                public void run() {
                    if (compSource.equals("pee")) {
                        image.setIcon(peeIcon);
                    } 
                    else if (compSource.equals("poo")) {
                        image.setIcon(poopIcon);
                    }   
                    else if (compSource.equals("fart")) {
                        image.setIcon(fartIcon);
                    }
                }
            };
            Runnable resultify = new Runnable() {
                public void run() {
                    Result();
                }
            };
            scheduler.schedule(task, 3, TimeUnit.SECONDS);
            scheduler.schedule(resultify,3300, TimeUnit.MILLISECONDS);
            scheduler.shutdown();
        }
		public void actionPerformed(ActionEvent evt){ 
            Object source = evt.getSource();
            if(source!=help){
                doneOnce++;
            }
            if (doneOnce>1){
                return;
            }
            if(source==pee){
                imageUser.setIcon(peeIcon);
                if (compSource=="pee"){
                    drew=true;
                }
                else if (compSource=="poo"){
                    won=true;
                }
                else if (compSource=="fart"){
                    lost=true;
                }
                animation();
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
                imageUser.setIcon(poopIcon);
                animation();
            }
            else if(source==fart){
                imageUser.setIcon(fartIcon);
                if (compSource=="pee"){
                    won=true;
                }
                else if (compSource=="poo"){
                    lost=true;
                }
                else if (compSource=="fart"){
                    drew=true;
                }
                animation();
            }
            else if (source==help){
                JTextArea textArea = new JTextArea(10, 50);
                textArea.setText("PeePooFart is a simple game where you have to choose between Pee, Poo and Fart. The computer will also choose one of the three. The rules are simple: \n\n1. Pee beats Poo\n2. Poo beats Fart\n3. Fart beats Pee\n\nThe game is a draw if both you and the computer choose the same option. \n\nGood Luck!");
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setCaretPosition(0);
                textArea.setEditable(false);
                textArea.setFont(font);
                textArea.setBackground(Color.BLACK);
                textArea.setForeground(Color.WHITE);
                JOptionPane.showMessageDialog(null, textArea, "Help", JOptionPane.PLAIN_MESSAGE);
            }
		}	
        public static void Generate(){
            rand = new Random();
            String[] buttons = {"pee", "poo", "fart"};
            compSource = buttons[rand.nextInt(0, 2)]; 
        }
        public void Result(){
            if (won){
                JOptionPane.showMessageDialog(null, "YOU WON!!!", "You win!!!", JOptionPane.PLAIN_MESSAGE, Win);
                this.dispose();
            }
            else if (lost){
                JOptionPane.showMessageDialog(null, "THE COMPUTER WON!!!", "Computer Wins!!!", JOptionPane.PLAIN_MESSAGE, Lose);
                this.dispose();
            }
            else if (drew){
                JOptionPane.showMessageDialog(null, "ITS A DRAW!!!", "DRAW", JOptionPane.PLAIN_MESSAGE, Draw);
                this.dispose();            
            }
        }
	public static void main(String[] args){
		new PeePooFart();	
	}
}