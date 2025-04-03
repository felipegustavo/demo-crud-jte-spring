package ifba.saj.progweb.demo_crud.service.impl;

import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO;
import ifba.saj.progweb.demo_crud.entity.FuncionarioEntity;
import ifba.saj.progweb.demo_crud.exception.NotFoundException;
import ifba.saj.progweb.demo_crud.mapping.FuncionarioMapper;
import ifba.saj.progweb.demo_crud.repository.FuncionarioRepository;
import ifba.saj.progweb.demo_crud.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    @Override
    public FuncionarioDTO findOne(Long id) {
        var func = repository.findById(id);

        return func
                .map(mapper::mapToFuncionarioDTO)
                .orElseThrow(() -> new NotFoundException(
                    "Não foi encontrado funcionario com id %s".formatted(id)));
    }

    @Override
    public List<FuncionarioDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToFuncionarioDTO)
                .toList();

        /*
        List<FuncionarioDTO> list = new ArrayList<>();
        List<FuncionarioEntity> listEntity = repository.findAll();

        for (FuncionarioEntity f : listEntity) {
            list.add(mapper.mapToFuncionarioDTO(f));
        }
        return list;*/
    }

    @Override
    public void save(FuncionarioDTO func) {
        repository.save(mapper.mapToFuncionarioEntity(func));
    }

    @Override
    public void remove(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

}
