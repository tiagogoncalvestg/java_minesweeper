/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tg.cm.view;

import br.com.tg.cm.model.Campo;
import br.com.tg.cm.model.CampoEvento;
import br.com.tg.cm.model.CampoObservador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Tiago
 */
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
    
    private final Color BG_PADRAO = new Color(184,184,184); 
    private final Color BG_MARCAR = new Color(8,179,247); 
    private final Color BG_EXPLODIR = new Color(189,66,68); 
    private final Color TEXTO_VERDE = new Color(0,100,0); 

    private Campo campo;
    
    public BotaoCampo(Campo campo) {
        this.campo = campo;
        setOpaque(true);
        setFocusable(false);
        setBorder(BorderFactory.createBevelBorder(0));
        setBackground(BG_PADRAO);
        
        addMouseListener(this);
        campo.registrarObservador(this);

    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir();
                break;
            case MARCAR:
                aplicarEstiloMarcar();
                break;
            case EXPLODIR:
                aplicarEstiloExplodir();
                break;
            default:
                aplicarEstiloPadrao();
        }
    }

    private void aplicarEstiloAbrir() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        if(campo.isMinado()){
        setBackground(BG_EXPLODIR);
        return;
        }
        
        switch(campo.minasNaVizinhanca()){
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
                case 3:
                setForeground(Color.YELLOW);
                break;
                case 4:
                case 5:
                case 6:
                setForeground(Color.RED);
                break;
                default:
                    setForeground(Color.PINK);               
        }
        
        String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
        setText(valor);
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCAR);
        setForeground(Color.BLACK);
        setText("M");
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_EXPLODIR);
        setForeground(Color.WHITE);
        setText("X");
    }

    private void aplicarEstiloPadrao() {
        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1){
            campo.abrir(); 
        }else {
            campo.alternarMarcacao();
        }
    
    }
    
    public void mouseClicked(MouseEvent arg0) {}
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
    
    
    
    
    
    
    
    

}
