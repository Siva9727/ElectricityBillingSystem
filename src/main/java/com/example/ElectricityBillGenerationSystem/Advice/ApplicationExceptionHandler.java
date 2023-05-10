package com.example.ElectricityBillGenerationSystem.Advice;

import com.example.ElectricityBillGenerationSystem.Exception.ConsumerNotFoundException;
import com.example.ElectricityBillGenerationSystem.VO.ErrorVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
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



//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    public ResponseEntity<String> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
//        return ResponseEntity
//                .badRequest()
//                .body("Bill not yet generated for the consumer id");
//    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<Map<String,String>> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message","Bill not yet generated for the consumer id");
        return ResponseEntity
                .badRequest()
                .body(error);
    }


//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
//        return ResponseEntity
//                .badRequest()
//                .body("Consumer Id is not found. Please provide the correct consumer ID");
//    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Consumer Id is not found. Please provide the correct consumer ID");
        return ResponseEntity
                .badRequest()
                .body(error);
    }
}
