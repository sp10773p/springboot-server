package io.dhseong.core.config;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;
import oracle.jdbc.driver.OracleDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */
@Configuration
@Profile(value = "local")
public class LocalDatabaseConfig {

    @Autowired
    private ApplicationContext context;

    @Value("${config.datasource.typeAliasesPackage}")
    String typeAliasesPackage;

    @Value("${config.datasource.configLoacation}")
    String configLoacation;

    @Value("${config.datasource.mapperLocation}")
    String mapperLocation;

    public DataSource datasourceSpied(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(OracleDriver.class);
        dataSource.setUrl("jdbc:oracle:thin:@220.76.203.39:1521:UCS");
        dataSource.setUsername("UCS_FRAME");
        dataSource.setPassword("qazxsw");

        return dataSource;
    }

    @Bean(name = "dataSource")
    public DataSource log4jdbcProxyDataSource(){
        Log4jdbcProxyDataSource jdbcProxyDataSource = new Log4jdbcProxyDataSource(datasourceSpied());
        Log4JdbcCustomFormatter log4JdbcCustomFormatter = new Log4JdbcCustomFormatter();
        log4JdbcCustomFormatter.setLoggingType(LoggingType.MULTI_LINE);
        log4JdbcCustomFormatter.setSqlPrefix("SQL       : \n");

        jdbcProxyDataSource.setLogFormatter(log4JdbcCustomFormatter);

        return jdbcProxyDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        sqlSessionFactoryBean.setConfigLocation(context.getResource(configLoacation));
        sqlSessionFactoryBean.setMapperLocations(context.getResources(mapperLocation));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 전형적 Transaction
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

}
