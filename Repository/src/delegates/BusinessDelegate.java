package delegates;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import javax.naming.CommunicationException;

import dto.AlumnoDTO;
import dto.ClaseDTO;
import dto.MateriaDTO;
import dto.ProfesorDTO;
import dto.ResenaDTO;
import dto.ReservaDTO;
import interfaces.IRemota;

public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private IRemota remota;
	
	public static BusinessDelegate getInstancia() throws CommunicationException{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	private BusinessDelegate() throws CommunicationException {
		try {
			remota = (IRemota)Naming.lookup("rmi://localhost/Abc");
		} catch (MalformedURLException e) {
			throw new CommunicationException("La direcci�n del servidor es incorrecta");
		} catch (RemoteException e) {
			throw new CommunicationException("La conecci�n con el servidor es incorrecta");
		} catch (NotBoundException e) {
			throw new CommunicationException("Error en el acceso al servidor");	
		}
	}
	
	public boolean loginCliente(String dni, String password, int codigo ) throws CommunicationException{
		try {
			 return remota.logIn(dni, password, codigo);
		} catch (RemoteException e) {
			throw new CommunicationException("Error de comunicaci�n al loguear cliente");
		}
	}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento, String password) throws CommunicationException{
		try {
			 remota.altaAlumno(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al hacer alta alumno");
		}
	}
	
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento, String password) throws CommunicationException{
		try {
			 remota.modificarAlumno(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al modificar el alumno");
		}
	}
	
	public void bajaAlumno(String dni) throws CommunicationException{
		try {
			 remota.bajaAlumno(dni);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de baja alumno");
		}
	}
	
	public AlumnoDTO buscarAlumno(String dni) throws CommunicationException{
		try {
			 return remota.buscarAlumno(dni);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al buscar alumno");
		}
	}
	
	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento, String password, String domicilioClases, Float anticipacion) throws CommunicationException{
		try {
			 remota.altaProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de alta profesor");
		}
	}
	
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento, String password, String domicilioClases, Float anticipacion) throws CommunicationException{
		try {
			 remota.modificarProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al modificar profesor");
		}
	}
	
	public void bajaProfesor(String dni) throws CommunicationException{
		try {
			 remota.bajaProfesor(dni);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de baja profesor");
		}
	}
	
	public ProfesorDTO buscarProfesor(String dni) throws CommunicationException{
		try {
			 return remota.buscarProfesor(dni);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al buscar profesor");
		}
	}
	
	
	public void altaClase(String materia, Date fecha, Float horario, String estado, String dniProfesor) throws CommunicationException{
		try {
			remota.altaClase(materia, fecha, horario, estado, dniProfesor);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de alta clase");
		}
	}
	
	public MateriaDTO buscarMateria(String nombre) throws CommunicationException{
		try {
			return remota.buscarMateria(nombre);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al buscar materia");
		}
	}
	
	public void altaMateria(String nombreMat) throws CommunicationException{
		try {
			remota.altaMateria(nombreMat);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de alta materia");
		}
	}
	
	public ReservaDTO buscarReserva(Integer idReserva) throws CommunicationException{
		try {
			return remota.buscarReserva(idReserva);
		} catch (RemoteException e) {
			throw new CommunicationException("Error  al buscar reserva");
		}
	}
	
	public void altaReserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga, Date fecha, String dniAlumno, ArrayList<String> clases) throws CommunicationException{
		try {
			remota.altaReserva(idReserva, descuento, monto, cantAlum, paga, fecha, dniAlumno, clases);
		} catch (RemoteException e) {
			throw new CommunicationException("Erroral dar de alta reserva");
		}
	}
	
	public void bajaReserva(Integer idReserva) throws CommunicationException{
		try {
			remota.bajaReserva(idReserva);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al dar de baja reserva");
		}
	}
	
	public void generarFactura(Integer idReserva, String tipo, String remitente, String medioPago) throws CommunicationException{
		try {
			remota.generarFactura(idReserva, tipo, remitente, medioPago);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al generar factura");
		}
	}
	
	public ArrayList<ClaseDTO> verClasesDisponibles() throws CommunicationException{
		try {
			return remota.verClasesDisponibles();
		} catch (RemoteException e) {
			throw new CommunicationException("No se pudieron obtener clases disponibles");
		}
	}
	
	public ArrayList<ReservaDTO> obtenerReservasAlumno(String dniAlumno) throws CommunicationException{
		try {
			return remota.obtenerReservasAlumno(dniAlumno);
		} catch (RemoteException e) {
			throw new CommunicationException("Error al obtener reservas de alumno");
		}
	}
	
	public ArrayList<ClaseDTO> obtenerClaseProfesor(String dniProf) throws CommunicationException{
		try {
			return remota.obtenerClaseProfesor(dniProf);
		} catch (RemoteException e) {
			throw new CommunicationException("Error obtener clase profesor");
		}
	}
	
	public ArrayList<ResenaDTO> obtenerResenasProfesor(String dniProfesor) throws CommunicationException{
		try {
			return remota.obtenerResenasProfesor(dniProfesor);
		} catch (RemoteException e) {
			throw new CommunicationException("Error  al obtener resenas profesor");
		}
	}
	public ArrayList<MateriaDTO> obtenerMateriasProfesor(int idUsuario) throws CommunicationException{
		try {
			return remota.obtenerMateriasProfesor(idUsuario);
		} catch (RemoteException e) {
			throw new CommunicationException("Error  al obtener materias profesor");
		}
	}
	public FacturaDTO buscarFactura(int idReserva)  throws CommunicationException{
		try {
			return remota.buscarFactura(idReserva);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error al obtener la factura");
		}
	}
}
