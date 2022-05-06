package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author marcello.nunes
 */
public interface ProdutoDao extends BaseDao<Produto, Long>{
    
    List<Produto> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
    
}
