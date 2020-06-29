package com.hyune.raider50g.repository;

import com.hyune.raider50g.domain.booking.Booking;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public Booking save(Booking booking) {
    em.persist(booking);
    return booking;
  }
}
