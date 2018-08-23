package com.jusfoun.ssz.web.crowd.controller;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-08-06 10:34
 **/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class MainTestController {
//
//
//
//    @Autowired
//    ZbAccountService zbAccountService;
//
//    @Test
//    public void sendMsg() throws InterruptedException {
//
//
//
//    }
//
//
//
//}


public class MainTestController{

    String name;

    //使用了static修饰country，那么这时候country就是一个共享的数据。

    static	String  country  = "中国";	//国籍

    volatile Integer num;

    //构造函数
    public MainTestController(String name, Integer num){
        this.name = name;
        this.num = num;
    }
}

class Demo9 {

    public static void main(String[] args) {
        MainTestController s1 = new MainTestController("张三", 123);
        MainTestController s2 = new MainTestController("陈七", 456);

        s1.country = "小日本";
//        MainTestController.country = "没过";

        int vn = s2.num - s1.num;
        System.out.println(vn);
        System.out.println("姓名：" + s1.name + " 国籍：" + s1.country); //  小日本
        System.out.println("姓名：" + s2.name + " 国籍：" + s2.country); // 小日本
        System.out.println("姓名：" + s2.name + " 国籍：" + MainTestController.country); // 小日本
    }
}
