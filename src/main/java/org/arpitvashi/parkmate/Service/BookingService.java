package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.BookingDTO;

import java.util.List;

public interface BookingService {

    BookingDTO createBooking(BookingDTO booking);

   List<BookingDTO> getAllBookings();

   BookingDTO getBookingById(Long id);

   BookingDTO updateBooking(Long id, BookingDTO bookingDTO);

   void deleteBooking(Long id);

}
