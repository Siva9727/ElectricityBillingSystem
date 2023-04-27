package com.example.ElectricityBillGenerationSystem.Advice;

import com.example.ElectricityBillGenerationSystem.VO.ErrorVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
//        Map<String,String> errorMap = new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error->{
//            errorMap.put(error.getField(),error.getDefaultMessage());
//        });
//
//        return errorMap;
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorVo>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorVo> errors = exception.getBindingResult().getAllErrors().stream().map(objectError ->
                        ErrorVo.builder()
                                .fieldName(((FieldError) objectError).getField())
                                .message(List.of(Objects.requireNonNull(objectError.getDefaultMessage())))
                                .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
