package com.wt.learn;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: wtt
 * @Date: 2023/7/6 22:50
 * @Version: 1.0
 * @Description:
 */
@Slf4j
public class ConfigureLoader {
    private static final String CONFIG_FILE = "gateway.properties";

    private static final String ENV_PREFIX = "GATEWAY_";

    private static final String JVM_PREFIX = "gateway.";

    private static final ConfigureLoader INSTANCE = new ConfigureLoader();

    private Config config;

    private ConfigureLoader() {

    }

    public static ConfigureLoader getInstance() {
        return INSTANCE;
    }


    public static Config getConfig() {
        return INSTANCE.config;
    }

    /**
     * 运行参数->jvm参数-> 环境变量 -> 配置文件 -> 默认值
     *
     * @param args
     * @return
     */
    public Config load(String[] args) {
        config = new Config();

        loadFromConfigFile();

        loadFromEnv();

        loadFromJvm();

        loadFromArgs(args);

        return config;
    }

    private void loadFromArgs(String[] args) {
        if (args != null && args.length > 0) {
            Properties properties = System.getProperties();
            for (String arg : args) {
                if (arg.startsWith("--") && arg.contains("=")) {
                    properties.put(arg.substring(2, arg.indexOf("=")),
                            arg.substring(arg.indexOf("=") + 1));
                }
            }
            BeanUtil.copyProperties(properties, config);
        }
    }

    private void loadFromJvm() {
        Properties properties = System.getProperties();
        BeanUtil.copyProperties(properties, config);
    }

    private void loadFromEnv() {
        Map<String, String> errorMap = System.getenv();
        Properties properties = new Properties();
        properties.putAll(errorMap);
        BeanUtil.copyProperties(properties, config);
    }

    private void loadFromConfigFile() {
        InputStream inputStream = ConfigureLoader.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        if (null != inputStream) {
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                BeanUtil.copyProperties(properties, config);
            } catch (IOException e) {
                log.warn("loadFromConfigFile file:{} error", getConfig(), e);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
