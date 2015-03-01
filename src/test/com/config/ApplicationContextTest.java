/*
 * Created by Hicham B.I. on ${DATE}.
 */
package com.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;


@Configuration
@ComponentScan({"com"})
@Profile("test")
@PropertySource("application-test.properties")
public class ApplicationContextTest {


    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(env.getRequiredProperty("db.test.driverClassName"));
        dataSource.setJdbcUrl(env.getRequiredProperty("db.test.url"));
        dataSource.setUsername(env.getRequiredProperty("db.test.username"));
        dataSource.setPassword(env.getRequiredProperty("db.test.password"));

        return dataSource;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());

        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(
                new ClassPathResource(env.getRequiredProperty("db.test.schema.script"))
        );

        initializer.setDatabasePopulator(populator);
        return initializer;
    }
}