@import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO
@import java.util.List

@param FuncionarioDTO func
@param List<String> errors

@if (errors != null && !errors.isEmpty())
    <div style="background-color: red">
        <ul>
            @for (var error : errors)
                <li>${error}</li>
            @endfor
            <li></li>
        </ul>
    </div>
@endif

@template.layout.main(content = @`
    <div class="container">
        <h2>Cadastro de Funcionário</h2>
        <form method="post" action="/funcionarios/create">
            <input type="hidden" name="id" value="${func.getId()}">
            <div class="form-group">
                <label for="nome">Nome Completo:</label>
                <input type="text" id="nome" name="nome" value="${func.getNome()}" required>
            </div>
            <div class="form-group">
                <label for="data_nascimento">Data de Nascimento:</label>
                <input type="date" id="data_nascimento" name="dataNascimento"
                       value="${func.getDataNascimento() == null ? "" : func.getDataNascimento().toString()}" required>
            </div>
            <div class="form-group">
                <label for="salario">Salário:</label>
                <input type="number" id="salario" name="salario" step="0.01" value="${func.getSalario()}" required>
            </div>
            <div class="form-group">
                <label for="endereco">Endereço:</label>
                <input type="text" id="endereco" name="endereco" value="${func.getEndereco()}" required>
            </div>
            <div class="form-group">
                <label for="telefone_celular">Telefone Celular:</label>
                <input type="text" id="telefone_celular" name="telefoneCelular" value="${func.getTelefoneCelular()}"
                       required>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </div>
`)
