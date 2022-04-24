package br.com.senac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Crud
 * @author Nunes
 */
public interface BaseDao<T,ID> {
    void salvarOuAlterar(T entidade,Session sessao)throws HibernateException;
    
    void excluir(T entidade,Session sessao)throws HibernateException;
    
    T pesquisaPorId(ID id,Session sessao)throws HibernateException;
}
