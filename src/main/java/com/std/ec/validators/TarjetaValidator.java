package com.std.ec.validators;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("tarjetaValidator")
public class TarjetaValidator implements Validator<Object> {

    // RegEx para:
    // - 13 a 19 dígitos seguidos (tarjeta pura)
    // - 4 bloques de 4 dígitos separados por "-" o espacio
    private static final String TARJETA_REGEX = "^(\\d{13,19}|(\\d{4}[- ]\\d{4}[- ]\\d{4}[- ]\\d{4}))$";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return; // Considera nulo como válido, usa @NotNull si quieres validar presencia
        }

        String input = value.toString().trim();

        if (!input.matches(TARJETA_REGEX)) {
            throw new ValidatorException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Formato inválido", "Ingrese un número de tarjeta válido (ej. 1234567812345678 o 1234-5678-1234-5678).")
            );
        }
    }
}
