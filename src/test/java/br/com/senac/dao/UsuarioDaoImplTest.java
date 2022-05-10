package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import static br.com.senac.util.GeradorUtil.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import static org.junit.Assert.*;
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
        usuario = new Usuario(null,gerarNome(),gerarLogin(),gerarSenha(5));
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
        buscarUsuario();
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.excluir(usuario, sessao);
       //Saber se excluiu
        Usuario usuarioExcluido = usuarioDao.pesquisaPorId(usuario.getId(), sessao);
        assertNull(usuarioExcluido);
    }
    
    //@Test
    public void testAlterar() {
        System.out.println("Alterar");
        buscarUsuario();
      
        usuario.setNome(gerarNome());
        usuario.setLogin(gerarLogin());
      
        sessao = HibernateUtil.abrirConexao();
        usuarioDao.salvarOuAlterar(usuario, sessao);
        sessao.close();
      //Verificar se Alterou
        sessao = HibernateUtil.abrirConexao();
        Usuario usuarioAlt = usuarioDao.pesquisaPorId(usuario.getId(), sessao);
        sessao.close();
        assertEquals(usuario.getNome(), usuarioAlt.getNome());
        assertEquals(usuario.getLogin(), usuarioAlt.getLogin());
    }
    
    @Test
    public void testPesquisarTodo() {
        System.out.println("pesquisarTodo");
        buscarUsuario();
        sessao = HibernateUtil.abrirConexao();
        List<Usuario> usuarios = usuarioDao.pesquisarTodos(sessao);
        sessao.close();
        assertTrue(!usuarios.isEmpty());
    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarUsuario();
        sessao = HibernateUtil.abrirConexao();
        int elemento = usuario.getNome().indexOf(" ");
        String nome = usuario.getNome().substring(0, elemento);
        List<Usuario> usuarios = usuarioDao.pesquisarPorNome(usuario.getNome(),sessao);
        sessao.close();
        assertTrue(usuarios.size() > 0);
    }
    
        public Usuario buscarUsuario() {
        //select from * usuario;
        String hql = "from Usuario";
        sessao = HibernateUtil.abrirConexao();
        Query<Usuario> consulta = sessao.createQuery(hql);
        List<Usuario> usuarios = consulta.list();
        sessao.close();
        if(usuarios.isEmpty()){
            testSalvar();
        }else{
            usuario = usuarios.get(0);
        }
        return usuario;
    }
}
