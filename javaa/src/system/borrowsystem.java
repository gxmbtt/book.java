package system;

import java.util.Scanner;
import function.*;
public class borrowsystem {
    public void menu()
    {
        System.out.println("------欢迎来到借阅管理系统------");
        System.out.println("------0、退出借阅------");
        System.out.println("------1、借书------");
        System.out.println("------2、还书------");
        System.out.println("------3、打印借阅信息------");
    }
    public void bs()
    {
        while(true)
        {
            menu();
            System.out.println("请输入你的选择");
            Scanner cin=new Scanner(System.in);
            int choose=cin.nextInt();
            borrowfunc borr=new borrowfunc();
            switch (choose)
            {
                case 0:return;
                case 1:
                    borr.borrowb();
                    break;
                case 2:
                    borr.returnb();
                    break;
                case 3:
                    borr.printborrow();
                    break;

            }
        }
    }
}
