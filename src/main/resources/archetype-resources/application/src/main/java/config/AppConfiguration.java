package ${package}.config;

import ${package}.support.WrapperResultResponseBodyAdvice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger.web.ApiResourceController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * @Auther: baozi
 * @Date: 2019/6/23 17:28
 * @Description:
 */
@EnableSwagger2
@MapperScan(AppConfiguration.DAO_PACKAGE)
@EnableFeignClients(AppConfiguration.INTERGRATION_PACKAGE)
@EnableDiscoveryClient
@Configuration
public class AppConfiguration {

    final static String DAO_PACKAGE          = "${package}.common.dao";
    final static String INTERGRATION_PACKAGE = "${package}.integration";

    /**
     * 调度提出配置,可以开关控制开启
     */
    @ConditionalOnProperty(
            value = "app.scheduling.enable", havingValue = "true", matchIfMissing = true
    )
    @Configuration
    @EnableScheduling
    public static class SchedulingConfiguration {
    }

    @Configuration
    @ConditionalOnClass({ ApiResourceController.class, Swagger2Controller.class })
    public static class SwaggerWrapperFilterConfiguration {

        @Bean
        public WrapperResultResponseBodyAdvice.HandlerFilter swaggerFilter() {
            return returnType -> {
                Class<?> declaringClass = returnType.getDeclaringClass();
                return ApiResourceController.class.isAssignableFrom(declaringClass)
                        || Swagger2Controller.class.isAssignableFrom(declaringClass);
            };
        }

    }
}