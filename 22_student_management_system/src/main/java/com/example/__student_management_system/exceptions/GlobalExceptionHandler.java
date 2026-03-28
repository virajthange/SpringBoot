package com.example.__student_management_system.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String exception(Exception e, Model model) {
        String msg = e.getMessage();
        model.addAttribute("msg", msg);
        return "error";
    }

}
