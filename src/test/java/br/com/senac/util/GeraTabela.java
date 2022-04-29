package br.com.senac.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gerar Tabela No MySQL
 * senac_pu É uma conexão no banco do Mysql
 * @author marcello.nunes
 */
public class GeraTabela {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("senac_pu");
        emf.close();
    }
}
