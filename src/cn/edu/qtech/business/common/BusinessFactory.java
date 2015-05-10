package cn.edu.qtech.business.common;

import java.lang.reflect.Proxy;


public class BusinessFactory {

	public static Object getBusiness(@SuppressWarnings("rawtypes") Class T){
		Object ret = null;
		try{
			Object instance = T.newInstance();
		ret = Proxy.newProxyInstance(instance.getClass().getClassLoader(),
				instance.getClass().getInterfaces(),
				new MyAopProxy(T));
		}catch(Exception e){
			System.out.println("get business exception");
			e.printStackTrace();
		}
		return ret;
	}
}
