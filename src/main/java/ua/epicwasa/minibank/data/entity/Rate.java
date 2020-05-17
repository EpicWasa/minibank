package ua.epicwasa.minibank.data.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "currency_id")
    private Currency currency;

    private String type; //can be either "deposit" or "loan"

    private int duration; //duration in moths, 1,2....

    private double rate;
}
