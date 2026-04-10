
package model;

import java.math.BigDecimal;

public class Student {
    private int id;
    private String name;
    private String course;
    private BigDecimal fee;

    // ✅ Photo (nom du fichier)
    private String photo;

    public Student() {}

    public Student(String name, String course, BigDecimal fee) {
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public Student(String name, String course, BigDecimal fee, String photo) {
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.photo = photo;
    }

    public Student(int id, String name, String course, BigDecimal fee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public Student(int id, String name, String course, BigDecimal fee, String photo) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.photo = photo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public BigDecimal getFee() { return fee; }
    public void setFee(BigDecimal fee) { this.fee = fee; }

    // ✅ Getter/Setter photo (OBLIGATOIRE pour ${s.photo})
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
}
