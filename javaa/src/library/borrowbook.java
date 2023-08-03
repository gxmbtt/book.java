package library;

import java.io.Serializable;

public class borrowbook implements Serializable {
    private int id;
    private String rname;
    private String isbn;
    private String bname;
    private String borrowdate;
    private String shoulddate;
    private String returndate;

    public borrowbook(int id, String rname, String isbn, String bname, String borrowdate, String shoulddate,String returndate) {
        this.id = id;
        this.rname = rname;
        this.isbn = isbn;
        this.bname = bname;
        this.borrowdate = borrowdate;
        this.shoulddate = shoulddate;
        this.returndate=returndate;

    }

    public int getId() {
        return id;
    }

    public String getRname() {
        return rname;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBname() {
        return bname;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public String getShoulddate() {
        return shoulddate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public void setShoulddate(String shoulddate) {
        this.shoulddate = shoulddate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }
}
