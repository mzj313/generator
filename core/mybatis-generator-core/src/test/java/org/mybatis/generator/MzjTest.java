package org.mybatis.generator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MzjTest {

	//生成到src下了
	@Test
	public void getGenFiles() {
		try {
			String configFile = "/scripts/ordersConfig.xml";
//			String configFile = "/scripts/genConfig.xml";
			List<String> warnings = new ArrayList<String>();
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(JavaCodeGenerationTest.class.getResourceAsStream(configFile));
			    
			DefaultShellCallback shellCallback = new DefaultShellCallback(true);
			
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
			myBatisGenerator.generate(null, null, null, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
