package Gardenia.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idAccount;

    @Column(columnDefinition = "VARCHAR(50) CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\\\.[A-Z|a-z]{2,4}$')", nullable = false)
    private String email;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String password;

    @Column(nullable = false)
    private Date birthDate;

    @Column(columnDefinition = "VARCHAR(5) CHECK (role in ('ADMIN', 'USER', 'EMPLO'))")
    private String role;

    @OneToOne(mappedBy = "account")
    private Client client;
}
