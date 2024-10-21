package org.data.itvdnstudyspringdata3.service;

import org.data.itvdnstudyspringdata3.model.Ticket;
import org.data.itvdnstudyspringdata3.repository.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ResponseEntity<?> createTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    public ResponseEntity<Ticket> getTicket(Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        return optionalTicket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
