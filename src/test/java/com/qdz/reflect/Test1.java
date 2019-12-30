package com.qdz.reflect;

import com.qdz.test.service.impl.GoodsServiceImpl;
import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 测试反射读取的顺序关系
 *
 * @author authorZhao
 * @date 2019/12/25
 */
public class Test1 {

    @Test
    public void test1(){

        Method[] methods = GoodsServiceImpl.class.getMethods();
        System.out.println(Arrays.toString(methods));
    }

    public static boolean isNumber(String str) {
        String regex = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"; // 判断小数点后2位的数字的正则表达式
        return str.matches(regex);
    }

    public static void main(String[] args) {

        Double as = 12.223 *100;
        System.out.println(as.intValue());

        boolean a = isNumber("100.0");
        boolean b = isNumber("1552.66");
        boolean c = isNumber("156161.666");
        boolean d = isNumber("415665");
        boolean e = isNumber("-151");

        boolean f = isNumber("1891651,6");
        boolean g = isNumber("0.001");
        boolean h = isNumber("");
        boolean i = isNumber("1.");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("==========================");
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        System.out.println(i);

        Double amountD = Double.parseDouble("1.");
        Long fronezAmount = BigDecimal.valueOf(amountD * 100).toBigInteger().longValue();
        System.out.println(amountD);
        System.out.println(fronezAmount);
    }

}
