
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ApiEuServlet")
public class ApiAlexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("RA", "1290482212041");
        jsonBuilder.add("Nome", "Alex de Oliveira");
        JsonArray disciplinasArray = Json.createArrayBuilder()
                .add("Ética e Responsabilidade Profissional")
                .add("Banco de Dados")
                .add("Engenharia de Software III")
                .add("Programação Orientada a Objetos")
                .add("Linguagem de Programação IV - INTERNET")
                .add("Sistemas Operacionais II")
                .add("Inglês IV")
                .add("Metodologia da Pesquisa Científico-Tecnológica")
                
                .build();
        jsonBuilder.add("Disciplinas", disciplinasArray);
        JsonObject json = jsonBuilder.build();
        PrintWriter out = response.getWriter();
        out.print(json.toString());
    }
}
