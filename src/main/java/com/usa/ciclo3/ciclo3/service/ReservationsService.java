package com.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.ciclo3.ciclo3.model.Reservations;
import com.usa.ciclo3.ciclo3.repository.ContadorClientes;
import com.usa.ciclo3.ciclo3.repository.ReservationsRepository;
import com.usa.ciclo3.ciclo3.repository.StatusReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Reto 5: el equipo desarrollará completa la aplicación aplicando los conocimientos adquiridos sobre CSS, 
 * de esta manera se complementará la parte visual de la aplicación y se alineará a los criterios estéticos propuestos.
 * Adicionalmente se podrá satisfacer las necesidades de la gerencia que solicita reportes con el fin de tomar decisiones 
 * gerenciales con mayor certeza. Estos reportes consisten en:
 * Cantidad de reservas en un tiempo determinado.
 * Cantidad de reservas completas vs canceladas.
 * Top de los clientes que más dinero le han dejado a la compañía.
 *
 * @author David Ballen, Nicolas Caicedo, Liliana Torres, Kelly Solano, Ruben Ramos.
 * @version 1.0
 * @since 29/10/2021
 */
/**
 * Servicio Reservacion
 *
 * @author David Ballen, Nicolas Caicedo, Liliana Torres, Kelly Solano, Ruben Ramos.
 * @version 1.0
 * @since 29/10/2021
 */
@Service
public class ReservationsService {
    //Anotacion Autowired
    @Autowired
    /**
     * Se instancia el repositorio de reservaciones.
     * */
    private ReservationsRepository reservationsRepository;
    /**
     * Función obtener reservaciones: retorna lista de reservas.
     * */
    public List<Reservations> getAll() {

	return reservationsRepository.getAll();
    }
    /**
     * Función obtener reserva: retorna la reserva segun ID.
     * */
    public Optional<Reservations> getResevation(int id) {
	return reservationsRepository.getRegistranion(id);
	}
    /**
     * Función guardar reserva: almacena nueva reserva.
     * */
    public Reservations save(Reservations reserv) {
	if (reserv.getIdReservation() == null) {
            return reservationsRepository.save(reserv);
	} else {
            Optional<Reservations> reserveAuxOptional = reservationsRepository
            .getRegistranion(reserv.getIdReservation());
            if (reserveAuxOptional.isEmpty()) {
            return reservationsRepository.save(reserv);
            } else {
            return reserv;
            }
	}
    }
    /**
     * Función actualizar reserva: modifica una reserva.
     * */
    public Reservations update(Reservations reservation) {
	if (reservation.getIdReservation() != null) {
            Optional<Reservations> reservationEjemplo = reservationsRepository
		.getRegistranion(reservation.getIdReservation());
            if (!reservationEjemplo.isEmpty()) {
		if (reservation.getStartDate() != null) {
                    reservationEjemplo.get().setStartDate(reservation.getStartDate());
		}
		if (reservation.getDevolutionDate() != null) {
                    reservationEjemplo.get().setDevolutionDate(reservation.getDevolutionDate());
		}
		if (reservation.getStatus() != null) {
                    reservationEjemplo.get().setStatus(reservation.getStatus());
		}
//		if (reservation.getClient() != null) {
//		reservationEjemplo.get().setClient(reservation.getClient());
//		}
				
		reservationsRepository.save(reservationEjemplo.get());
		return reservationEjemplo.get();
            } else {
                    return reservation;
            }
	} else {
		return reservation;
	}
    }
    /**
     * Función eliminar reserva: borra una reserva.
     * @param idReservation
     * @return aBoolean
     * */
    public boolean deleteReservation(int id) {
	Boolean aBoolean = getResevation(id).map(reservation -> {
            reservationsRepository.delete(reservation);
		return true;
	}).orElse(false);
		return aBoolean;
    }
    /**
     * Función Reporte Estatus reserva: Cantidad de reservas completas vs canceladas.
     * @return StatusReservas
     * */
    public StatusReservas getReporteEstatusReservaciones(){
                        
        List<Reservations>completed= reservationsRepository.ReservacionStatus("completed");
        List<Reservations>cancelled= reservationsRepository.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }
    /**
     * Función Reporte Tiempo de reserva: borra una reserva.
     * @param dateA
     * @param dateB 
     * @exception 
     * */
    public List<Reservations> getReportesTiempoReservaciones(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
            
        try{
            datoUno= parser.parse(dateA);
            datoDos= parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
                
                           
        }if(datoUno.before (datoDos)){
            return reservationsRepository.ReservacionTiempo(datoUno, datoDos);
           
                
        }else{
            return new ArrayList<>();
        }
    }
    /**
     * Función Top Clientes: Top de los clientes que más dinero le han dejado a la compañía.
     * */
     public List<ContadorClientes> servicioTopClientes(){
        return reservationsRepository.getTopClientes();
    }
        
}
