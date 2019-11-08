package edu.ssafy.boot;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AppConfig {
	
	public PlatformTransactionManager getPlatformTransactionManater(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

}
