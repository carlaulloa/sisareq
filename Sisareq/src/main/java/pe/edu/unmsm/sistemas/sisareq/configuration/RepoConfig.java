package pe.edu.unmsm.sistemas.sisareq.configuration;

import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "pe.edu.unmsm.sistemas.sisareq.dao.impl")
public class RepoConfig {
    @Bean(name = "dataSource", destroyMethod = "close")
    public BasicDataSource dataSource(Environment environment){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbhelpdesk");
        dataSource.setUsername("SISAREQ");
        dataSource.setPassword("SISAREQ");
//        dataSource.setUsername("b4a929cda1e827");
//        dataSource.setPassword("d09727b6");
        return dataSource;
    }
    
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean(
            BasicDataSource dataSource, Environment environment){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("pe.edu.unmsm.sistemas.sisareq.domain");
        
        Properties hibernateProperties = new Properties();
            hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }
}
