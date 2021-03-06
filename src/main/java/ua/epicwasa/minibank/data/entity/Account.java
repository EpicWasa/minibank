package ua.epicwasa.minibank.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "currency_id")
    private Currency currency;

    private String name;

    private LocalDate creationDate;

    public Account(double amount, User user, Currency currency) {
        this.amount = amount;
        this.user = user;
        this.currency = currency;
    }
}
