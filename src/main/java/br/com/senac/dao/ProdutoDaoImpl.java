package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class ProdutoDaoImpl extends BaseDaoImpl<Produto, Long> implements ProdutoDao, Serializable {

    @Override
    public Produto pesquisaPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Produto.class, id);
    }

    @Override
    public List<Produto> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Produto> consulta = sessao.createQuery("From Produto p where p.nome Like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
}
