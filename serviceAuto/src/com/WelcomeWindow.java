package com;

import com.sun.tools.javac.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.border.Border;
import javax.swing.border.LineBorder;
//Welcome window class
public class WelcomeWindow extends JFrame implements ActionListener
{

    private JButton enterButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private Font customFont1 = new Font("Courier", Font.BOLD    , 55);
    private Font customFont2 = new Font("Sans Serif", Font.BOLD, 75);
    private JLabel header1 = new JLabel("Auto Service");
    private JLabel header2 = new JLabel("Management System");
    public WelcomeWindow()
    {

        setSize(1366, 728);
        setResizable(false);
        setContentPane(new JLabel(new ImageIcon("images/AutoBackground.jpg")));
        setLayout(null);

        header1.setSize(600, 250);
        header1.setLocation(400, 50);
        header1.setForeground(Color.white);
        header1.setFont(customFont2);

        header2.setSize(800, 250);
        header2.setLocation(280, 150);
        header2.setForeground(Color.white);
        header2.setFont(customFont2);

        enterButton.setSize(230, 75);
        enterButton.setLocation(210, 550);
        enterButton.setFont(customFont1);
        enterButton.setBackground(Color.darkGray);
        enterButton.setForeground(Color.lightGray);
        enterButton.addActionListener(this);




        exitButton.setSize(230, 75);
        exitButton.setLocation(890, 550);
        exitButton.setFont(customFont1);
        exitButton.setBackground(Color.darkGray);
        exitButton.setForeground(Color.lightGray);
        exitButton.addActionListener(this);

        add(header1);
        add(header2);
        add(enterButton);
        add(exitButton);

        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Start"))
        {
            MainMenuWindow mainMenu = new MainMenuWindow();
            this.setVisible(false);
            mainMenu.setVisible(true);
        }
    }
}
