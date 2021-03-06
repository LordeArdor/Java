/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an object Contato
 * @author internet
 */

public class Contato {

    // Attributes
    
    private int id;
    private String nome, email, telefone, cep;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public Map<String, String> verificaPreenchimento() {
        Map<String, String> campos = new HashMap<>();
       
        if (nome == null) {
            campos.put("nome", "");
        } else {
            campos.put("nome", nome);
        }

        if (email == null) {
            campos.put("email", "");
        } else {
            campos.put("email", email);
        }

        if (telefone == null) {
            campos.put("telefone", "");
        } else {
            campos.put("telefone", telefone);
        }

        if (cep == null) {
            campos.put("cep", "");
        } else {
            campos.put("cep", cep);
        }

        return campos;
    }
}
