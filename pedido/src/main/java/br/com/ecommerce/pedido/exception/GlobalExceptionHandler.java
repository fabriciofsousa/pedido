package br.com.ecommerce.pedido.exception;

import jakarta.validation.ConstraintDefinitionException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({PedidoNaoEncontradoException.class})
    public StandardError handleNotFoundException(RuntimeException e) {
        StandardError error = new StandardError();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return error;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<StandardError> validationHandler(MethodArgumentNotValidException e) {
        StandardError error = new StandardError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getFieldError().getDefaultMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class, ConstraintDefinitionException.class, org.hibernate.exception.ConstraintViolationException.class})
    public ResponseEntity<StandardError> validationHandler(ValidationException e) {
        StandardError error = new StandardError();
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getLocalizedMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<StandardError> genericHandler(Exception e) {
        StandardError error = new StandardError();
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(e.getCause().getCause().getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
