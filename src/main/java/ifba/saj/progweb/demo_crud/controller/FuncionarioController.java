package ifba.saj.progweb.demo_crud.controller;

import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO;
import ifba.saj.progweb.demo_crud.exception.NotFoundException;
import ifba.saj.progweb.demo_crud.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @GetMapping("/create")
    public ModelAndView formCreate() {
        var model = new ModelAndView();
        model.setViewName("form");
        model.addObject("func", new FuncionarioDTO());
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        var model = new ModelAndView();
        model.setViewName("form");
        model.addObject("func", service.findOne(id));
        return model;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.remove(id);
        return "redirect:/";
    }

    @PostMapping("/create")
    public ModelAndView createUser(@Valid FuncionarioDTO funcionario, BindingResult bindingResult) {
        var model = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult
                    .getFieldErrors()
                    .stream()
                    .map(f -> "%s: %s".formatted(f.getField(), f.getDefaultMessage()))
                    .toList();

            model.addObject("func", funcionario);
            model.addObject("errors", errors);
            model.setViewName("form");
            return model;
        }

        service.save(funcionario);
        model.setViewName("redirect:/");
        return model;
    }

}
