package com.psfd.springboot.eshop.test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MpGenerator {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("admin");
        globalConfig.setOutputDir("");
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        generator.setGlobalConfig(globalConfig);





    }
}
