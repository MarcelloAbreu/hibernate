package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.util.GeradorUtil;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes Unitarios Fornecedor
 * fornecedorDao classe que vou testar no costrutor 
 * @author marcello.nunes
 */
public class FornecedorDaoImplTest {
    
    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    
    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testSalvarOuAlterar() {
        System.out.println("Salvar ou Alterar o Fornecedor");
        fornecedor = new Fornecedor("Fornecedor " + GeradorUtil.gerarNome());
        fornecedor.setDescricao("Periféricos Eletrônicos");
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());
        
    }

    //@Test
    public void testExcluir() {
        System.out.println("Excluir Fornecedor");
        fornecedor = new Fornecedor();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.excluir(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());

    }

    //@Test
    public void testPesquisaPorId() {
        System.out.println("Pesquisa Por Id do Fornecedor");
        //buscarFornecedor();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.pesquisaPorId(fornecedor.getId(), sessao);
        sessao.close();
        //assertNotNull(buscarfornecedor);
        
    }
    
    //@Test
    public void testPesquisaPorNome() {
        System.out.println("Pesquisa Por Nome do Fornecedor");
        //buscarFornecedor();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.pesquisarPorNome(fornecedor.getNome(), sessao);
        sessao.close();
        //assertNotNull(buscarfornecedor);

    }
    
    public Fornecedor buscarFornecedor(){
        
        return null;
    }
            
    
}
