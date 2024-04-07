package com.sping.orm.conf;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.sping.orm.dao.StudentDaoImpl;
import com.sping.orm.entities.Student;

@Configuration
public class SpringOrmConf {

	@Bean(name = { "studentdaoImpl" })
	public StudentDaoImpl getStudentdaoImpl() {
		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
		studentDaoImpl.setHibernateTemplate(getHibernateTemplate());
		return studentDaoImpl;
	}

	@Bean(name = { "ds" })
	public DataSource getdataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/springOrm");
		driverManagerDataSource.setPassword("root");
		driverManagerDataSource.setUsername("root");
		return driverManagerDataSource;
	}

	@Bean(name = { "factory" })
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getdataSource());
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setAnnotatedClasses(Student.class);

		return localSessionFactoryBean;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

	@Bean(name = { "hibernateTemplate" })
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(getSessionFactory().getObject());
		return hibernateTemplate;
	}
}
