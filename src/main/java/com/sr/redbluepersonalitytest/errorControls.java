package com.sr.redbluepersonalitytest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class errorControls implements ErrorController  {

   @RequestMapping("/error")
public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    
    if (status != null) {
        Integer statusCode = Integer.valueOf(status.toString());
    
        if(statusCode == HttpStatus.NOT_FOUND.value()) {
            return "not found: error-404";
        }
        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "unable to process: error-500";
        }
    }
    return "Error!!!";
}




}
