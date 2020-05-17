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
public class LoanContract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double initialSum;

    @Column(updatable = false)
    private LocalDate dateOfSigning;

    private LocalDate dateOfExpiration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "rate")
    private Rate rate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "customer_account_id")
    private Account account;

    private short paymentFrequency; //how many payments a year. example: 12, 1 ...

    private boolean preRepay;



}
