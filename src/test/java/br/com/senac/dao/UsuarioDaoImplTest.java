package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.Session;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Nunes
 */
public class UsuarioDaoImplTest {
    
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }
    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        usuario = new Usuario(null,"Joao","@joao","123456");
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }
    
    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");

    }
}
