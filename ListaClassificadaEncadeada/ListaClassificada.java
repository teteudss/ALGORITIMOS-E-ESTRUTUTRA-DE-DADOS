/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaclassificadaencadeada;

import java.awt.Cursor;

/**
 *
 * @author UESB-USR
 */
interface ListaCLassificada {
    Object get (int i);
    Cursor procurarPosicao(Object o);
    boolean eMembro  (Object o);
    void inserir (Object o);
    void remover (Object o);
    Object procurar (Object o);
    
}
