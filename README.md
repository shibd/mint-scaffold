# mint-scaffold
![][license-url]
Java开发脚手架，快速生成一个Spring Boot工程。默认集成SpringBoot，Cloud，Kafka，内存数据库，MybatisPlus，Docker，单元测试方案等。

相关文档请移步：[wiki](https://github.com/shibd/mint-scaffold/wiki)

## Features
- 微服务化
- 模块分治
- 最佳集成
- 统一技术栈
- 容器集成
- 规范单元测试

## 快速入门
1. 配置好Maven, 确保可以使用`mvn`命令。
2. 使用下述命令快速生成一个工程，-DgroupId和-DartifactId自己根据项目自定义。（-DartifactId为工程名，建议格式小写 xxx-xxx，不建议大小写驼峰）
```
mvn archetype:generate \
 -DarchetypeGroupId=io.github.shibd \
 -DarchetypeArtifactId=mint-scaffold \
 -DarchetypeVersion=1.0-SNAPSHOT \
 -Dversion=1.0-SNAPSHOT \
 -DgroupId=com.baozi.hello \
 -DartifactId=hello \
 -DinteractiveMode=falsee
```
3. 启动工程:
```
sh hello/tools/build-restart
```
4. 访问swagger测试: http://127.0.0.1:8080/hello/swagger-ui.html
5. 访问h2-console查看数据: http://127.0.0.1:8080/hello/h2-console/
- logback默认日志在 ./log/default-app.log，请自定义修改，在application/resource/xml修改logback.xml的LOG_APP_NAME和LOG_PATH_ROOT值


