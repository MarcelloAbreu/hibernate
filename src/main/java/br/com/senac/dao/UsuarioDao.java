package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Nunes
 */
public interface UsuarioDao extends BaseDao<Usuario, Long>{
    
    List<Usuario> pesquisarTodos(Session sessao) throws HibernateException;
    
    List<Usuario> pesquisarPorNome(String nome,Session sessao) throws HibernateException;
}
