package function;

import library.book;
import library.*;
import java.io.*;
import function.*;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class borrowfunc {
    static Scanner cin = new Scanner(System.in);

    public static void writeborrow(ArrayList<borrowbook> bb) {
        // ObjectOutputStream oos=null;
        try {
            FileOutputStream f = new FileOutputStream("D:\\javaidea\\javaa/borrowbook.txt");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(bb);
            oos.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
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

    public static ArrayList<borrowbook> readborrow() {
        ArrayList<borrowbook> b1 = new ArrayList<>();
        try {
            FileInputStream f = new FileInputStream("D:\\javaidea\\javaa/borrowbook.txt");
            ObjectInputStream ois = new ObjectInputStream(f);
            b1 = (ArrayList<borrowbook>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return b1;


    }

    public String getdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date now = new Date();
        return sdf.format(now);

    }

    public String getruturn() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(c.MONTH, +1);
        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        return sdf.format(time);
    }

    public void borrowb() {

        ArrayList<borrowbook> br = readborrow();
        bookfunc book = new bookfunc();
        ArrayList<book> arrb = book.readbook();
        readerfunc reader = new readerfunc();
        ArrayList<reader> arrr = reader.readreader();
        System.out.println("------现在已有的读者------");
        reader.printreader();
        System.out.println("------请输入学号------");
        int id = cin.nextInt();
        boolean flag = false;
        boolean flag1 = false;
        for (int i = 0; i < arrr.size(); i++) {
            if (arrr.get(i).getId() == id) {
                flag = true;
                System.out.println("------现在已有的图书------");
                book.printbook();
                System.out.println("------请输入书号------");
                String isbn = cin.next();
                for (int j = 0; j < arrb.size(); j++) {
                    if (arrb.get(j).getIsbn().equals(isbn)) {
                        flag1 = true;
                        //arrb.get(j).setNumbers(arrb.get(j).getNumbers()-1);
                        book bp = new book(arrb.get(j).getIsbn(), arrb.get(j).getName(), arrb.get(j).getAuthor(), arrb.get(j).getPublish(), arrb.get(j).getPublishdate(), arrb.get(j).getNumbers() - 1, arrb.get(j).getMoney());
                        arrb.set(j, bp);
                        book.writebook(arrb);
                        borrowbook b = new borrowbook(id, arrr.get(i).getName(), isbn, arrb.get(i).getName(), getdate(), getruturn(), "0");
                        br.add(b);
                        writeborrow(br);
                        System.out.println("------借书成功------");

                    }

                }
            }
        }
        if (flag == false) {
            System.out.println("不好意思，请先添加读者信息");
        } else if (flag1 == false) {
            System.out.println("不好意思，没有这本书");
        }

    }

    public void printborrow() {
        ArrayList<borrowbook> br = readborrow();
        if (br.size() != 0) {
            for (int i = 0; i < br.size(); i++) {
                System.out.println(br.get(i).getId() + " " + br.get(i).getRname() + " " + br.get(i).getIsbn() + " " + br.get(i).getBname() + " " + br.get(i).getBorrowdate() + " " + br.get(i).getShoulddate() + " " + br.get(i).getReturndate());
            }
        } else {
            System.out.println("不好意思，没人借书");
        }
    }

    public void returnb() {
        ArrayList<borrowbook> br = readborrow();
        bookfunc book = new bookfunc();
        ArrayList<book> arrb = book.readbook();
        readerfunc reader = new readerfunc();
        ArrayList<reader> arrr = reader.readreader();
        System.out.println("------现在已有的借阅信息------");
        printborrow();
        System.out.println("------请输入学号------");
        int id = cin.nextInt();
        System.out.println("------请输入书号------");
        String isbn = cin.next();
        for (int i = 0; i < br.size(); i++) {
            if (br.get(i).getId() == id && br.get(i).getIsbn().equals(isbn)) {

                borrowbook bo = new borrowbook(br.get(i).getId(), br.get(i).getRname(), br.get(i).getIsbn(), br.get(i).getBname(), br.get(i).getBorrowdate(), br.get(i).getShoulddate(), getdate());
                br.set(i, bo);
                writeborrow(br);

            }
        }
        for (int j = 0; j < arrb.size(); j++) {
            if (arrb.get(j).getIsbn().equals(isbn)) {
                // arrb.get(j).setNumbers(arrb.get(i).getNumbers()+1);
                book b = new book(arrb.get(j).getIsbn(), arrb.get(j).getName(), arrb.get(j).getAuthor(), arrb.get(j).getPublish(), arrb.get(j).getPublishdate(), arrb.get(j).getNumbers() + 1, arrb.get(j).getMoney());
                arrb.set(j, b);
                book.writebook(arrb);
                System.out.println("还书成功");

            }
        }
    }
}

