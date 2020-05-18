package ua.epicwasa.minibank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private short secureKey;
    private LocalDate expirationDate;
    private LocalDate creationDate;
    public Card(Account account, String name) {
        this.account = account;
        this.name = name;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "account_id")
    private Account account;

    private String name;


}
