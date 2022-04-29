package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe Pai
 * Interface
 * Crud todo(BaseDao)
 * @author marcello.nunes
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long> {
    
    List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    
}
