package com.std.ec.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("soloLetrasValidator")
public class SoloLetrasValidator implements Validator<String> {
    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (value == null || value.trim().isEmpty()) return;

        if (!value.matches("^[a-zA-ZÁÉÍÓÚáéíóúÑñ\\s]+$")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Solo letras permitidas (incluyendo acentos y ñ).", null));
        }
    }
}
