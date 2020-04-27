package com.hexu.ebank.user.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class MybatisConfiguration{

    /////////////////////Mybatis参数///////////////////////////////////////////////////
    @Value("${spring.datasource.driver-class-name}")
    private String driveClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${mybatis.xmlLocation}")
    private String xmlLocation;
//    @Value("${mybatis.typeAliasesPackage}")
//    private String typeAliasesPackage;
    /////////////////////druid参数///////////////////////////////////////////////////
    @Value("${spring.datasource.filters}")
    private String filters;
    @Value("${spring.datasource.maxActive}")
    private String maxActive;
    @Value("${spring.datasource.initialSize}")
    private String initialSize;
    @Value("${spring.datasource.maxWait}")
    private String maxWait;
    @Value("${spring.datasource.minIdle}")
    private String minIdle;
    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.testWhileIdle}")
    private String testWhileIdle;
    @Value("${spring.datasource.testOnBorrow}")
    private String testOnBorrow;
    @Value("${spring.datasource.testOnReturn}")
    private String testOnReturn;
    @Value("${spring.datasource.poolPreparedStatements}")
    private String poolPreparedStatements;
    @Value("${spring.datasource.maxOpenPreparedStatements}")
    private String maxOpenPreparedStatements;
    //////////////////////////////////////////////////////////////////////////

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.userName);
        druidDataSource.setPassword(this.password);
        druidDataSource.setDriverClassName(StringUtils.isNotBlank(this.driveClassName)?this.driveClassName:"com.mysql.cj.jdbc.Driver");
        druidDataSource.setMaxActive(StringUtils.isNotBlank(this.maxActive)? Integer.parseInt(this.maxActive):10);
        druidDataSource.setInitialSize(StringUtils.isNotBlank(this.initialSize)? Integer.parseInt(this.initialSize):1);
        druidDataSource.setMaxWait(StringUtils.isNotBlank(this.maxWait)? Integer.parseInt(this.maxWait):60000);
        druidDataSource.setMinIdle(StringUtils.isNotBlank(this.minIdle)? Integer.parseInt(this.minIdle):3);
        druidDataSource.setTimeBetweenEvictionRunsMillis(StringUtils.isNotBlank(this.timeBetweenEvictionRunsMillis)?
                Integer.parseInt(this.timeBetweenEvictionRunsMillis):60000);
        druidDataSource.setMinEvictableIdleTimeMillis(StringUtils.isNotBlank(this.minEvictableIdleTimeMillis)?
                Integer.parseInt(this.minEvictableIdleTimeMillis):300000);
        druidDataSource.setValidationQuery(StringUtils.isNotBlank(this.validationQuery)?this.validationQuery:"select 'x'");
        druidDataSource.setTestWhileIdle(StringUtils.isNotBlank(this.testWhileIdle)? Boolean.parseBoolean(this.testWhileIdle):true);
        druidDataSource.setTestOnBorrow(StringUtils.isNotBlank(this.testOnBorrow)? Boolean.parseBoolean(this.testOnBorrow):false);
        druidDataSource.setTestOnReturn(StringUtils.isNotBlank(this.testOnReturn)? Boolean.parseBoolean(this.testOnReturn):false);
        druidDataSource.setPoolPreparedStatements(StringUtils.isNotBlank(this.poolPreparedStatements)? Boolean.parseBoolean(this.poolPreparedStatements):true);
        druidDataSource.setMaxOpenPreparedStatements(StringUtils.isNotBlank(this.maxOpenPreparedStatements)? Integer.parseInt(this.maxOpenPreparedStatements):20);

        try {
            druidDataSource.setFilters(StringUtils.isNotBlank(this.filters)?this.filters:"stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /*
        if(StringUtils.isNotBlank(this.typeAliasesPackage)){
            bean.setTypeAliasesPackage(this.typeAliasesPackage);
        }
         */
        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Interceptor[] plugins =  new Interceptor[]{pageHelper};
        bean.setPlugins(plugins);
        try {
            bean.setMapperLocations(resolver.getResources(this.xmlLocation));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
