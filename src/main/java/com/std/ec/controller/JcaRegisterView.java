package com.std.ec.controller;

import java.io.Serializable;

import org.primefaces.event.FlowEvent;

import com.std.ec.models.RegistroDTO;
import com.std.ec.models.User;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named("jcaRegisterView")
@ViewScoped
public class JcaRegisterView  implements Serializable {

     //Step demo
     private int stepIndex = 0;
    private RegistroDTO registro = new RegistroDTO();


     public void siguientePaso() {
         if (stepIndex < 3) {
             stepIndex++;
         }
     }
 
     public void pasoAnterior() {
         if (stepIndex > 0) {
             stepIndex--;
         }
     }
 
  
     public void finalizarRegistro() {
        System.out.println("Registro completo: " + registro.getNombreCompleto() + " / " +
                registro.getNumeroAsiento() + " / " +
                registro.getNumeroTarjeta() + " / " +
                registro.getEmailConfirmacion());

                resetStepForm();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro completado", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void resetStepIndex() {
        stepIndex = 0;
    }
    public void resetStepForm() {
        registro = new RegistroDTO();
        resetStepIndex();
    }
}