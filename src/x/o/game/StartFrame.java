package x.o.game;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class StartFrame extends JFrame implements ActionListener {
    JFrame f;
    JButton b;
    JLabel l;
    JPanel p,p2;
    public StartFrame()
            {
            //creat  start frame
            f = new JFrame();
            f.setTitle("X-O");
            f.setSize(350, 450);
            f.setLocation(550, 150);
            // f.setLayout(new GridLayout(2,1));
            // f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            //creat Label
            l = new JLabel(" Provided by F U E students..." );
            //l.setBounds(100, 50, 75, 100);
            //l.setBackground(Color.black);
            l.setFont(new Font("Atia", Font.ITALIC, 25));
            l.setForeground(Color.red);


            //creat start button
            b = new JButton("Start");
            //b.setBounds(140,0,130,40);
            b.setBackground(Color.red);
            b.setFont(new Font("Center Base Line", Font.ITALIC,20));
            b.setForeground(Color.black);
            b.setBorder(BorderFactory.createBevelBorder(1));
            b.setFocusable(false);
            b.addActionListener(this);
            //b.setLayout(new BorderLayout());


            //creat panel1
            p = new JPanel();
            p.setBackground(Color.white);
            p.setLayout(new BorderLayout());

            //creat panel2
            p2 = new JPanel();
            p2.setBackground(Color.white);
            p2.setLayout(new BorderLayout());

            p.add(l, BorderLayout.NORTH);
            p.add(b,BorderLayout.SOUTH);

            f.add(p);
            f.setVisible(true);
          //  f.add(p2, BorderLayout.SOUTH);

            }

    @Override
    public void actionPerformed(ActionEvent e) {
       XOGAME c = new XOGAME();
    }
}
