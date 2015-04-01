package br.com.andremartinsds;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Calc extends JFrame {

    JPanel paneltopo = null;
    JPanel painelCentro = null;
    JButton[] vetButon = new JButton[16];
    JTextField caracteres = null;
    String[] textoBotoes = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
    Acoes acoes = null;

    private void montandoBotoes() {
        for (int i = 0; i < this.vetButon.length; i++) {
            this.vetButon[i] = new JButton(textoBotoes[i]);
            this.painelCentro.add(vetButon[i]);
        }
    }


    public Calc() {
        super(" calculadora ");
        this.painelCentro = new JPanel(new GridLayout(4, 4));
        this.paneltopo = new JPanel();
        this.montandoBotoes();
        this.acoes = new Acoes(this);
        this.caracteres = new JTextField();
        this.caracteres.setHorizontalAlignment(JTextField.RIGHT);
        this.caracteres.setFont(new Font("Serif", Font.BOLD, 20));

        setLayout(new BorderLayout());
        setLocation(450, 300);
        add(painelCentro);
        add(BorderLayout.NORTH, caracteres);
        setSize(270, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calc();
    }

}
