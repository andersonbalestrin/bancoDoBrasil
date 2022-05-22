/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author SONY
 */
public interface ProfissaoDao extends BaseDao<Profissao, Long> { // sempre que faz uma interfa
    List<Profissao> pesquisaPorNome (String nome, Session session) throws HibernateException;
    
    
    
}
