package edu.ssafy.boot;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@ComponentScan({"eud.ssafy.boot"})
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	//@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/springweb?serverTimezone=UTC&useSSL=false&useUniCode=yes&characterEncoding=UTF-8");
		ds.setUsername("ssafy");
		ds.setPassword("ssafy");
		//ds.setMaxActive(20);
		return ds;
	}
	
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean sbean = new SqlSessionFactoryBean();
		sbean.setDataSource(ds);
		String configLoc = "classpath:/mybatisconfig/MybatisConfig.xml";
		sbean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLoc));
		
		return sbean;
	}
	
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
}
