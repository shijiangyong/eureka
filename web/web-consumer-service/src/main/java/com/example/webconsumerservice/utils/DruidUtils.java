package com.example.webconsumerservice.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidStatProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author shijy
 * @Date 2018/11/30 14 : 08
 * @Descriprion
 */
@Configuration
public class DruidUtils {

        private Logger logger = LoggerFactory.getLogger(DruidUtils.class);

        @Value("${spring.datasource.url}")
        private String dbUrl;

        @Value("${spring.datasource.type}")
        private String type;

        @Value("${loginUsername}")
        private String loginUsername;

        @Value("${loginPassword}")
        private String loginPassword;

        @Value("${spring.datasource.username}")
        private String username;

        @Value("${spring.datasource.password}")
        private String password;

        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;

        @Value("${spring.datasource.initialSize}")
        private int initialSize;

        @Value("${spring.datasource.minIdle}")
        private int minIdle;

        @Value("${spring.datasource.maxActive}")
        private int maxActive;

        @Value("${spring.datasource.maxWait}")
        private int maxWait;

        @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
        private int timeBetweenEvictionRunsMillis;

        @Value("${spring.datasource.minEvictableIdleTimeMillis}")
        private int minEvictableIdleTimeMillis;

        @Value("${spring.datasource.validationQuery}")
        private String validationQuery;

        @Value("${spring.datasource.testWhileIdle}")
        private boolean testWhileIdle;

        @Value("${spring.datasource.testOnBorrow}")
        private boolean testOnBorrow;

        @Value("${spring.datasource.testOnReturn}")
        private boolean testOnReturn;

        @Value("${spring.datasource.filters}")
        private String filters;

        @Value("${spring.datasource.logSlowSql}")
        private String logSlowSql;

        @Bean
        public ServletRegistrationBean druidServlet() {
            ServletRegistrationBean reg = new ServletRegistrationBean();
            reg.setServlet((Servlet) new DruidStatProperties.StatViewServlet());
            reg.addUrlMappings("/druid/*");
            reg.addInitParameter("loginUsername", loginUsername);
            reg.addInitParameter("loginPassword", loginPassword);
            reg.addInitParameter("logSlowSql", logSlowSql);
            return reg;
        }

        @Bean
        public FilterRegistrationBean filterRegistrationBean() {
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
            filterRegistrationBean.setFilter((Filter) new DruidStatProperties.WebStatFilter());
            filterRegistrationBean.addUrlPatterns("/*");
            filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
            filterRegistrationBean.addInitParameter("profileEnable", "true");
            return filterRegistrationBean;
        }

        @Bean
        public DataSource druidDataSource() {
            DruidDataSource datasource = new DruidDataSource();
            datasource.setUrl(dbUrl);
            datasource.setUsername(username);
            datasource.setPassword(password);
            datasource.setDriverClassName(driverClassName);
            datasource.setInitialSize(initialSize);
            datasource.setMinIdle(minIdle);
            datasource.setMaxActive(maxActive);
            //datasource.setDbType(type);
            datasource.setMaxWait(maxWait);
            datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            datasource.setValidationQuery(validationQuery);
            datasource.setTestWhileIdle(testWhileIdle);
            datasource.setTestOnBorrow(testOnBorrow);
            datasource.setTestOnReturn(testOnReturn);
            try {
                datasource.setFilters(filters);
            } catch (SQLException e) {
                logger.error("druid configuration initialization filter", e);
            }
            return datasource;
        }

}
