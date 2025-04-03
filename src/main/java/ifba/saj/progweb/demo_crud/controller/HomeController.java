package ifba.saj.progweb.demo_crud.controller;

import ifba.saj.progweb.demo_crud.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final FuncionarioService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("funcionarios", service.findAll());
        return "index";
    }

}
