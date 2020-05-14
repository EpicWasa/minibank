package ua.epicwasa.minibank.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class DepositContract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double initialSum;

    private LocalDateTime dateOfSigning;

    private LocalDateTime dateOfExpiration;

    private Double rate;  //rate is written in parts of 1, example: 0.12

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "customer_account_id")
    private Account account;

    private short paymentFrequency; //how many payments a year. example: 12, 1 ...

    private boolean autoProlongation;

    private boolean preExpiration;

}
