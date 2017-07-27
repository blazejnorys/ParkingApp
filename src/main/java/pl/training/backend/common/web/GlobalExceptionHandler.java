package pl.training.backend.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.training.backend.common.model.Mapper;
import pl.training.backend.security.service.WrongOwnerException;

import java.util.Locale;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Mapper mapper;

    @Autowired
    public GlobalExceptionHandler(Mapper mapper) {
        this.mapper = mapper;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity onException(Exception ex, Locale locale) {
        ex.printStackTrace();
        return new ResponseEntity(mapper.map(ex, locale), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(WrongOwnerException.class)
    public ResponseEntity onWrongOwnerException(WrongOwnerException ex, Locale locale) {
        ex.printStackTrace();
        return new ResponseEntity(mapper.map(ex, locale), FORBIDDEN);
    }

}
