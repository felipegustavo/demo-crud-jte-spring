@import java.util.List
@import ifba.saj.progweb.demo_crud.dto.FuncionarioDTO

@param List<FuncionarioDTO> funcionarios


@template.layout.main(content = @`
    <a href="/funcionarios/create">Novo Funcionário</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Idade</th>
            <th>Salário</th>
            <th>Endereço</th>
            <th>Celular</th>
            <th>Ações</th>
        </tr>
        @for (FuncionarioDTO f : funcionarios)
        <tr>
            <td>${f.getId()}</td>
            <td>${f.getNome()}</td>
            <td>${f.getDataNascimentoFormatada()}</td>
            <td>${f.getIdade()}</td>
            <td>${f.getSalario()}</td>
            <td>${f.getEndereco()}</td>
            <td>${f.getTelefoneCelular()}</td>
            <td>
                <a href="/funcionarios/edit/${f.getId()}">Editar</a> |
                <a href="/funcionarios/delete/${f.getId()}"
                   onclick="return confirm('Deseja apagar funcionário com ID ${f.getId()}?')"
                >Excluir</a>
            </td>
        </tr>
        @endfor
    </table>
`)