package org.data.itvdnstudyspringdata3.model;


import jakarta.persistence.*;

@Entity
@Table(name = "book_request")
public class BookRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;
}
