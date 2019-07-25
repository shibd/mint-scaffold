# mint-scaffold
Spring Boot快速开发脚手架

相关文档请移步：https://dfocus.yuque.com/research-development/dr0yl5/sskkhu

# 快速入门
1. 配置Maven仓库为公司私服，参见文章：https://dfocus.yuque.com/research-development/dr0yl5/gqphaf
2. 使用下述命令快速生成一个开发脚手架，-DgroupId和-DartifactId自己根据项目自定义。
```
mvn -e archetype:generate \
 -DarchetypeGroupId=com.dfocus.archetypes \
 -DarchetypeArtifactId=mint-scaffold \
 -DarchetypeVersion=3.2-SNAPSHOT \
 -Dversion=1.0-SNAPSHOT \
 -DgroupId=com.dfocus.hello \
 -DartifactId=hello \
 -DinteractiveMode=false
```

# 版本Release

## 3.2-SNAPSHOT版本 - doing
- 引入mybatis-plus
- 增加格式化代码插件
- 更换maven父包
- 优化工程代码使用规范
- 引入XXJob

## [3.1-RELEASE](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/3.1-RELEASE)
- 微服务打通注册中心(ribbon,eureka)
- 完善单元测试写法
- 规范logback
- 引入内存kafka,完善对kafka使用测试
- 修改demo表名


## [3.0](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/3.0)
- 集成统一脚本
- 完善接口测试
- 完善单元测试流程

## [2.0](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/2.0)
- 调整包结构
- 确定服务间调用过程
- 完善代码

## [1.0](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/1.0)
- 初步稳定
