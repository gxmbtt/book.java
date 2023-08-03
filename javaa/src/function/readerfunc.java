package function;

import library.book;
import library.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class readerfunc {
    static Scanner cin=new Scanner(System.in);
    public static void writereader(ArrayList<reader> r) {

        try{
            FileOutputStream f=new FileOutputStream("D:\\javaidea\\javaa\\src\\function/reader.txt");
            ObjectOutputStream oos=new ObjectOutputStream(f);
            oos.writeObject(r);
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
    public static ArrayList<reader> readreader()  {
        ArrayList<reader> r1=new ArrayList<>();
        try{
            FileInputStream f=new FileInputStream("D:\\javaidea\\javaa\\src\\function/reader.txt");
            ObjectInputStream ois=new ObjectInputStream(f);
            r1=(ArrayList<reader>)ois.readObject();
            ois .close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return r1;
    }
    public static void addreader()
    {
        ArrayList<reader> rlist=readreader();
        System.out.println("请输入要添加的学号");
        int id=cin.nextInt();
        System.out.println("请输入要添加的姓名");
        String name=cin.next();
        System.out.println("请输入要添加的学院");
        String college=cin.next();
        System.out.println("请输入要添加的专业班级");
        String pro=cin.next();
        boolean flag=false;
        for(int i=0;i<rlist.size();i++)
        {
            if(rlist.get(i).getId()==id)
            {
                System.out.println("不好意思，该读者已经存在，请重新输入");
                flag=true;
                addreader();
            }
        }
        if(flag==false)
        {
            reader r=new reader(id,name,college,pro);
            rlist.add(r);
            writereader(rlist);
            System.out.println("添加读者成功");
        }

    }
    public static void findreader()
    {
        ArrayList<reader> rlist=readreader();
        while(true)
        {
            System.out.println("欢迎来到读者查询系统");
            System.out.println("请输入你的选择");
            System.out.println("0、退出查询");
            System.out.println("1、通过学号查找");
            System.out.println("2、通过姓名查找");
            System.out.println("3、通过专业班级查找");
            System.out.println("请输入你的选择");
            int choose=cin.nextInt();
            switch (choose)
            {
                case 0:return;
                case 1:
                    System.out.println("请输入要查找的学号");
                    int id=cin.nextInt();
                    boolean flag=false;
                    for(int i=0;i<rlist.size();i++)
                    {
                        if(rlist.get(i).getId()==id)
                        {
                            System.out.println(rlist.get(i).getId()+" "+rlist.get(i).getName()+" "+rlist.get(i).getCollege()+" "+rlist.get(i).getProfession());
                            flag=true;
                        }
                    }
                    if(flag==false)
                    {
                        System.out.println("不好意思，没有这个人");
                    }
                    break;
                case 2:
                    System.out.println("请输入要查找的姓名");
                    String name=cin.next();
                    boolean flag1=false;
                    for(int i=0;i<rlist.size();i++)
                    {
                        if(rlist.get(i).getName().equals(name))
                        {
                            System.out.println(rlist.get(i).getId()+" "+rlist.get(i).getName()+" "+rlist.get(i).getCollege()+" "+rlist.get(i).getProfession());
                            flag1=true;
                        }
                    }
                    if(flag1==false)
                    {
                        System.out.println("不好意思，没有这个人");
                    }
                    break;
                case 3:
                    System.out.println("请输入要查找的专业班级");
                    String cp=cin.next();
                    boolean flag2=false;
                    for(int i=0;i<rlist.size();i++)
                    {
                        if(rlist.get(i).getProfession().equals(cp))
                        {
                            System.out.println(rlist.get(i).getId()+" "+rlist.get(i).getName()+" "+rlist.get(i).getCollege()+" "+rlist.get(i).getProfession());
                            flag2=true;
                        }
                    }
                    if(flag2==false)
                    {
                        System.out.println("不好意思，没有这个人");
                    }
                    break;
            }
        }
    }
    public static void printreader()
    {
        ArrayList<reader> rlist=readreader();
        if(rlist.size()!=0)
        {
            for(int i=0;i<rlist.size();i++)
            {
                Collections.sort(rlist);
                System.out.println(rlist.get(i).getId()+" "+rlist.get(i).getName()+" "+rlist.get(i).getCollege()+" "+rlist.get(i).getProfession());
            }
        }
        else
        {
            System.out.println("不好意思，还未添加读者");
        }
    }
    public static void deletereader()
    {
        ArrayList<reader> rlist=readreader();
        System.out.println("请输入要删除的学号");
        int id=cin.nextInt();
        boolean flag=false;
        for(int i=0;i<rlist.size();i++)
        {
            if(rlist.get(i).getId()==id)
            {
                flag=true;
                rlist.remove(i);
                writereader(rlist);
                System.out.println("删除成功");
            }
        }
        if(flag==false)
        {
            System.out.println("不好意思，没有这个人");
        }
    }
    public static void changereader()
    {
        ArrayList<reader> rlist=readreader();
        System.out.println("请输入你要修改的学号");
        int id1=cin.nextInt();
        boolean flag=false;
        for(int i=0;i<rlist.size();i++)
        {
            if(rlist.get(i).getId()==id1)
            {
                System.out.println("请输入要修改的学号");
                int id=cin.nextInt();
                System.out.println("请输入要修改的姓名");
                String name=cin.next();
                System.out.println("请输入要修改的学院");
                String college=cin.next();
                System.out.println("请输入要修改的专业班级");
                String pro=cin.next();
                reader r=new reader(id,name,college,pro);
                rlist.set(i,r);
                writereader(rlist);
                flag=true;
                System.out.println("修改读者成功");
            }
        }
        if(flag==false)
        {
            System.out.println("不好意思，没有这个人");
        }
    }
}
