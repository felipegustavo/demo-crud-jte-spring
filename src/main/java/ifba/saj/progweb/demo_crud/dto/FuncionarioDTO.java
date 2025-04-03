package ifba.saj.progweb.demo_crud.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import static ifba.saj.progweb.demo_crud.util.DateTimeFormatterUtils.FORMATO_DATA_BRASIL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;

    @NotEmpty
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private BigDecimal salario;

    @NotNull
    private String endereco;

    @NotNull
    //@Pattern(regexp = "([0-9]{2}) [0-9]{9}", message = "Padrão deve ser (XX)XXXXXXXXX")
    private String telefoneCelular;

    private Integer idade;

    public String getDataNascimentoFormatada() {
        return dataNascimento.format(FORMATO_DATA_BRASIL);
    }

}
