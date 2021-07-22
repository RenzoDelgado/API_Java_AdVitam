package com.proyecto.rest;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dao.CitaDAO;
import com.proyecto.iservice.IAseguradora;
import com.proyecto.iservice.ICita;
import com.proyecto.iservice.IDoctor;
import com.proyecto.iservice.IEspecialidad;
import com.proyecto.iservice.IHorario;
import com.proyecto.iservice.IMetodoPago;
import com.proyecto.iservice.IPrecioConsulta;
import com.proyecto.iservice.ITipoDocumento;
import com.proyecto.modelo.Aseguradora;
import com.proyecto.modelo.Cita;
import com.proyecto.modelo.Doctor;
import com.proyecto.modelo.Especialidad;
import com.proyecto.modelo.Horario;
import com.proyecto.modelo.Metodopago;
import com.proyecto.modelo.PrecioConsulta;
import com.proyecto.modelo.TipoDocumento;


@RestController
@RequestMapping("/AdVitam")
public class AdVitamRest {

	@Autowired
	private IMetodoPago metodoService;
	
	@Autowired
	private ITipoDocumento tipoDocumentoService;
	
	@Autowired
	private IAseguradora aseguradoraService;
	
	@Autowired
	private IEspecialidad especialidadService;
	
	@Autowired
	private IPrecioConsulta precioConusltaService;
	
	@Autowired
	private IDoctor doctorService;
	
	@Autowired
	private ICita citaService;
	
	@Autowired
	private IHorario horarioService;
	
	/*-------------------METODO DE PAGO-------------------*/
	@GetMapping("/listarMetodoPago")
	public List<Metodopago> listarMetodoPago(){
		return metodoService.ListarMetodoPago();
	}
	
	@PostMapping("/agregarMetodoPago")
	public void agregarMetodoPago(@RequestBody Metodopago metoP) {
		int estado = metodoService.AgregarMetodoPago(metoP);
	}
	/*------------------------FIN-----------------------*/
	
	/*-------------------TIPO DE DOCUMENTO-----------------*/
	@GetMapping("/listarTipoDocumento")
	public List<TipoDocumento> listarTipoDocumento(){
		return tipoDocumentoService.listarTipoDocumento();
	}
	
	@PostMapping("/agregarTipoDocumento")
	public void agregarTipoDocumento(@RequestBody TipoDocumento tipoD) {
		int estado = tipoDocumentoService.agregarTipoDocumento(tipoD);
	}
	
	/*-----------------------FIN--------------------------*/
	
	/*--------------------METODO DE PAGO-------------------*/
	
	@GetMapping("/listarAseguradora")
	public List<Aseguradora> listarAseguradora(){
		return aseguradoraService.listarAseguradora();
	}
	@PostMapping("/agregarAseguradora")
	public void agregarAseguradora(@RequestBody Aseguradora ase) {
		int estado = aseguradoraService.AgragarAseguradora(ase);
	}
	@PutMapping("/actualizarAseguradora")
	public void actualizarAseguradora(@RequestBody Aseguradora ase) {
		int estado = aseguradoraService.ActualizarAseguradora(ase);
	}
	
	/*-------------------------FIN----------------------------*/
	
	/*---------------------ESPECIALIDAD---------------------*/
	
	@GetMapping("/listarEspecialidad")
	public List<Especialidad> listarEspecialidad(){
		return especialidadService.listarEspecilidad();
	}
	
	@GetMapping("/especialidadporid/{id}")
	public Optional<Especialidad> buscarporid(@PathVariable("id") int id){
		return especialidadService.buscarporid(id);
	}
	
	@PostMapping("/agregarEspecialidad")
	public void agregarEspecialidad(@RequestBody Especialidad espe) {
		int estado = especialidadService.agregarEspecialidad(espe);
	}
	
	@PutMapping("/actualizarEspecialidad")
	public void actualizarEspecialidad(@RequestBody Especialidad espe) {
		int estado = especialidadService.actualizarEspecialidad(espe);
	}
	/*-------------------------FIN--------------------------*/
	
	
	/*--------------------PRECIO DE LA CONSULTA--------------------*/
	
	@GetMapping("/listarPrecioConsulta")
	public List<PrecioConsulta> listraPrecioCosulta(){
		return precioConusltaService.listarPrecioConsulta();
	}
	
	@GetMapping("/precioxespecialidad/{id}")
	public List<PrecioConsulta> precioxespe(@PathVariable("id") int id){
		return precioConusltaService.precioxidespe(id);
	}
	
	@PostMapping("/agregarPrecioConsulta")
	public void agregarPrecioConsulta(@RequestBody PrecioConsulta prec) {
		int estado = precioConusltaService.agregarPrecioConsulta(prec);
	}
	
	@PutMapping("/actualizarPrecioConsulta")
	public void actualizarPrecioConsulta(@RequestBody PrecioConsulta prec) {
		int estado = precioConusltaService.agregarPrecioConsulta(prec);
	}
	/*------------------------------FIN---------------------------------*/
	
	/*-------------------------DOCTOR--------------------------*/
	@GetMapping("/listarDoctor")
	public List<Doctor> listraDoctor(){
		return doctorService.listraDoctor();
	}
	
	@GetMapping("/buscarDoctor/{id}")
	public Doctor buscarDoctor(@PathVariable("id") int id) {
		
		Doctor doc = doctorService.buscarDoctor(id);

		return doc;
	}
	
	@PostMapping("/agregarDoctor")
	public void agregarDoctor(@RequestBody Doctor doc) {
		int estado = doctorService.agregarDoctor(doc);
	}
	
	@PutMapping("/actualizarDoctor")
	public void actualizarDoctor(@RequestBody Doctor doc) {
		int estado = doctorService.actualizarDoctor(doc);
	}
	
	@GetMapping("/doctorxespecialidad/{id}")
	public List<Doctor> doctorxespecialidad(@PathVariable("id") int id){
		return doctorService.doctoresxespecialidad(id);
	}
	
	/*--------------------------FIN-----------------------------*/
	
	/*----------------------------CITA-------------------------*/
	@GetMapping("/listarCita")
	public List<Cita> listarCita(){
		return citaService.listarCita();
	}
	
	@RequestMapping("/traercita/{iddoctor}/{fecha}")
	public List<Cita> traercita(@PathVariable("iddoctor")int iddoctor,@PathVariable("fecha") String fecha){
		return citaService.traercita(iddoctor, fecha);
	};
	
	@PostMapping(value="/agregarCita", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public void agregarCita(@ModelAttribute Cita ci) {
		int estado = citaService.agregarCita(ci);
	}

	
	@PutMapping("/actualizarCita")
	public void actualizarCita(@RequestBody Cita ci) {
		int estado = citaService.actualizarCita(ci);
	}
	/*-------------------------FIN-----------------------------*/
	
	/*-------------------------HORARIO--------------------------*/
	@GetMapping("/listarHorario")
	public List<Horario> listarHorario(){
		return horarioService.listarHorario();
	}
	
	@PostMapping("/agregarHorario")
	public void agregarHorario(@RequestBody Horario ho) {
		int estado = horarioService.agregarHorario(ho);
	}
	
	@GetMapping("/horarioxdoctor/{id}")
	public List<Horario> horarioxdoctor(@PathVariable("id") int id){
		return horarioService.horarioxdoctor(id);
	}
	
	/*-----------------------FIN---------------------------*/
}
