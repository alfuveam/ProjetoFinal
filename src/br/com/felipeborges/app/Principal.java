/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.app;

import br.com.felipeborges.view.TelaCadastroFuncionario;
import br.com.felipeborges.view.TelaLogin;

/**
 *
 * @author guest01
 */
public class Principal {

    public static void main(String[] args) {

        new TelaLogin().setVisible(true);
        //new TelaCadastroFuncionario(null);
    }
}