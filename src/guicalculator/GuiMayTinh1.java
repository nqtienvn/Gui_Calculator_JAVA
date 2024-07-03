/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guicalculator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Nguyenquangtien
 */
public class GuiMayTinh1 extends JFrame {

    private JButton[] btn;
    private JPanel pn1, pn2;
    private JTextField txt1;
    private JButton btnc;

    public GuiMayTinh1(String title) {
        this.setTitle(title);
        btn = new JButton[16];
        for (int i = 0; i <= 9; i++) {
            btn[i] = new JButton(String.valueOf(i));
        }
        btn[10] = new JButton("+");
        btn[11] = new JButton("-");
        btn[12] = new JButton("*");
        btn[13] = new JButton("/");
        btn[14] = new JButton("=");
        btn[15] = new JButton("Clear");

        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(4, 4, 10, 10));
        pn1.setBounds(0, 200, 500, 300);
        for (int i = 0; i < 16; i++) {
            pn1.add(btn[i]);
        }
        this.add(pn1);
        pn1.setBackground(Color.black);

        pn2 = new JPanel();
        pn2.setBounds(0, 0, 500, 200);
        pn2.setBackground(Color.gray);
        pn2.setLayout(null);

        txt1 = new JTextField("");
        txt1.setBounds(50, 70, 400, 70);
        pn2.add(txt1);
        this.add(pn2);

        /////////////su ly logic
        for (int i = 0; i < 10; i++) {
            int index = i;
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txt1.setText(txt1.getText() + btn[index].getText());
                }
            });
        }

        for (int i = 10; i < 14; i++) {
            int index = i;
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txt1.setText(txt1.getText() + " " + btn[index].getText() + " ");
                }
            });
        }

        btn[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] a = txt1.getText().split(" ");
                    if (a.length == 3) {
                        int so1 = Integer.parseInt(a[0]);
                        String dau = a[1];
                        int so2 = Integer.parseInt(a[2]);
                        int result = 0;

                        switch (dau) {
                            case "+":
                                result = so1 + so2;
                                break;
                            case "-":
                                result = so1 - so2;
                                break;
                            case "*":
                                result = so1 * so2;
                                break;
                            case "/":
                                result = so1 / so2;
                                break;
                        }
                        txt1.setText(String.valueOf(result));
                    }
                } catch (Exception ex) {
                    txt1.setText("Sai");
                }
            }
        });

        btn[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText("");
            }
        });

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiMayTinh1("Calculator Integer Number");
    }
}
