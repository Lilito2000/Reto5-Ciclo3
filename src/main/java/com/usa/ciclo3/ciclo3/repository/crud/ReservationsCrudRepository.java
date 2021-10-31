package com.usa.ciclo3.ciclo3.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.ciclo3.ciclo3.model.Reservations;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ReservationsCrudRepository extends CrudRepository<Reservations, Integer> {

    public List<Reservations> findAllByStatus (String status);  
    
    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
   
    
    @Query ("SELECT c.client, COUNT(c.client) from Reservations AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}
