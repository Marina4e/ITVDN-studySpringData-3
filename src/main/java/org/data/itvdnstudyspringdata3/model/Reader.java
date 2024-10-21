package org.data.itvdnstudyspringdata3.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    @OneToMany(mappedBy = "reader")
    private Set<BookRequest> requests;
}
