package org.data.itvdnstudyspringdata3.repository;

import org.data.itvdnstudyspringdata3.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
