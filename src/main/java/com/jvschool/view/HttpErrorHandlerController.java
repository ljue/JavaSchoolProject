package com.jvschool.view;

import com.jvschool.util.KeywordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Controller
@ControllerAdvice
public class HttpErrorHandlerController {

//    @KeywordNotFoundException(ResourceNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleResourceNotFoundException() {
//        return "wrong";
//    }


//    @RequestMapping( value={"/400", "/404", "/500"})
//    public String error(){
//        return "wrong";
//    }
//
//    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
//    public class OrderNotFoundException extends RuntimeException {
//        // ...
//    }

//    @KeywordNotFoundException(CustomGenericException.class)
//    public ModelAndView handleCustomException(CustomGenericException ex) {
//
//        ModelAndView model = new ModelAndView("error/generic_error");
//        model.addObject("exception", ex);
//        return model;
//
//    }
//
//    @KeywordNotFoundException(Exception.class)
//    public ModelAndView handleAllException(Exception ex) {
//
//        ModelAndView model = new ModelAndView("error/exception_error");
//        return model;
//
//    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String requestHandlingNoHandlerFound(HttpServletRequest req, NoHandlerFoundException ex) {
        return "wrong";
    }

    @ExceptionHandler(KeywordNotFoundException.class)
    public String notFound() {
        System.out.println("----Caught KeywordNotFoundException----");
        return "404";
    }
}
