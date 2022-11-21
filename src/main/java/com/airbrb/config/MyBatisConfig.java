package com.airbrb.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

//@MapperScan({"com.airbrb.mapper", "com.airbrb.dao"})
public class MyBatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean() ;
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathM3R = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(pathM3R.getResources("classpath*:mappers/*.xml"));
        factoryBean.setTypeAliasesPackage("com.airbrb.domain");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc=new MapperScannerConfigurer();
        msc.setBasePackage("com.airbrb.dao");
        return msc;
    }
}
