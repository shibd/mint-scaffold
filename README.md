# mint-scaffold
Spring Boot快速开发脚手架

相关文档请移步：[wiki](https://www.yuque.com/docs/share/52308ccf-8450-46bf-8af9-f278ebc33248)

# 快速入门
1. 使用下述命令快速生成一个开发脚手架，-DgroupId和-DartifactId自己根据项目自定义。
```
mvn -e archetype:generate \
 -DarchetypeGroupId=com.baozi.archetypes \
 -DarchetypeArtifactId=mint-scaffold \
 -DarchetypeVersion=3.2-SNAPSHOT \
 -Dversion=1.0-SNAPSHOT \
 -DgroupId=com.baozi.hello \
 -DartifactId=hello \
 -DinteractiveMode=false
```

# 版本Release
- 引入mybatis-plus
- 增加格式化代码插件
- 更换maven父包
- 优化工程代码使用规范
- 引入Docker,重构工程脚本
- 引入XXJob
- 微服务打通注册中心(ribbon,eureka)
- 完善单元测试写法
- 规范logback
- 引入内存kafka,完善对kafka使用测试
- 修改demo表名
- 集成统一脚本
- 完善接口测试
- 完善单元测试流程
