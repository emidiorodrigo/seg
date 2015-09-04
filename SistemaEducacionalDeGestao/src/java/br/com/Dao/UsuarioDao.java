/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import br.com.Entity.Usuario;
import br.com.Util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FRANCISCO
 */
public class UsuarioDao {
    private Session sessao;
    private Transaction trans;
    
    public void addUsuario(Usuario u){
        
        try {
            sessao = (Session) Util.getSessionFactory();
        trans = sessao.beginTransaction();
       
        Usuario usuario = new Usuario ();
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setUsuario(u.getUsuario());
        usuario.setSenha(u.getSenha());
        usuario.setConfrimaSenha(u.getConfrimaSenha());
        
        sessao.save(usuario);
        trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        sessao.close();
        }
   
        
        
        
    }
    
}
