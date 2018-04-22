package pelis;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import pelis.configuration.HibernateConfiguration;
import pelis.configuration.PelisConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PelisConfiguration.class, HibernateConfiguration.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public abstract class CustomTest {
	 protected final Log log = LogFactory.getLog(getClass());
}
