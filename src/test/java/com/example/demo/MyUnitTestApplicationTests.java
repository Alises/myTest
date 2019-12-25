package com.example.demo;


import com.example.demo.design.prototype.PrototypeTest;

public class MyUnitTestApplicationTests {

	public static void main(String[] args) throws CloneNotSupportedException {
		PrototypeTest zhangSan = new PrototypeTest(12, "zhangsan");
		zhangSan.display();
		PrototypeTest liSi = (PrototypeTest)zhangSan.clone();
		liSi.setName("lisi");
		liSi.display();
	}
}