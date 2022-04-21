package FactoryMethod;

import java.util.Scanner;

public class Order {
    static HotPot hotPot;
    public void Initialize(String str){
        if(str.equals("成都羊肉火锅")){
            hotPot = new ChengduMuttonHotPot();
        }else if(str.equals("重庆鸳鸯火锅")){
            hotPot = new ChongqingYuanyangHotPot();
        }else{
            System.out.println("没有！");
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Order order = new Order();
        order.Initialize(str);
        hotPot.AddOtherMaterial();
        hotPot.AddMainMaterial();
    }
}
