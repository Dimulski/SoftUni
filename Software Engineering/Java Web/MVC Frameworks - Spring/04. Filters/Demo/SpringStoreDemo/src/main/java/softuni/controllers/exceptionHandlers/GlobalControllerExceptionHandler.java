package softuni.controllers.exceptionHandlers;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import softuni.exceptions.service.InvalidGameException;
import softuni.exceptions.entity.OwnedGameException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(OwnedGameException.class)
    public String ownedGameException(Model model, Exception e) throws Exception {
        model.addAttribute("view", "error/409");

        return "error-layout";
    }

    @ExceptionHandler(InvalidGameException.class)
    public String invalidGameException(){
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String genericException(Model model, Exception e) throws Exception {
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        model.addAttribute("view", "error/500");

        return "error-layout";

    }
}
