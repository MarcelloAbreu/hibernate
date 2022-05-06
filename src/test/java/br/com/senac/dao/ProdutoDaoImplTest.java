package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.entidade.Produto;
import static br.com.senac.util.GeradorUtil.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testes Unitarios Produto
 * SELECT * FROM produto p Left join Fornecedor f on p.id_fornecedor = f.id;
 * PesquisaPorId faz essa pesquisa de cima
 * @author marcello.nunes
 */
public class ProdutoDaoImplTest {
    
    private Produto produto;
    private ProdutoDao produtoDao;
    private Session sessao;
    
    public ProdutoDaoImplTest() {
        produtoDao = new ProdutoDaoImpl();
    }
      
//    @Test
    public void testSalvar() {
        System.out.println("Salvar Produto");
        produto = new Produto(gerarNome(), Integer.parseInt(gerarNumero(2)), Double.parseDouble(gerarNumero(4)));
        FornecedorDaoImplTest fdit = new FornecedorDaoImplTest();
        Fornecedor fornecedor = fdit.buscarFornecedor();
        produto.setFornecedor(fornecedor);
        sessao = HibernateUtil.abrirConexao();
        produtoDao.salvarOuAlterar(produto, sessao);
        sessao.close();
        assertNotNull(produto.getId());
    }
    
//        @Test
    public void testAlterar() {
        System.out.println("Alterar Produto");
        buscarProduto();
        produto.setNome(gerarNome());
        sessao = HibernateUtil.abrirConexao();
        produtoDao.salvarOuAlterar(produto, sessao);
        sessao.close();
        // Verificar se Alterou o Produto
        sessao = HibernateUtil.abrirConexao();
        Produto produtoAlterado = produtoDao.pesquisaPorId(produto.getId(), sessao);
        sessao.close();
        assertEquals(produto.getNome(),produtoAlterado.getNome());
    }
    
    //  @Test
    public void testExcluir() {
        System.out.println("Excluir Produto");
        buscarProduto();
        sessao = HibernateUtil.abrirConexao();
        produtoDao.excluir(produto, sessao);
        //Saber se Excluiu(verificar)
        Produto produtoExcluido = produtoDao.pesquisaPorId(produto.getId(), sessao);
        assertNull(produtoExcluido);
    }

//    @Test
    public void testPesquisaPorId() {
        System.out.println("Pesquisa Por Id Produto");
        buscarProduto();
        sessao = HibernateUtil.abrirConexao();
        Produto produtoPesquisado = produtoDao.pesquisaPorId(produto.getId(), sessao);
        sessao.close();
        assertNotNull(produtoPesquisado);
    }

    @Test
    public void testPesquisarPorNome() {
        System.out.println("Pesquisar Por Nome do Produto");
        buscarProduto();
        sessao = HibernateUtil.abrirConexao();
        List<Produto> produtos = produtoDao.pesquisarPorNome(produto.getNome(), sessao);
        sessao.close();
        assertTrue(!produtos.isEmpty());
    }
    
    public Produto buscarProduto(){
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Produto p");
        List<Produto> produtos = consulta.getResultList();
        sessao.close();
        if (produtos.isEmpty()) {
            testSalvar();
        }else{
            produto = produtos.get(0);
        }
        return produto;
    }  
}
