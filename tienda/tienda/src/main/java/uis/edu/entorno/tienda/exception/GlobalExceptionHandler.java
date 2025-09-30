package uis.edu.entorno.tienda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import uis.edu.entorno.tienda.dto.ErrorResponse;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {

        // 1. Extraer solo los mensajes de error en una lista de Strings
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        // 2. Obtener el path de la petición
        String path = request.getDescription(false).replace("uri=", "");

        // 3. Crear nuestro objeto de respuesta personalizado
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errorMessages,
                path
        );
        // 4. Devolver la respuesta con el DTO
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}