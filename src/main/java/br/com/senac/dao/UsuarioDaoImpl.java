package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.*;

/**
 *
 * @author Nunes
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao{

    @Override
    public Usuario pesquisaPorId(Long id, Session sessao) throws HibernateException {
       return sessao.get(Usuario.class, id);
    }
    
}
