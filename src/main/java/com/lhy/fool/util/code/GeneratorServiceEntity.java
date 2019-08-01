package com.lhy.fool.util.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 测试生成代码
 * @author 98403
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        String dbUrl = "jdbc:mysql://47.101.162.124:3306/makeforyou?useUnicode=true&characterEncoding=UTF-8";
        //String dbUrl = "jdbc:oracle:thin:@10.230.13.23:1521:fin";
        String packageName = "com.lhy.fool";
        String modelName = "admin";
        String [] tables = {"t_user"};
        generateByTables(dbUrl,projectPath ,packageName,modelName, tables);
    }


    /**
     * 反向构建表
     * @param dbUrl  url
     * @param projectPath 工程路径
     * @param packageName  包名
     * @param moduleName   模块名
     * @param tableNames  表名  支持多个表
     */
    private static void generateByTables(String dbUrl,String projectPath, String packageName,String moduleName, String... tableNames) {
        // =================================== [数据源配置] ===================================
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.ORACLE)
                .setUrl(dbUrl)
                .setDbType(DbType.MYSQL)
                .setUsername("lhy")
                .setPassword("1223")
                .setDriverName("com.mysql.cj.jdbc.Driver");

        // =================================== [策略配置] ===================================
        StrategyConfig strategyConfig = new StrategyConfig();
        // 生成lombok
        strategyConfig.setEntityLombokModel(true);
        //下划线
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //无改变
        strategyConfig.setTablePrefix("t_");
        //跳过视图
        strategyConfig.setSkipView(true);
        strategyConfig.setInclude(tableNames);
        strategyConfig.setLogicDeleteFieldName("status");

        // =================================== [全局配置] ===================================
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setAuthor("lhy")
                .setOutputDir(projectPath + "/src/main/java")
                //开启二级缓存
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setFileOverride(true);

        // =================================== [包配置] ===================================
        PackageConfig packageConfig = new PackageConfig();
        //包名
        packageConfig.setParent(packageName);
        //模块名
        packageConfig .setModuleName(moduleName);

        // =================================== [自定义配置] ===================================
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity  (mp 默认模板)
         String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        // =================================== [配置模板] ===================================
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);

        // =================================== [构建] ===================================
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setCfg(cfg)
                .setTemplate(templateConfig)
                .execute();
    }

}