# mint-scaffold
Spring Boot快速开发脚手架
相关文档请移步：https://dfocus.yuque.com/research-development/dr0yl5/sskkhu/edit

# 快速入门
1. 配置Maven仓库为公司私服，参见文章：https://dfocus.yuque.com/research-development/dr0yl5/gqphaf
2. 使用下述命令快速生成一个开发脚手架，-DgroupId和-DartifactId自己根据项目自定义。
```
mvn -e archetype:generate \
 -DarchetypeGroupId=com.dfocus.archetypes \
 -DarchetypeArtifactId=mint-scaffold \
 -DarchetypeVersion=2.0-SNAPSHOT \
 -Dversion=2.0 \
 -DgroupId=com.dfocus.hello \
 -DartifactId=hello \
 -DinteractiveMode=false
```

# 版本Release

## 2.0-SNAPSHOT版本
- doing

## [2.0](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/2.0)

## [1.0](https://gitlab.dfocus.co/frameworks/mint-scaffold/tags/1.0)