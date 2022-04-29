package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
       buscarUsuario();
       sessao = HibernateUtil.abrirConexao();
       Usuario usuarioPesquisado = usuarioDao.pesquisaPorId(usuario.getId(), sessao);
       sessao.close();
       assertNotNull(usuarioPesquisado);
   
    }
    
    //@Test
    public void testExcluir(){
        System.out.println("excluir");
        usuario = new Usuario(Long.valueOf(1),"Joao","@joao","123456");
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);
        sessao.close();
    }
    
    @Test
    public void testAlterar() {
        System.out.println("Alterar");
        usuario = new Usuario(Long.valueOf(2),"Marcos","@marcos","1234567");
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());
    }
    
        public Usuario buscarUsuario() {
        //select from * usuario;
        String hql = "from Usuario";
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao.createQuery(hql);
        List<Usuario> usuarios = consulta.list();
        
        return usuario;
    }
}
