package com.example.aluno;

import com.example.aluno.Aluno;
import org.glassfish.grizzly.http.util.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("alunos")
public class AlunoController {

    private static final List<Aluno> alunos = Arrays.asList(
            new Aluno(1, "João", "joao@joao.com", 3),
            new Aluno(2, "Maria", "maria@maria.com", 1),
            new Aluno(3, "Jose", "jose@mariajoao.com", 2),
            new Aluno(4, "Pedro", "pedro@email.com", 3)
    );

    @GET
    public List<Aluno> procurarTodos() {
        return alunos;
    }

    @GET
    @Path("/{id}")
    public Response procurarPorId(@PathParam("id") Integer id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .map(this::buildSuccessfullResponse)
                .orElse(buildNotFoundResponse());
    }

    private Response buildNotFoundResponse() {
        return Response.status(HttpStatus.NOT_FOUND_404.getStatusCode()).build();
    }

    private Response buildSuccessfullResponse(Aluno entity) {
        return Response.status(HttpStatus.OK_200.getStatusCode()).entity(entity).build();
    }

}
