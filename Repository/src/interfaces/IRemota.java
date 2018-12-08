
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import dto.AlumnoDTO;
import dto.ClaseDTO;
import dto.MateriaDTO;
import dto.ProfesorDTO;
import dto.ResenaDTO;
import dto.ReservaDTO;


public interface IRemota extends Remote{
	public boolean logIn (String dni, String password, int codigo) throws RemoteException;
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws RemoteException;

	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws RemoteException;

	public void bajaAlumno(String dni) throws RemoteException;
	
	public AlumnoDTO buscarAlumno(String dni) throws RemoteException;

	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws RemoteException;

	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws RemoteException;

	public void bajaProfesor(String dni) throws RemoteException ;

	public ProfesorDTO buscarProfesor(String dni) throws RemoteException;
	
	public void altaClase(String materia,Date fecha, float horario, String estado,String dniProfesor) throws RemoteException;
	
	public MateriaDTO buscarMateria(String nombre) throws RemoteException ;
	
	public void altaMateria(String nombreMat)throws RemoteException;
	
	public ReservaDTO buscarReserva(int idReserva)throws RemoteException;
	
	public void altaReserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga,
			Date fecha, String dniAlumno,ArrayList<String> clases) throws RemoteException;
	public void bajaReserva(int idReserva)throws RemoteException;
	
	public void generarFactura(int idReserva, String tipo, String remitente, String medioPago) throws RemoteException;
	
	public ArrayList<ClaseDTO> verClasesDisponibles() throws RemoteException;
	
	public ArrayList<ReservaDTO>  obtenerReservasAlumno(String dniAlumno) throws RemoteException;
		
	public ArrayList<ClaseDTO> obtenerClaseProfesor(String dniProf) throws RemoteException;
	
	public ArrayList<ResenaDTO> obtenerResenasProfesor(String dniProfesor) throws RemoteException;
}
	

	