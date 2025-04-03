package ifba.saj.progweb.demo_crud.mapping;

import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO;
import ifba.saj.progweb.demo_crud.entity.FuncionarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public abstract class FuncionarioMapper {

    @Mapping(target = "idade", expression = "java(calculaIdade(source.getDataNascimento()))")
    public abstract FuncionarioDTO mapToFuncionarioDTO(FuncionarioEntity source);

    public abstract FuncionarioEntity mapToFuncionarioEntity(FuncionarioDTO source);

    public static Integer calculaIdade(LocalDate dataNascimento) {
        return (int) ChronoPeriod.between(dataNascimento, LocalDate.now()).get(ChronoUnit.YEARS);
    }

}
