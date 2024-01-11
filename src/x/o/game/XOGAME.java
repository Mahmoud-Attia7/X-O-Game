package x.o.game;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class XOGAME extends JFrame implements ActionListener{

        boolean player_turn;
        JPanel P,title_panel,button_panel,score_panel,p1,p2;
        JLabel textfield, l1, l2,l3,l4;
        JButton[] buttons;
        JButton b1,b2,b3;

	XOGAME(){




                //creat the New Game button

                b1 = new JButton("New Game");
                b1.setBackground(Color.black);
                b1.setFont(new Font("Center Base Line", Font.CENTER_BASELINE,20));
                b1.setForeground(new Color(0,204,204));
                b1.setFocusable(false);
                b1.addActionListener(this);


                //creat the Reset button
                b2 = new JButton("Reset");
                b2.setBackground(Color.black);
                b2.setFont(new Font("Center Base Line", Font.CENTER_BASELINE,20));
                b2.setForeground(new Color(0,204,204));
                b2.setFocusable(false);
                b2.addActionListener(this);

                //creat the Exit button
                b3 = new JButton("Exit");
                b3.setBackground(Color.black);
                b3.setFont(new Font("Center Base Line", Font.ITALIC,20));
                b3.setForeground(Color.RED);
                b3.setFocusable(false);
                b3.addActionListener(this);

                //creat X-O buttons panel
                button_panel = new JPanel();
                button_panel.setLayout(new GridLayout(3,3));
                button_panel.setBackground(new Color(0,25,51));

                //creat the X-O buttons
                buttons = new JButton[9];
                for(int i=0; i<9; i++)
                    {
                        buttons[i] = new JButton();
                        buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
                        buttons[i].setFocusable(false);
                        buttons[i].setBackground(Color.white);
                        buttons[i].addActionListener(this);
                        buttons[i].setLayout(new BorderLayout());
                        button_panel.add(buttons[i]);
                    }




                //creat score player X label
                l1 = new JLabel();
                l1.setText("Player X score :");
                l1.setFont(new Font("TimesRoman", Font.ITALIC, 25));
                l1.setForeground(Color.white);


                //creat score player X label
                l2 = new JLabel("0");
                l2.setFont(new Font("TimesRoman", Font.ITALIC, 25));
                l2.setForeground(Color.white);

                //creat score player O label
                l3 = new JLabel();
                l3.setText("Player O score :");
                l3.setFont(new Font("TimesRoman", Font.ITALIC, 25));
                l3.setForeground(Color.white);



                //creat score player O label
                l4 = new JLabel("0");
                l4.setFont(new Font("TimesRoman", Font.ITALIC, 25));
                l4.setForeground(Color.white);





                //creat score panel to carry panel p1-p2
                score_panel = new JPanel();
                score_panel.setLayout(new GridLayout(2,1));
                score_panel.setBackground(new Color(0,25,51));


                //creat player x/o score panel
                p1 = new JPanel();
                p1.setLayout(new GridLayout(2,2));
                p1.setBackground(new Color(0,25,51));



                //creat New Game, Reset & Exit panel
                p2 = new JPanel();
                p2.setLayout(new GridLayout(1,3));
                p2.setBackground(new Color(0,25,51));


                //creat X-O label panel
                title_panel = new JPanel();
                title_panel.setBackground(new Color(0,25,51));




                //creat X-O label
                textfield = new JLabel();
                textfield.setText("X turn");
                textfield.setForeground(new Color(0,204,204));
                textfield.setFont(new Font("Ink Free",Font.CENTER_BASELINE,75));
                textfield.setHorizontalAlignment(JLabel.CENTER);



                //creat the father panel
                P = new JPanel();
                P.setLayout( new BorderLayout());



                //setup the frame
                this.setTitle("X-O GAME");
                this.setSize(700,700);
                this.setLocation(350, 0);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(true);


                //add components to the frame!
                title_panel.add(textfield);
                p1.add(l1);
                p1.add(l2);
                p1.add(l3);
                p1.add(l4);
                p2.add(b1);
                p2.add(b2);
                p2.add(b3);

                score_panel.add(p1);
                score_panel.add(p2);

                P.add(title_panel, BorderLayout.NORTH);
                P.add(button_panel, BorderLayout.CENTER);
                P.add(score_panel, BorderLayout.SOUTH);

                this.add(P);
                player_turn = true;
        }


	@Override
	public void actionPerformed(ActionEvent e) {


		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.red);
						buttons[i].setText("X");
						player_turn=false;
						textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.black);
						buttons[i].setText("O");
						player_turn=true;
						textfield.setText("X turn");
						check();
					}
				}
			}
		}
                if (e.getSource()==b1){
                    l2.setText("0");
                    l4.setText("0");
                    for(int i=0;i<9;i++) {

                        buttons[i].setText ("") ;
                    }
                    textfield.setText("X turn");
                }

                else if(e.getSource()==b2){
                    for(int i=0;i<9;i++) {

                           buttons[i].setText ("") ;
                        }
                }

                else if(e.getSource()==b3)
                    System.exit(0);

	}


	public void check() {
		//check X win conditions
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);

		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}


	}

	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		textfield.setText("X wins");

                int num ;
                num = Integer.parseInt(l2.getText());
                num++;
                l2.setText(Integer.toString(num));

                Object[] options = { "OK" };
                JOptionPane.showOptionDialog(null,"Congratulation"+" PLAYER X Wins","",
                JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

                for(int i=0;i<9;i++) {

                        buttons[i].setText ("") ;
                        }
                buttons[a].setBackground(Color.white);
		buttons[b].setBackground(Color.white);
		buttons[c].setBackground(Color.white);
                textfield.setText("X turn");
                player_turn = true;

	}
	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);

		textfield.setText("O wins");
                int num ;
                num = Integer.parseInt(l4.getText());
                num++;
                l4.setText(Integer.toString(num));


                Object[] options = { "OK" };
                JOptionPane.showOptionDialog(null,"Congratulation"+" PLAYER O Wins","",
                JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, options, options[0]);

                for(int i=0;i<9;i++) {

                           buttons[i].setText ("") ;
                        }
                buttons[a].setBackground(Color.white);
		buttons[b].setBackground(Color.white);
		buttons[c].setBackground(Color.white);
                textfield.setText("O turn");
                player_turn = false;
	}


}
