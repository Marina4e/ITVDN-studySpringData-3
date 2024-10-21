package org.data.itvdnstudyspringdata3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @OneToOne(mappedBy = "ticket")
    private Reader reader;
}
