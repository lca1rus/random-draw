package org.example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * @author：lcarus
 * @date： ${DATE} ${TIME}
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int MAX=95;
        int MIN=1;
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=1;i<=MAX;i++){
                hashSet.add(i);
        }
        String word;
        System.out.println("开始抽签");
        while (!hashSet.isEmpty()){
            //提示输入数据
            System.out.println("请输入任意内容（输入con就继续，exit就退出，否则继续无操作会循环）：");
            //键盘接收数据
            word=scanner.nextLine();
            //判断接收的数据是否为"exit"
            if (word.equals("exit")) {
                //如果是，提示退出输入
                System.out.println("退出输入！");
                //跳出循环
                break;
            }else if (word.equals("con")){//如果不是，提示继续输入
                Random rand = new Random();
                while (true){//拿到hash中存在的随机数
                    int randNumber=rand.nextInt(MAX - MIN + 1) + MIN;
                    if (hashSet.contains(randNumber)){//1、拿出还存在的数
//                        System.out.println(randNumber);
//                        hashSet.remove(randNumber);
//                        break;
                        System.out.println("确定是这个数吗？："+randNumber);
                        System.out.println("确定请输入yes,不确定输入no");
                        String  word1=scanner.nextLine();
                        if (word1.equals("yes")){//2、确定删除操作
                            hashSet.remove(randNumber);
                            System.out.println("已经成功抽到数字");
                            break;
                        }else if (word1.equals("no")){
                            System.out.println("重新换号");
                            break;
                        }
                    }
                }
            }
        }
    }
}