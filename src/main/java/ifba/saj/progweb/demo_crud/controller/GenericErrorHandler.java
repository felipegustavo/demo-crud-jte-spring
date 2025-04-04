package ifba.saj.progweb.demo_crud.controller;

import ifba.saj.progweb.demo_crud.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@RequiredArgsConstructor
public class GenericErrorHandler {

    private final FuncionarioController funcionarioController;

    @ExceptionHandler({NotFoundException.class})
    public ModelAndView handleNotFoundException(NotFoundException e) {
        return funcionarioController.formCreate();
    }

}
