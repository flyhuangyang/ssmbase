package com.ssm.pub;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorMain {
	public static void main(String[] args) {
		System.out.println("浠栬锛氬垱寤哄紑濮嬩簡锛侊紒锛�");
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 璇诲彇閰嶇疆鏂囦欢
		File configFile = new File("src/main/java/com/ssm/pub/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(configFile);

			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator;
			try {
				myBatisGenerator = new MyBatisGenerator(config, callback,
						warnings);
				myBatisGenerator.generate(null);
				// 鎵撳嵃缁撴灉
				for (String str : warnings) {
					System.out.println(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
		System.out.println("浠栬锛氬垱寤哄畬浜嗭紒锛侊紒");
	}
}