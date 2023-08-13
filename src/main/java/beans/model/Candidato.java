package beans.model;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.*;

/*agreagamos esta anotacion para que pueda ser reconocida esta clase por el
framework JSF
*/
@Named
//con esto definimos  el alcance (scope)
@RequestScoped 
public class Candidato {
    
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Logger log = LogManager.getRootLogger();
    private Date fechaNacimiento;
    private String codigoPostal;
    private String colonia;
    private String ciudad;

    public Candidato(String nombre, String apellido, int salarioDeseado, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salarioDeseado = salarioDeseado;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Candidato(){
    log.info("Creando el objeto candidato");
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("modificando la propiedad de nombre: " + this.nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("modificando atributo apellido" + this.apellido);
    }

    public int getSalarioDeseado() {
        return salarioDeseado;
    }

    public void setSalarioDeseado(int salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("modificando atributo salario" + this.salarioDeseado);
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}