package com.hyune.raider50g.repository;

import com.hyune.raider50g.domain.booking.Booking;
import com.hyune.raider50g.domain.booking.QBooking;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.util.List;
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

  public List<Booking> find(LocalDate findDate) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);
    QBooking booking = QBooking.booking;

    return queryFactory.selectFrom(booking)
        .where(booking.raidInfo.raidDate.eq(findDate)
            , booking.raidInfo.cancel.isFalse())
        .fetch();
  }
}
