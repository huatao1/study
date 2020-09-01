package com.syit.dem;


import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@MapperScan("com.syit.dem.Mapper")
@SpringBootApplication(scanBasePackages = "com")

public class DemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemApplication.class, args);
    }


//    @Bean(name = "commonSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory commonSqlSessionFactory(@Qualifier("commonDataSource") DataSource commonDataSource)throws Exception {
//        //DefaultVFS在获取jar上存在问题，使用springboot只能修改  ,否则setTypeAliasesPackage 在生产环境报错
//        VFS.addImplClass(SpringBootVFS.class);
////        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
//        sessionFactory.setDataSource(commonDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/syit/dem/Mapper/impl/*.xml"));
//        sessionFactory.setTypeAliasesPackage("com.syit.dem.entity");
//        return sessionFactory.getObject();
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSourceProxy) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/syit/dem/Mapper/impl/*.xml"));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        // 导入mybatis配置
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        // 配置打印sql语句
        configuration.setLogImpl(StdOutImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
//        // 添加分页功能
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{
//                paginationInterceptor()
//        });
        // 导入全局配置
//        sqlSessionFactoryBean.setGlobalConfig(globalConfiguration());
        return sqlSessionFactoryBean.getObject();
    }
}
