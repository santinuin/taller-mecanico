package com.besysoft.taller_mecanico.controller.handlerexception;

import com.besysoft.taller_mecanico.business.dto.response.ExceptionDto;
import com.besysoft.taller_mecanico.exceptions.InvalidRolException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto exceptionHandler(MethodArgumentNotValidException ex) {
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String, String> detalle = new HashMap<>();
        errorList.forEach(x -> detalle.put(x.getField(), x.getDefaultMessage()));
        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Error de validación", detalle);
    }

    @ExceptionHandler(InvalidRolException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionDto invalidRol(InvalidRolException ex) {
        return new ExceptionDto(HttpStatus.FORBIDDEN.value(),
                ex.getMessage(),
                null);
    }

}
