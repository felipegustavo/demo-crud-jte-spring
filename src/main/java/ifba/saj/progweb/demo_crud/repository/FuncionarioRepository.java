package ifba.saj.progweb.demo_crud.repository;

import java.util.Optional;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import ifba.saj.progweb.demo_crud.entity.FuncionarioEntity;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{

    // query methods: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    List<FuncionarioEntity> findBySalarioBetween(BigDecimal salario1, BigDecimal salario2);

    // JPQL
    @Query("select f from FuncionarioEntity f where f.nome = :name")
    Optional<FuncionarioEntity> findByNome(String name);

    // SQL
    @NativeQuery("select * from TB_FUNCIONARIO where nome = :name")
    Optional<FuncionarioEntity> findByNome2(String name);

}
