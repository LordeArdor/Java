/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.Contato;
import java.sql.SQLException;
import java.util.List;
import model.ContatoModel;

/**
 * @author internet
 */
public class ContatoController {
    public void inserir (Contato c) throws SQLException {
        ContatoModel cm = new ContatoModel();
        cm.insert(c);
    }
    
    /**
     * This method returns all contacts
     * @return Lists the contacts.
     * @throws SQLException - In case of database error.
     */
    
    public List<Contato> listar() throws SQLException{
       
        ContatoModel cm = new ContatoModel();
        return cm.listAll();
    }
    
    /**
     * This method returns the search results
     * @param c - contact that will be searched 
     * @return Search contacts.
     * @throws SQLException - In case of database error.
     */
    
    public List<Contato> procurar (Contato c) throws SQLException {
        ContatoModel cm = new ContatoModel();
        return cm.find(c);
    }
    
    /** 
     * This method deletes a contact
     * @param c - contact that will be deleted 
     * @throws SQLException - In case of database error.
     */
    
    public void deletar (Contato c) throws SQLException {
        ContatoModel cm = new ContatoModel();
        cm.delete(c);
    }
    
    /**
     * This method updates the selected contact
     * @param c - contact that will be updated
     * @throws SQLException - In case of database error.
     */
    
    public void atualizar (Contato c) throws SQLException {
        ContatoModel cm = new ContatoModel ();
        cm.update(c);
    }
    
    
    
}
