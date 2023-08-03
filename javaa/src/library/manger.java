package library;

import system.booksystem;
import system.borrowsystem;
import system.readersystem;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;

public class manger implements Serializable{
private int id;
private int key;

    public manger(int id, int key) {
        this.id = id;
        this.key = key;
    }
    public manger(){}

    public int getId() {
        return id;
    }

    public int getKey() {
        return key;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public void signin() {
        System.out.println("请输入账号和密码");
        Scanner cin=new Scanner(System.in);


       String n= cin.nextLine();
       String m=cin.next();
      try {
          File f = new File("D:\\javaidea\\javaa\\src\\library/manger.txt");
          FileReader fr = new FileReader(f);
          BufferedReader br = new BufferedReader(fr);
          String str = br.readLine();
          String str1 = br.readLine();
          br.close();
          fr.close();

          if (n.equals(str) && m.equals(str1)) {
              System.out.println("登录成功");
              mr();
          } else {
              System.out.println("账号或密码错误，请重新输入");
              signin();
          }
      }

      catch (IOException e)
      {
          e.printStackTrace();
      }


    }
    public void menu()
    {
        System.out.println("------欢迎来到管理员页面------");
        System.out.println("------0、退出页面------");
        System.out.println("------1、管理图书------");
        System.out.println("------2、管理读者------");
        System.out.println("------3、管理借阅信息------");
    }
    public void mr()  {

        while(true)
        {
            menu();
            System.out.println("------请输入你的选择------");
            Scanner cin=new Scanner(System.in);
            int choose=cin.nextInt();
            booksystem book=new booksystem();
            borrowsystem borrow=new borrowsystem();
            readersystem reader=new readersystem();
            switch (choose)
            {
                case 0:return;
                case 1:
                    book.bs();
                    break;
                case 2:
                    reader.rs();
                    break;
                case 3:
                    borrow.bs();
                    break;

            }
        }
    }
}

