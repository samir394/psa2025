package in.sameer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)

   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "emai_ld", nullable = false, unique = true)
    private String emaild;

    @Column(name = "mobile", nullable = false, unique = true ,length=10)
    private String mobile;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmaild() {
        return emaild;
    }
    public void setEmaild(String emaild) {
        this.emaild = emaild;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}