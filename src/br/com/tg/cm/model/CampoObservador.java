/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.tg.cm.model;

/**
 *
 * @author Tiago
 */

@FunctionalInterface
public interface CampoObservador {
    
    public void eventoOcorreu(Campo campo, CampoEvento evento);
    
}
