package br.com.senac.entidade;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * POJO
 * @author marcello.nunes
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto- Processa+Minha Máquina tem que saber/ IDENTITY-auto incremento
    private Long id;
    
    @Column(nullable = false,length = 120) // Nullable é true e fica Não Obrigatório
    private String nome;
    
    @Column(nullable = false,length = 120,unique = true)
    private String login;
    
    @Column(nullable = false,length = 100)
    private String senha;
    
    private LocalDate ultimoAcesso;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDate ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
    
    @Override //Sobrescrita/ Herda do Objeto
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.Usuario[ id=" + id + " ]";
    }
    
}
