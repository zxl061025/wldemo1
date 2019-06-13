package com.ln.demo.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebApp implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.err.println(".......................................");
		ServletContextListener.super.contextInitialized(sce);
	}
	
}
