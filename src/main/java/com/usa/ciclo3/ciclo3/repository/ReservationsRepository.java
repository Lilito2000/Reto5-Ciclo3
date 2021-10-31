package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Client;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.usa.ciclo3.ciclo3.model.Reservations;
import com.usa.ciclo3.ciclo3.repository.crud.ReservationsCrudRepository;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ReservationsRepository {

	@Autowired
	private ReservationsCrudRepository reservationsCrudRepository;

	public List<Reservations> getAll() {

		return (List<Reservations>) reservationsCrudRepository.findAll();
	}

	public Optional<Reservations> getRegistranion(int id) {

		return reservationsCrudRepository.findById(id);
	}

	public Reservations save(Reservations r) {
		return reservationsCrudRepository.save(r);
	}

	public void delete(Reservations reservation) {
		reservationsCrudRepository.delete(reservation);
	}
        public List<Reservations> ReservacionStatus (String status) {
            return reservationsCrudRepository.findAllByStatus(status);
        }
        public List<Reservations> ReservacionTiempo(Date a, Date b){
            return reservationsCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
        }
        public List<ContadorClientes> getTopClientes (){
            List<ContadorClientes> res= new ArrayList<>();
            List<Object[]> report= reservationsCrudRepository.countTotalReservationsByClient();
            for(int i=0; i<report.size(); i++){
                res.add(new ContadorClientes((Long)report.get(i)[1],(Client)report.get(i)[0]));
                        
                
            }
            return res;
        }
}
