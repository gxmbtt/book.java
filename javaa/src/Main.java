import library.book;
import library.manger;
import function.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import system.*;
public class Main {

    public void menu(){
        System.out.println("------欢迎来到图书管理系统------");
        System.out.println("------0、退出系统------");
        System.out.println("------1、管理员登录------");
        System.out.println("------2、普通用户------");
    }
    public void menu1()
    {
        System.out.println("------欢迎来到图书馆-------");
        System.out.println("------0、退出系统------");
        System.out.println("------1、借书或还书------");

    }
    public static void main(String[] args) {
        Main m=new Main();

        while(true)
        {
            m.menu();
            System.out.println("------请输入你的选择------");
            Scanner cin=new Scanner(System.in);
            int choose=cin.nextInt();
            booksystem book=new booksystem();
            borrowsystem borrow=new borrowsystem();
            readersystem reader=new readersystem();
            manger ma=new manger();
            switch (choose)
            {
                case 0:return;
                case 1:
                    ma.signin();
                    break;
                case 2:
                    m.person();
                    break;




            }
        }

    }
    public void person()
    {
        while(true)
        {
            menu1();
            System.out.println("------请输入你的选择------");
            Scanner cin=new Scanner(System.in);
            borrowsystem bo=new borrowsystem();
            int choose=cin.nextInt();
            switch (choose)
            {
                case 0:return;
                case 1:
                    bo.bs();
                    break;



            }
        }
    }
}

