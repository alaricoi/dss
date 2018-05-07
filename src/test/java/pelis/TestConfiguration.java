package pelis;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:/conf/application.properties" })

public class TestConfiguration {
	/*@Autowired
	private Environment environment;*/
	   @Bean
	    public DataSource dataSource() {
	        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
	                .setName("Pelis").build();
	    }
	


	    @Bean
	    public LocalSessionFactoryBean sessionFactoryBean() {
	        LocalSessionFactoryBean result = new LocalSessionFactoryBean();
	        result.setDataSource(dataSource());
	        result.setPackagesToScan(new String[] { "pelis.domain" });
	 
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	     //   properties.setProperty("hibernate.hbm2ddl.auto", "none");
	        result.setHibernateProperties(properties);
	        return result;
	    }
	 
	    @Bean
	    public SessionFactory sessionFactory() {
	        return sessionFactoryBean().getObject();
	    }
	 
	    @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager man = new HibernateTransactionManager();
	        man.setSessionFactory(sessionFactory());
	        return man;
	    }
	 
	    
}
