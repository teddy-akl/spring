package persyuanwy.spring.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement()
public class JpaConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource retVal = new BasicDataSource();
		retVal.setDriverClassName("com.mysql.cj.jdbc.Driver");
		retVal.setUrl(
				"jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=true");
		retVal.setUsername("root");
		retVal.setPassword("111111");
		return retVal;
	}

	@Bean()
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean retVal = new LocalContainerEntityManagerFactoryBean();
		retVal.setPersistenceUnitName("Y_PU");
		retVal.setDataSource(dataSource());
		retVal.setPackagesToScan("com.founder.spring.entity");
		retVal.setPersistenceProvider(new HibernatePersistenceProvider());
		retVal.setJpaProperties(jpaProperties());
		return retVal;
	}

	@Bean()
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager retVal = new JpaTransactionManager();
		retVal.setEntityManagerFactory(entityManagerFactory);
		return retVal;
	}

	private Properties jpaProperties() {
		Properties extraProperties = new Properties();
		extraProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		extraProperties.put("hibernate.format_sql", "true");
		extraProperties.put("hibernate.show_sql", "false");
		extraProperties.put("hibernate.hbm2ddl.auto", "update");
		extraProperties.put("hibernate.jdbc.batch_size", "20");
		extraProperties.put("hibernate.hbm2ddl.auto", "update");
		return extraProperties;
	}
}
