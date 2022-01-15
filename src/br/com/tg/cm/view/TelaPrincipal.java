/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tg.cm.view;

import br.com.tg.cm.model.Tabuleiro;
import javax.swing.JFrame;

/**
 *
 * @author Tiago
 */
public class TelaPrincipal extends JFrame{

    public TelaPrincipal(){
        Tabuleiro tabuleiro = new Tabuleiro(16, 30, 50);        
        add(new PainelTabuleiro(tabuleiro));
        
        setTitle("Campo Minado");
        setSize(690, 438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        
        new TelaPrincipal();
    }
}
