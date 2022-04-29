package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
        buscarFornecedor();
        sessao = HibernateUtil.abrirConexao();
        Fornecedor fornecedorPesquisado = fornecedorDao.pesquisaPorId(fornecedor.getId(), sessao);
        sessao.close();
        assertNotNull(fornecedorPesquisado);
        
    }
    
    //@Test
    public void testPesquisaPorNome() {
        System.out.println("Pesquisa Por Nome do Fornecedor");
        buscarFornecedor();
        sessao = HibernateUtil.abrirConexao();
        List<Fornecedor> nomePesquisado = fornecedorDao.pesquisarPorNome(fornecedor.getNome(), sessao);
        sessao.close();
        assertNotNull(nomePesquisado);

    }
    
    public Fornecedor buscarFornecedor(){
        //select from * fornecedor;
        String hql = "from Fornecedor";
        sessao = HibernateUtil.abrirConexao();
        Query<Fornecedor> consulta = sessao.createQuery(hql);
        List<Fornecedor> fornecedores = consulta.list();
        sessao.close();
        if(fornecedores.isEmpty()){
           testSalvarOuAlterar();
        }else{
            fornecedor = fornecedores.get(0);
        }
        
        return fornecedor;
    }
}
