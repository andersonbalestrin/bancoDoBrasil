/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.PessoaFisica;
import br.com.senac.entidade.Profissao;
import static br.com.senac.util.GeradorUtil.*;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SONY
 */
public class ProfissaoDaoImplTest {

    private Profissao profissao;
    private ProfissaoDao profissaoDao;
    private Session sessao;

    public ProfissaoDaoImplTest() {
        profissaoDao = new ProfissaoDaoImpl();
    }

    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        Faker faker = new Faker();
        profissao = new Profissao(gerarProfissao(), faker.lorem().sentence());
        sessao = HibernateUtil.abrirConexao();
        profissaoDao.salvarOuAlterar(profissao, sessao);
        sessao.close();
        assertNotNull(profissao.getId());

    }

    //  @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();
        Profissao pesProfissao = profissaoDao
                .pesquisarPorId(profissao.getId(), sessao);
        sessao.close();
        assertNotNull(pesProfissao);
    }

    @Test
    public void testPesquisaPorNome() {
        System.out.println("pesquisaPorNome");
        buscarProfissaoBd();
        sessao = HibernateUtil.abrirConexao();

        List<Profissao> fisicas = profissaoDao.pesquisaPorNome(profissao.getNome(), sessao);
        sessao.close();
        assertTrue(!fisicas.isEmpty());
    }

    public Profissao buscarProfissaoBd() { // chamar ele no pessoa fisica, pois pessoa fisica precisa de uma profissão
        sessao = HibernateUtil.abrirConexao();

        Query<Profissao> consulta = sessao.createQuery("from Profissao p");
        List<Profissao> profissaos = consulta.list();
        sessao.close();
        if (profissaos.isEmpty()) {
            testSalvar();
        } else {
            profissao = profissaos.get(0);
        }
        return profissao;
    }
}
