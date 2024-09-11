import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class PeePooFart extends JFrame implements ActionListener{    
		public static JButton[] guess= new JButton[3];
		PeePooFart(){
            super("PeePooFart");
			setSize(670, 290);
			setLayout(new BorderLayout());
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent evt){ 
		}	
	public static void main(String[] args){
		new Juesser();	
	}
}