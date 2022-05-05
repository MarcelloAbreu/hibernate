package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import static br.com.senac.util.GeradorUtil.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
        cliente = new Cliente(null,gerarNome(),gerarLogin(),gerarCpf(),"49999-87");
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());      
    }
    
    //@Test
    public void testExcluir(){
        System.out.println("Excluir Cliente");
        buscarCliente();
        sessao = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, sessao);
        //Saber se Excluiu
        Cliente clienteExcluido = clienteDao.pesquisaPorId(cliente.getId(), sessao);
        assertNull(clienteExcluido);
}
     //@Test
    public void testAlterar() {
        System.out.println("Alterar Cliente");
        buscarCliente();
        cliente.setNome("Nome Alt" + gerarNome());
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        // Verificar se Alterou o Cliente
        sessao = HibernateUtil.abrirConexao();
        Cliente clienteAlterado = clienteDao.pesquisaPorId(cliente.getId(), sessao);
        assertEquals(cliente.getNome(), clienteAlterado.getNome());
    }
    
    //@Test
    public void testPesquisaPorId() {
        System.out.println("Pesquisa pelo Id do Cliente");
        buscarCliente();
        sessao = HibernateUtil.abrirConexao();
        Cliente clientePesquisado = clienteDao.pesquisaPorId(cliente.getId(), sessao);
        sessao.close();
        assertNotNull(clientePesquisado);
    }
    
     public Cliente buscarCliente() {
        //select from * cliente;
        String hql = "from Cliente";
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery(hql);
        List<Cliente> clientes = consulta.list();
        sessao.close();
        if(clientes.isEmpty()){
            testSalvar();
        }else{
            cliente = clientes.get(0);
        } 
        return cliente;
    }
}
