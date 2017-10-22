package tw.com.demo.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Spring 的相關設定，與dispatcher-servlet.xml是一樣的
 */
@Configuration
@EnableWebMvc
@ComponentScan("tw.com.demo")
@EnableJpaRepositories("tw.com.demo.repository")
@EnableTransactionManagement
public class APConfig extends WebMvcConfigurerAdapter {

    /**
     * 導頁設定
     *
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }

    /**
     * 資源設定，此資源為webapp裡面的資料
     *
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }


    /**
     * 以下為 資料庫連線的相關設定
     *
     */
    @Bean
    public DataSource dataSource() {

//        DriverManagerDataSource mySqlDataSource = new DriverManagerDataSource();
//        mySqlDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        mySqlDataSource.setUrl("jdbc:mysql://localhost:3306/spring_demo?useSSL=false");
//        mySqlDataSource.setUsername("root");
//        mySqlDataSource.setPassword("1234");

        OracleDataSource oracleDataSource = null;
        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            oracleDataSource.setUser("dbo");
            oracleDataSource.setPassword("1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return oracleDataSource;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("tw.com.demo");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        factory.setJpaProperties(additionalProperties());
        return factory.getObject();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("spring.jpa.show-sql", "true");
        properties.setProperty("spring.jpa.hibernate.ddl-auto ", "create-update");
        return properties;
    }
}
