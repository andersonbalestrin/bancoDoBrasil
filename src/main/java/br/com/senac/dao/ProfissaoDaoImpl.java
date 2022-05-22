/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author SONY
 */
public class ProfissaoDaoImpl extends BaseDaoImpl<Profissao, Long> implements ProfissaoDao, Serializable {

    @Override
    public Profissao pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Profissao.class, id);
    }

    @Override
    public List<Profissao> pesquisaPorNome(String nome, Session session) throws HibernateException {
        Query<Profissao> consulta = session.createQuery("from Profissao p where p.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

}
