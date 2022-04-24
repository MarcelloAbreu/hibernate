package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import org.hibernate.Session;
import static org.junit.Assert.*;

/**
 *
 * @author Nunes
 */
public class ClienteDaoImplTest {
    
    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;
    
    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }

    //@Test
    public void testSalvar() {
        System.out.println("Salvar Cliente");
        cliente = new Cliente(null,"João", "joão@gmail","22222-222","49999-87");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());      
    }
    
    //@Test
    public void testExcluir(){
        System.out.println("Excluir Cliente");
        cliente = new Cliente(Long.valueOf(1),"Joao","@joao","22222-222","49999-87");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, sessao);
        sessao.close();
}
     //@Test
    public void testAlterar() {
        System.out.println("Alterar Cliente");
        cliente = new Cliente(Long.valueOf(2),"Joao","@joao","22222-222","49999-87");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }
    
    //@Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");

    }
}
