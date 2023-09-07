
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet("/ApiLoteriaServlet")
public class ApiLoteriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        JsonArrayBuilder numerosArrayBuilder = Json.createArrayBuilder();
        List<Integer> numerosGerados = new ArrayList<>();
        Random random = new Random();
        while (numerosGerados.size() < 6) {
            int numero = random.nextInt(60) + 1;
            if (!numerosGerados.contains(numero)) {
                numerosGerados.add(numero);
                numerosArrayBuilder.add(numero);
            }
        }
        JsonArray numerosLoteria = numerosArrayBuilder.build();
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("DataHora", getCurrentDateTime());
        jsonBuilder.add("NumerosLoteria", numerosLoteria);
        JsonObject json = jsonBuilder.build();
        PrintWriter out = response.getWriter();
        out.print(json.toString());
    }
    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String formattedDateTime = dateFormat.format(date);
        return formattedDateTime;
    }
}
