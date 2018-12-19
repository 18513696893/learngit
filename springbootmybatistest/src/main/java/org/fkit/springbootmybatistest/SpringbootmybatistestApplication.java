package org.fkit.springbootmybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//指定数据访问层接口的包名
@MapperScan("org.fkit.springbootmybatistest.repository")
public class SpringbootmybatistestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmybatistestApplication.class, args);
	}

}

