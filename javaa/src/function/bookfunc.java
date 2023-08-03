package function;

import library.book;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class bookfunc implements Serializable {
   static Scanner cin=new Scanner(System.in);


    public static void writebook(ArrayList<book> b) {
      // ObjectOutputStream oos=null;
        try{
            FileOutputStream f=new FileOutputStream("book.txt");
          ObjectOutputStream  oos=new ObjectOutputStream(f);
            oos.writeObject(b);
            oos.close();
        }catch (FileNotFoundException e){

        }catch (IOException e){
            e.printStackTrace();
        }
       /* finally {
            try{
                if(oos!=null){
                    oos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }*/


    }
    public static ArrayList<book> readbook()  {
        ArrayList<book> b1=new ArrayList<>();
        try{
            FileInputStream f=new FileInputStream("book.txt");
           ObjectInputStream ois=new ObjectInputStream(f);
         b1=(ArrayList<book>)ois.readObject();
            ois .close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return b1;


    }
    public static void addbook() //添加
    {

        ArrayList<book> b=readbook();
        System.out.println("请输入要添加图书的编号");
        String isbn=cin.next();
        System.out.println("请输入要添加的图书名称");
        String name=cin.next();
        System.out.println("请输入要添加图书的作者");
        String author=cin.next();
        System.out.println("请输入要添加图书的出版社");
        String publish=cin.next();
        System.out.println("请输入要添加图书的出版日期");
        String publishdate=cin.next();
        System.out.println("请输入要添加图书的数量");
        int nums=cin.nextInt();
        System.out.println("请输入要添加图书的价格");
        double money=cin.nextDouble();
        boolean blog=false;
        for(int i=0;i<b.size();i++)
        {
            if(b.get(i).getIsbn().equals(isbn))
            {
                System.out.println("不好意思，该书已经存在，请重新输入");
                blog=true;
                addbook();
            }
        }
        if(blog==false){
        book books=new book(isbn,name,author,publish,publishdate,nums,money);
        b.add(books);
        writebook(b);
        System.out.println("添加图书成功");}

    }
    public static void findbook() //查询
    {

        ArrayList<book> b=readbook();
        while(true) {
            System.out.println("欢迎来到图书查询系统");
            System.out.println("请输入你的选择");
            System.out.println("0、退出查询");
            System.out.println("1、通过书号查找");
            System.out.println("2、通过书名查找");
            System.out.println("3、通过作者查找");
            System.out.println("请输入你的选择");
            int choose=cin.nextInt();
            switch (choose) {
                case 0:
                    return;
                case 1:
                    System.out.println("请输入要查找的书号");
                    boolean flag=false;
                    String isbn = cin.next();
                    for (int i = 0; i < b.size(); i++) {
                        if (b.get(i).getNumbers() != 0 &&b.get(i).getIsbn().equals(isbn)) {
                            System.out.println(b.get(i).getIsbn() + " " + b.get(i).getName() + " " + b.get(i).getAuthor() + " " + b.get(i).getNumbers());
                                            flag=true;

                        }
                    }
                    if(flag==false)
                    {
                        System.out.println("不好意思，没有这本书");
                    }
                    break;
                case 2:
                    System.out.println("请输入要查找的书名");
                    boolean flag1=false;
                    String name= cin.next();
                    for (int i = 0; i < b.size(); i++) {
                        if (b.get(i).getNumbers() != 0 &&b.get(i).getName().equals(name)) {
                            System.out.println(b.get(i).getIsbn() + " " + b.get(i).getName() + " " + b.get(i).getAuthor() + " " + b.get(i).getNumbers());
                            flag1=true;

                        }
                    }
                    if(flag1==false)
                    {
                        System.out.println("不好意思，没有这本书");
                    }
                    break;
                case 3:
                    System.out.println("请输入要查找的作者");
                    boolean flag2=false;
                    String author=cin.next();
                    for(int i=0;i<b.size();i++)
                    {
                        if(b.get(i).getNumbers()!=0 && b.get(i).getAuthor().equals(author))
                        {
                            System.out.println(b.get(i).getIsbn() + " " + b.get(i).getName() + " " + b.get(i).getAuthor() + " " + b.get(i).getNumbers());
                            flag2=true;

                        }

                    }
                    if(flag2==false)
                    {
                        System.out.println("不好意思，没有这本书");
                    }
                    break;
            }
        }
    }
    public static void printbook()//打印
    {
        ArrayList<book> b=readbook();

        if(b.size()!=0)
        {
            for(int i=0;i<b.size();i++)
            {
                Collections.sort(b);

           System.out.println(b.get(i).getIsbn() + " " + b.get(i).getName() + " " + b.get(i).getAuthor() + " " + b.get(i).getNumbers());

            }
        }
        else {
            System.out.println("不好意思，还未添加图书");
        }


    }
    public static void deletebook()//删除
    {
        ArrayList<book> b=readbook();
        System.out.println("请输入你要删除的书号");
        String isbn=cin.next();
        boolean flag3=false;
        for(int i=0;i<b.size();i++)
        {
            if(b.get(i).getIsbn().equals(isbn))
            {
                flag3=true;
                b.remove(i);

                writebook(b);
                System.out.println("删除成功");
            }
        }
        if(flag3==false)
        {
            System.out.println("不好意思，没有这本书");
        }
    }
    public static void changebook()
    {
        ArrayList<book> b=readbook();
        System.out.println("请输入想修改图书的书号");
        String isbn=cin.next();
        boolean flag4=false;

        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).getNumbers() != 0 &&b.get(i).getIsbn().equals(isbn)) {
                System.out.println("请输入修改图书的编号");
                String isbn2=cin.next();
                System.out.println("请输入修改图书名称");
                String name=cin.next();
                System.out.println("请输入修改图书的作者");
                String author=cin.next();
                System.out.println("请输入修改图书的出版社");
                String publish=cin.next();
                System.out.println("请输入修改图书的出版日期");
                String publishdate=cin.next();
                System.out.println("请输入修改图书的数量");
                int nums=cin.nextInt();
                System.out.println("请输入修改图书的价格");
                double money=cin.nextDouble();
                book b1=new book(isbn2,name,author,publish,publishdate,nums,money);
                b.set(i,b1);
                writebook(b);
                flag4=true;
                System.out.println("修改图书成功");

            }
        }
        if(flag4==false)
        {
            System.out.println("不好意思，没有这本书");
        }

    }
}
