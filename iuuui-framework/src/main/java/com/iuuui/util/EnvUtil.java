package com.iuuui.util;

import org.apache.commons.lang3.EnumUtils;

import java.util.Map;

public class EnvUtil {

	private static final String ENV_STR = getEnvStr0();
	private static final Env ENV = getEnv0();
	
	public enum Env {

		dev,test,gray,prod;	
		private static Map<String, Env> map = EnumUtils.getEnumMap(Env.class);
		
		public static Env getEnv(String env) {
			return map.get(env);
		}

	}

	public static Env getEnv() {
		return ENV;
	}
	
	private static Env getEnv0() {	
		String env = getEnvStr();
		return Env.getEnv(env);
	}
	
	
	
	public static String getEnvStr() {
		return ENV_STR;
	}
	
	private static String getEnvStr0() {

		String env = System.getProperty("ENV");
		if (env == null) {
			env = System.getenv("ENV");
		}

		if (env == null) {
			env = "dev";
		}
		return env;

	}
	
	public static void main(String[] args) {
		System.out.println(EnvUtil.getEnv());
	}

}
