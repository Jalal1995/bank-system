package com.celal.banksystem.libs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(exclude = "customer")
@ToString(exclude = "customer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credits")
@Builder
public class Credit {

    @Id
    @Column(name = "credit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;
    private Integer paidAmount;
    private LocalDate date;
    private LocalDate paidDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "customer_credits",
            joinColumns = @JoinColumn(name = "credit_id", referencedColumnName = "credit_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"))
    private Customer customer;
}
