/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Bean;

import br.com.Dao.UsuarioDao;
import br.com.Entity.Usuario;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FRANCISCO
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
   private Usuario usuario = new Usuario(); 
   private UsuarioDao usuarioDao = new UsuarioDao();
   private String senha;
   private String confirmaSenha;
   
  
   
    public UsuarioBean() {
        
    }
    
    public String  adicinarUsuario(){
        FacesContext context = FacesContext.getCurrentInstance();
        if (!this.senha.equalsIgnoreCase(this.confirmaSenha)){
        
        context.addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Senha Confirmada Incorretamente",""));
        return "Usuário";
        
        }
        
        
    usuarioDao.addUsuario(usuario);
    
        
   return "UsuárioCadastrado";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioBean other = (UsuarioBean) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
}
