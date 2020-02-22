# hello-mybatis
framework mybatis helloworld.

## 步骤
* 添加依赖包：mysql-connector-java，mybatis，junit 
* mybatis全局配置：配置数据源，sql映射文件引入
* mybatis的sql映射文件：xxxMapper.xml
* java代码：定义实体类，Dao接口

## 遇到问题
* 项目没有引入mysql驱动包
* mybatis配置文件注册不到sql映射文件    // 因为resultType没有加包名

