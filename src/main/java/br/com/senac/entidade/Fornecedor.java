package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * FORNECEDOR
 * @Lob - BIG TEXTO
 * Questão de Prova
 * Construtor Serve para iniciar as variáveis mais rapido e não poluir o código
 * Obrigado deixar o Construtor Sem paramêtros(Deixar Aparecendo)PQ
 * para o construtor que tem paramêtros não anular o que está sem paramêtors
 * @author marcello.nunes
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Lob
    private String descricao;

    public Fornecedor() {
    }

    public Fornecedor(String nome) {
        this.nome = nome;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.com.senac.entidade.Fornecedor[ id=" + id + " ]";
    }
    
}
