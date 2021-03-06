/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.ConnectionFactory;

/**
 * @author internet
 */

public class ContatoModel {
    
    private Connection conexao;

    /**
     * @throws SQLException - In case of database error.
     */
    
    public ContatoModel() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }

   /**
     * Insert a new register in the database.
     * @param c - Contact that will be included
     * @throws SQLException - In case of database error
     */
    
    // @NamedQuery(name = "Contato.insertAll", query = "INSERT INTO contato (nome, email, telefone, cep) VALUES (?,?,?,?)")
    
    public void insert(Contato c) throws SQLException {
        String sql = "INSERT INTO  "
                + "contato (nome, email, telefone, cep) VALUES (?,?,?,?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getCep());
            ps.execute();
            ps.close();
            conexao.close();
        }
    }

   /**
     * Update a register in the database.
     * @param c - Contact that will be updated.
     * @throws SQLException - In case of database error.
     */
    
       /*
        * @NamedQuery(name = "Contato.updateByNome", query = "UPDATE contato SET nome")
        * @NamedQuery(name = "Contato.updateByEmail", query = "UPDATE contato SET email")
        * @NamedQuery(name = "Contato.updateByTelefone", query = "UPDATE contato SET telefone")
        * @NamedQuery(name = "Contato.updateByCep", query = "UPDATE contato SET cep")
        */
    
    public void update(Contato c) throws SQLException {
        String sql = "UPDATE contato SET "
                + "nome = ? "
                + "email = ? "
                + "telefone = ? "
                + "cep = ? "
                + "WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getCep());
            ps.setInt(5, c.getId());
            ps.execute();
            ps.close();
            conexao.close();
        }
    }

    /**
     * Delete a register in the database.
     * @param c - Contact that will be deleted.
     * @throws SQLException - In case of database error.
     */
    
     // @NamedQuery(name = "Contato.deleteById", query = "DELETE FROM contato WHERE ID = ?")
     
    public void delete(Contato c) throws SQLException {
        String sql = "DELETE FROM contato WHERE ID = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, c.getId());
            ps.execute();
            ps.close();
            conexao.close();
        }
    }

    /**
     * This method finds a contact from the list.
     * @param c - Contact that will be listed.
     * @throws SQLException - In case of database error.
     * @return Search result.
     */
    
   //  @NamedQuery(name = "Contato.findAll", query = "SELECT * FROM contato WHERE nome LIKE ? ORDER BY nome")
    
    
    public List<Contato> find(Contato c) throws SQLException {
        ArrayList<Contato> resultado = new ArrayList();
        String sql = "SELECT * FROM contato WHERE nome LIKE ? ORDER BY nome";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + c.getNome() + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setCep(rs.getString("cep"));
            resultado.add(c);
        }
        return resultado;
    }

    /**
     * This method lists all content in the database.
     * @throws SQLException - In case of database error.
     * @return List of all contact from ArrayList.
     */
    
    //@NamedQuery(name = "Contato.findAll", query = "SELECT * FROM contato ORDER BY nome ASC")
    
    public List<Contato> listAll() throws SQLException {
        //Select a table contato in order ASC in database
        String sql = "SELECT * FROM contato ORDER BY nome ASC";
        ArrayList<Contato> resultado = new ArrayList();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Contato c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setTelefone(rs.getString("telefone"));
            c.setCep(rs.getString("cep"));
            resultado.add(c);
        }
        return resultado;
    }
}
