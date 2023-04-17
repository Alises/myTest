package com.example.demo.fastjsontest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;

/**
 * Create By Gq
 * 2023/4/6
 */
public class FastJsonTest {
    public static void main(String[] args) {
//        ParserConfig.getGlobalInstance().setSafeMode(true);
        ModalA a = new ModalA();
        a.setA(1);
        a.setB(2);
        a.setC("c");
        a.setD("d");
        String s = JSON.toJSONString(a);
//        String s = "{\"@type\":\"com.example.demo.fastjsontest.ModalA\",\"a\":1,\"b\":2,\"c\":\"c\",\"d\":\"d\"}";
        System.out.println(s);
        ModalA modalA = JSON.parseObject(s, ModalA.class);
        Object parse = JSON.parse(s);
//        ModalA modalA = JSON.parseObject(s, ModalA.class);
        System.out.println(modalA);
        System.out.println(parse);
    }
}
