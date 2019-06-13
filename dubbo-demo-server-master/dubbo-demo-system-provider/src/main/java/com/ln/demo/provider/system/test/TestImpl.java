package com.ln.demo.provider.system.test;

import com.ln.demo.api.system.test.Test;

public class TestImpl implements Test{

	@Override
	public String sayHello() {
		System.err.println("------------------------------------------");
		return "hello world";
	}

}
