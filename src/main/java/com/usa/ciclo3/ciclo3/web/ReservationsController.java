package com.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ciclo3.ciclo3.model.Reservations;
import com.usa.ciclo3.ciclo3.repository.ContadorClientes;
import com.usa.ciclo3.ciclo3.repository.StatusReservas;
import com.usa.ciclo3.ciclo3.service.ReservationsService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ReservationsController {

	@Autowired
	private ReservationsService reservationService;

	@GetMapping("/all")
	public List<Reservations> getResrvations() {

		return reservationService.getAll();

	}

	@GetMapping("/{id}")
	public Optional<Reservations> getResrvation(@PathVariable("id") int id) {

		return reservationService.getResevation(id);

	}

	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservations save(@RequestBody Reservations reserv) {
		return reservationService.save(reserv);
	}

	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservations update(@RequestBody Reservations reserv) {
		return reservationService.update(reserv);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean delete(@PathVariable("id") int id) {
		return reservationService.deleteReservation(id);
	}
        @GetMapping("/report-status")
        public StatusReservas getReservas(){
            return reservationService.getReporteEstatusReservaciones();
        }
        @GetMapping("report-dates/{dateOne}/{dateTwo}")
        public List<Reservations> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
            return reservationService.getReportesTiempoReservaciones(dateOne, dateTwo);
    }
        @GetMapping("/report-clients")
        public List<ContadorClientes> getClientes(){
            return reservationService.servicioTopClientes();
        }
}
