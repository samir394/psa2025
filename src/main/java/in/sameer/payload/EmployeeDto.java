package in.sameer.payload;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class EmployeeDto {

    private Long id;


    @NotBlank
    @Size(min =3, message = "At least 3 char required")
    private String name;


    @Email
    private String emaild;

    @Size(min = 10,max =10, message = "should be 10 digits")
    private String mobile;
    private Date date;

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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
