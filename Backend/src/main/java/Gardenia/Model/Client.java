package Gardenia.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import Gardenia.Util.ClientKey;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @EmbeddedId
    private ClientKey clientKey;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    private String names;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    private String lastnames;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String phoneNumber;

    @JsonManagedReference("client-address")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client")
    private List<Address> addresses;

    @JsonManagedReference("client-request")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "client")
    private List<Request> requests;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;
}
