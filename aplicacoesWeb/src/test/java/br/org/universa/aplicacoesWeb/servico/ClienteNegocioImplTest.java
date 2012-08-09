package br.org.universa.aplicacoesWeb.servico;

import static org.junit.Assert.assertTrue;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.org.universa.aplicacoesWeb.dominio.Cliente;
import br.org.universa.aplicacoesWeb.dominio.repositorios.ClienteRepositorio;
import br.org.universa.aplicacoesWeb.dominio.repositorios.ClienteRepositorioImpl;
import br.org.universa.aplicacoesWeb.infra.dao.ClienteDAO;
import br.org.universa.aplicacoesWeb.infra.dao.ClienteDAOHibernate;
import br.org.universa.aplicacoesWeb.infra.dao.DAOFactory;
import br.org.universa.aplicacoesWeb.infra.dao.GenericDAO;
import br.org.universa.aplicacoesWeb.infra.dao.GenericHibernateDao;
import br.org.universa.aplicacoesWeb.infra.dao.HibernateDAOFactory;
import br.org.universa.aplicacoesWeb.infra.dao.HibernateUtil;

@RunWith(Arquillian.class)
public class ClienteNegocioImplTest {

	@Deployment
	public static JavaArchive createDeployment() {

		File hibernatecfgxml = new File("src/main/java/hibernate.cfg.xml");
		File log4j = new File("src/main/java/log4j.properties");
		File oscache = new File("src/main/java/oscache.properties");

		System.out.println(hibernatecfgxml.getAbsolutePath());
		JavaArchive ja = ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addClasses(ClienteNegocio.class, ClienteNegocioImpl.class,
						ClienteRepositorio.class, ClienteRepositorioImpl.class,
						HibernateUtil.class, ClienteDAO.class,
						ClienteDAOHibernate.class, HibernateDAOFactory.class,
						DAOFactory.class, GenericDAO.class,
						GenericHibernateDao.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource(hibernatecfgxml).addAsResource(log4j)
				.addAsResource(oscache);
		System.out.println(ja.toString(true));
		return ja;

	}

	@Inject
	private ClienteNegocio cNeg;

	@Test
	public void testSalvar() {

		Cliente c = new Cliente();

		c.setBairro("Norte");
		c.setCnpj("9999999999/0001");
		c.setContato("Bruno");
		c.setEndereco("Rua Buriti");
		c.setEstado("DF");
		c.setHomepage("www.google.com.br");
		c.setMunicipio("Águas Claras");
		c.setQuantidadeEmpregados(1000);
		c.setTelefone("33218181");

		c = cNeg.salvarOuAtualizar(c);

		assertTrue(0 != c.getId());
	}

	// @Test
	// public void testAtualizar() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testBuscarPorId() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testBuscarTodos() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testExcluir() {
	// fail("Not yet implemented");
	// }

}
