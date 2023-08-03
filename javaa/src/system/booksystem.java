package system;

import java.util.Scanner;
import function.*;
public class booksystem {
    public void menu()
    {
        System.out.println("------欢迎来到图书信息管理系统------");
        System.out.println("------0、退出系统------");
        System.out.println("------1、添加图书------");
        System.out.println("------2、查找图书------");
        System.out.println("------3、修改图书------");
        System.out.println("------4、删除图书------");
        System.out.println("------5、打印图书------");
    }
    public void bs()
    {

        while(true)
        {
            menu();
            System.out.println("------请输入你的选择------");
            Scanner cin=new Scanner(System.in);
            int choose=cin.nextInt();
            bookfunc book=new bookfunc();
            switch (choose)
            {
                case 0:return;
                case 1:
                    book.addbook();
                    break;
                case 2:
                    book.findbook();
                    break;
                case 3:
                    book.changebook();
                    break;
                case 4:
                    book.deletebook();
                    break;
                case 5:
                    book.printbook();
                    break;
            }
        }
    }
}
