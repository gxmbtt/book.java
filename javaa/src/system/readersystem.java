package system;

import function.readerfunc;

import java.util.Scanner;

public class readersystem {
    public void menu()
    {
        System.out.println("------欢迎来到读者信息管理系统------");
        System.out.println("------0、退出系统------");
        System.out.println("------1、添加读者------");
        System.out.println("------2、查找读者------");
        System.out.println("------3、修改读者------");
        System.out.println("------4、删除读者------");
        System.out.println("------5、打印读者------");
    }
    public void rs()
    {
        while(true)
        {
            menu();
            System.out.println("------请输入你的选择------");
            Scanner cin=new Scanner(System.in);
            int choose=cin.nextInt();
            readerfunc re=new readerfunc();
            switch (choose)
            {
                case 0:return;
                case 1:
                    re.addreader();
                    break;
                case 2:
                    re.findreader();
                    break;
                case 3:
                    re.changereader();
                    break;
                case 4:
                    re.deletereader();
                    break;
                case 5:
                    re.printreader();
                    break;
            }

        }
    }
}
