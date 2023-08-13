package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.*;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.*;

@Named
@RequestScoped
public class VacanteForm {

    /*aca utilizamos el concepto de CDI para inyectar 
      la dependencia de este bean*/
    @Inject
    private Candidato candidato;
    private Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        this.log.info("creando el objeto vacanterForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {

        if (this.candidato.getNombre().equalsIgnoreCase("Wilder")) {

            /*esta validacion es para comprobar que un usuario ya sea empleado
            de nuestra empresa, si tanto el nombre como el apellido coinciden,
            se le indicará el error y será redirigido a la pagina de inicio
             */
            if (this.candidato.getApellido().equalsIgnoreCase("Ruiz")) {
                String msg = "gracias pero wilder ruiz ya trabaja con nosotros.";
                /*con esto enviamos el mensaje a nuestra pagina jsf*/
                FacesMessage facesMessage = new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, msg, msg);

                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; //este es un mensaje global
                facesContext.addMessage(componentId, facesMessage);

                return "index";
            }

            log.info("entrando al caso de exito");

            /*no es necesario agregar la extencion ya que buscara algun archivo que
            coincida con este nombre
             */
            return "exito.xhtml";

        } else {
            log.info("entrando al caso de fallo");
            return "fallo";

        }
    }

    public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        /* con este objeto buscaremos un componente dentro 
        de nuestro formulario*/
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        /*aca recibimos el valor del nuevo codigo postal insertado*/
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
        if (nuevoCodigoPostal.equals("03810")) {
            /*aqui recuperamos el componente de colonia de nuestra pagina de 
                jsf del formulario, tambien debemos hacer una conversion
                    de tipos aqui*/
            UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:colonia");
            String nuevaColonia = "Napoles";
            /*aqui setteamos el valor del la colonia en caso de que la validacion
            se cumpla
            */
            coloniaInputText.setValue(nuevaColonia);
            /*para que se reflejen los cambios en la pagina jsf debemos,
            utilizar el siguiente metodo de igualmanera
            */
            coloniaInputText.setSubmittedValue(nuevaColonia);
            /*aqui en el parametro definimos primero el nombre del formulario y luego
            el nombre de id del campo al que queremos acceder
            */
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaCiudad = "Medellin";
            ciudadInputText.setValue(nuevaCiudad);
            ciudadInputText.setSubmittedValue(nuevaCiudad);
            //con esta instruccion indicamos que se envie la respuesta
            facesContext.renderResponse();
        }

    }

}
