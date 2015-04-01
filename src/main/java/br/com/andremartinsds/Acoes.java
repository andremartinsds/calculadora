package br.com.andremartinsds;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acoes implements ActionListener {
    Double valor;
    Double resultado;
    String operacao, con;
    boolean clik = false, segundoNumero = false;
    Calc calc = null;

    public Acoes(Calc calc) {
        this.calc = calc;
        this.addListeners();
    }

    private void addListeners() {
        for (int i = 0; i < calc.vetButon.length; i++) {
            calc.vetButon[i].addActionListener(this);
        }
    }

    private void adicionaNumeraisInputados(JButton jbutton) {
        switch (jbutton.getText()) {
            case "0":
                addCaracter("0");
                break;
            case "1":
                addCaracter("1");
                break;
            case "2":
                addCaracter("2");
                break;
            case "3":
                addCaracter("3");
                break;
            case "4":
                addCaracter("4");
                break;
            case "5":
                addCaracter("5");
                break;
            case "6":
                addCaracter("6");
                break;
            case "7":
                addCaracter("7");
                break;
            case "8":
                addCaracter("8");
                break;
            case "9":
                addCaracter("9");
                break;
        }
    }

    private void adicionarOperacoes(JButton button) {
        if ((button).getText().equals("+")) {
            if (segundoNumero) this.result();
            this.atribuirOperacaoEValor("adicao");
            segundoNumero = true;
        }
        if ((button).getText().equals("-")) {
            if (segundoNumero) this.result();
            this.atribuirOperacaoEValor("subtracao");
            segundoNumero = true;
        }
        if ((button).getText().equals("*")) {
            if (segundoNumero) this.result();
            this.atribuirOperacaoEValor("multiplicacao");
            segundoNumero = true;
        }
        if ((button).getText().equals("/")) {
            if (segundoNumero) this.result();
            this.atribuirOperacaoEValor("divisao");
            segundoNumero = true;
        }
        if ((button).getText().equals("=")) this.result();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < calc.vetButon.length; i++) {
            if (event.getSource() == calc.vetButon[i]) {
                if (calc.vetButon[i].getText().equals(".")) {
                    this.calc.caracteres.setText(calc.caracteres.getText() + ".");
                    this.clik = false;
                }
                this.adicionaNumeraisInputados(calc.vetButon[i]);
                this.adicionarOperacoes((JButton) event.getSource());
            }
        }
    }

    public void atribuirOperacaoEValor(String operacao) {
        this.clik = true;
        this.valor = Double.parseDouble(calc.caracteres.getText());
        this.operacao = operacao;
    }

    public void addCaracter(String cont) {
        if (this.clik) {
            calc.caracteres.setText(cont);
        } else {
            calc.caracteres.setText(calc.caracteres.getText() + cont);
        }
        clik = false;
    }

    public void result() {
        if (operacao.equals("adicao")) {
            resultado = this.valor + Double.parseDouble(calc.caracteres.getText());
            calc.caracteres.setText(String.valueOf(resultado));
        }
        if (operacao.equals("subtracao")) {
            resultado = this.valor - Double.parseDouble(calc.caracteres.getText());
            calc.caracteres.setText(String.valueOf(resultado));
        }
        if (operacao.equals("multiplicacao")) {
            resultado = this.valor * Double.parseDouble(calc.caracteres.getText());
            calc.caracteres.setText(String.valueOf(resultado));
        }
        if (operacao.equals("divisao")) {
            resultado = this.valor / Double.parseDouble(calc.caracteres.getText());
            calc.caracteres.setText(String.valueOf(resultado));
        }
        clik = true;
        segundoNumero = false;
    }
}