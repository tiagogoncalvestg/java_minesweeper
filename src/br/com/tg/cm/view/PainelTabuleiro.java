/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tg.cm.view;

import br.com.tg.cm.model.Tabuleiro;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tiago
 */
public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e -> {
            SwingUtilities.invokeLater(() -> {
                if (e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Ganhou!!! ;)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu!!! :(");
                }
                
                tabuleiro.reiniciar();

            });

        });

    }

}
