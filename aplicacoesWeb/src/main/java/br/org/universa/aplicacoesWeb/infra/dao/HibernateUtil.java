package br.org.universa.aplicacoesWeb.infra.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory FABRICA_DE_SESSAO = construirFabricaDeSessao();

	public static SessionFactory getSessionFactory() {

		return FABRICA_DE_SESSAO;
	}

	private static SessionFactory construirFabricaDeSessao() {

		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Criação inicial da fábrica de Sessões falhou: "
					+ e);
			throw new ExceptionInInitializerError(e);
		}
	}

}
