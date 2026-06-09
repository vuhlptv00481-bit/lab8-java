package IO;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;

public class RestIO {
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T readObject(HttpServletRequest req, Class<T> clazz) throws IOException {
        return mapper.readValue(req.getReader(), clazz);
    }

    public static void writeObject(HttpServletResponse resp, Object data) throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        mapper.writeValue(resp.getWriter(), data);
    }

    public static void writeEmptyObject(HttpServletResponse resp) throws IOException {
        writeObject(resp, Collections.emptyMap());
    }
}