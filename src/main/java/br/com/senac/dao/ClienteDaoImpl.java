package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Nunes
 */
public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao{

    @Override
    public Cliente pesquisaPorId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Cliente.class, id);
    }
    
}
