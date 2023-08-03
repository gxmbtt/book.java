package library;

import java.io.Serializable;
import java.util.Scanner;

public class book implements Serializable,Comparable<book>{
  private String isbn;
  private String name;
  private String author;
  private String publish;
  private String publishdate;
  private int numbers;
  private double money;

    public book(String isbn, String name, String author, String publish, String publishdate, int numbers, double money) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.publishdate = publishdate;
        this.numbers = numbers;
        this.money = money;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublish() {
        return publish;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public int getNumbers() {
        return numbers;
    }

    public double getMoney() {
        return money;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
   public int compareTo(book o) {
        return this.isbn.compareTo(o.isbn);
    }



}
