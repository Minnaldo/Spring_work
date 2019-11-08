package edu.ssafy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.ssafy.dto.BoardDto;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration 자바로 뽑아내는거 하는중.
@Configuration
@EnableSwagger2
public class ApplicationConfig {
	
//	@Bean
//	public BoardDto testBoard() {
//		return new BoardDto("200", "title", "content");
//	}
	
	/* Swagger를 위한 설정 */
	@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))		//api밑에 rest로 시작하는 *(모든것을) 문서로 만들겠다.
                											//rest*  (별 하나 의미는) 구간 하나 의미.. / 개수가 다르다 보니,  rest*이 아닌  rest**  별 2개여야 1개이상 가능.
                											//**  =>  정규식(Regular Expression) 이라고 한다.
                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SSAFY API").description("SSAFY API Reference for Developers")
                .termsOfServiceUrl("https://edu.ssafy.com").contact("ssafy@ssafy.com").license("SSAFY License")
                .licenseUrl("ssafy@ssafy.com").version("1.0").build();
    }
}
