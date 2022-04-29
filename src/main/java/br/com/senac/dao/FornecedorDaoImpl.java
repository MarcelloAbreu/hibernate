package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Classe implementa uma Interface
 * find = encontrar/pesquisar
 * BaseDao Eu pego os 3 parametros que estão lá por Herança
 * SELECT * FROM fornecedor WHERE nome LIKE %joÃo%
 * List ´Fornecedor` forncedores = consulta.getResultList();
 * @author marcello.nunes
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable {
    
    @Override
    public Fornecedor pesquisaPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f where f.nome like :nomeHql");
        consulta.setParameter("nomeHql", "%" + nome + "%");
        return consulta.getResultList();
    }

}
