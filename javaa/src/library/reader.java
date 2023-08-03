package library;

import java.io.Serializable;

public class reader implements Serializable,Comparable<reader> {
    private int id;
    private String name;
    private String college;
    private String profession;

    public reader(int id, String name, String college, String profession) {
        this.id = id;
        this.name = name;
        this.college = college;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCollege() {
        return college;
    }

    public String getProfession() {
        return profession;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    @Override
    public int compareTo(reader o) {
        return this.id-o.id;
    }
}
