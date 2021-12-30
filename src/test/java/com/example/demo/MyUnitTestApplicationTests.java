package com.example.demo;


import com.example.demo.beans.InterfaceTest;
import com.example.demo.beans.ParentClass;

public class MyUnitTestApplicationTests {

	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		add(p.getAge());
	}

	public static void interfaceTest(InterfaceTest interfaceTest) {

	}

	public static void add(int i) {
		System.out.println("i = " + i);
	}
}