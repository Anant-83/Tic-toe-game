package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class gamecontrol implements ActionListener {
    Random num = new Random();
    JPanel title = new JPanel();
    JPanel buton = new JPanel();
    JLabel tx = new JLabel();
    JFrame fm = new JFrame();
    boolean player1;
    JButton[] press = new JButton[9];
    gamecontrol()
    {
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.setSize(900,900);
        fm.setLayout(new BorderLayout());
        fm.getContentPane().setBackground(new Color(50,50,50));
        fm.setTitle("Game");
        fm.setVisible(true);

        tx.setBackground(Color.YELLOW);
        tx.setForeground(Color.black);
        tx.setFont(new Font("Ink free",Font.BOLD,80));
        tx.setHorizontalTextPosition(JLabel.CENTER);
        tx.setText("Welcome to Anant's Game");
        tx.setOpaque(true);

        title.setLayout(new BorderLayout());
        title.setBounds(0,0,800,200);
        title.add(tx);

        buton.setLayout(new GridLayout(3,3));
        buton.setBackground(Color.BLACK);
        for(int i=0; i<9; i++)
        {
            press[i] = new JButton();
            buton.add(press[i]);
            press[i].setFont(new Font("ok",Font.BOLD,100));
            press[i].addActionListener(this);
        }

        fm.add(title,BorderLayout.NORTH);
        fm.add(buton);

        first();
    }
    public void first()
    {
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException e){
            //e.printStackTrace();
        }
        if(num.nextInt(2) == 0)
        {
            player1 = true;
            tx.setText("X Turn");
        }
        else
        {
            player1 = false;
            tx.setText("0 Turn");
        }
    }
    public void check(){
        if(press[0].getText() == "X" && press[1].getText() == "X" && press[2].getText() == "X")
            xwin(0,1,2);
        if(press[3].getText() == "X" && press[4].getText() == "X" && press[5].getText() == "X")
            xwin(3,4,5);
        if(press[6].getText() == "X" && press[7].getText() == "X" && press[8].getText() == "X")
            xwin(6,7,8);
        if(press[0].getText() == "X" && press[4].getText() == "X" && press[8].getText() == "X")
            xwin(0,4,8);
        if(press[2].getText() == "X" && press[4].getText() == "X" && press[6].getText() == "X")
            xwin(2,4,6);
        if(press[0].getText() == "X" && press[3].getText() == "X" && press[6].getText() == "X")
            xwin(0,3,6);
        if(press[1].getText() == "X" && press[4].getText() == "X" && press[7].getText() == "X")
            xwin(1,4,7);
        if(press[2].getText() == "X" && press[5].getText() == "X" && press[8].getText() == "X")
            xwin(2,5,8);

        if(press[0].getText() == "0" && press[1].getText() == "0" && press[2].getText() == "0")
            owin(0,1,2);
        if(press[3].getText() == "0" && press[4].getText() == "0" && press[5].getText() == "0")
            owin(3,4,5);
        if(press[6].getText() == "0" && press[7].getText() == "0" && press[8].getText() == "0")
            owin(6,7,8);
        if(press[0].getText() == "0" && press[4].getText() == "0" && press[8].getText() == "0")
            owin(0,4,8);
        if(press[2].getText() == "0" && press[4].getText() == "0" && press[6].getText() == "0")
            owin(2,4,6);
        if(press[0].getText() == "0" && press[3].getText() == "0" && press[6].getText() == "0")
            owin(0,3,6);
        if(press[1].getText() == "0" && press[4].getText() == "0" && press[7].getText() == "0")
            owin(1,4,7);
        if(press[2].getText() == "0" && press[5].getText() == "0" && press[8].getText() == "0")
            owin(2,5,8);
    }
    public void xwin(int a,int b,int c)
    {
        press[a].setBackground(Color.GREEN);
        press[b].setBackground(Color.GREEN);
        press[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++)
        {
            press[i].setEnabled(false);
        }
        tx.setText("X WINS");
    }
    public void owin(int a,int b,int c)
    {
        press[a].setBackground(Color.GREEN);
        press[b].setBackground(Color.GREEN);
        press[c].setBackground(Color.GREEN);

        for(int i=0; i<9; i++)
        {
            press[i].setEnabled(false);
        }
        tx.setText("0 WINS");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean draw = false;
        for(int i=0; i<9; i++)
        {
            if(e.getSource() == press[i])
            {
                if(player1 == true)
                {
                    if(press[i].getText() == "")
                    {
                        press[i].setForeground(new Color(150,50,200));
                        press[i].setText("X");
                        player1 = false;
                        tx.setText("0 Turn");
                        check();
                    }
                }
                else
                {
                    if(press[i].getText() == "")
                    {
                        press[i].setForeground(new Color(0,0,255));
                        press[i].setText("0");
                        player1 = true;
                        tx.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
}
