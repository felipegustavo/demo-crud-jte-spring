package ifba.saj.progweb.demo_crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
@Slf4j
public class ErrorController {

    @GetMapping
    public String error() {
        log.info("Houve um errro!");
        return "error";
    }

}
