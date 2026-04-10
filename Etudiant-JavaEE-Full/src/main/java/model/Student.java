package model;

import java.math.BigDecimal;

public class Student {
    private int id;
    private String name;
    private String course;
    private BigDecimal fee;
    private String photoPath;
     private String email;   // ✅ ajoute ceci

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public BigDecimal getFee() { return fee; }
    public void setFee(BigDecimal fee) { this.fee = fee; }

    public String getPhotoPath() { return photoPath; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }
}
