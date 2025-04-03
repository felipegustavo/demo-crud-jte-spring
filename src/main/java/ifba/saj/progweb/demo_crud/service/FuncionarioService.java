package ifba.saj.progweb.demo_crud.service;

import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO;

import java.util.List;

public interface FuncionarioService {

    FuncionarioDTO findOne(Long id);

    List<FuncionarioDTO> findAll();

    void save(FuncionarioDTO func);

    void remove(Long id);

}
