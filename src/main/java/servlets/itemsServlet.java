package servlets;

import Generactive.model.Item;
import Generactive.model.StockItem;
import Generactive.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.util.ErrorEntity;
import servlets.util.HttpConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet("/items")

public class itemsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        // ObjectMapper parse Java objects to JSON and vise a versa.
        ItemRepository items=ItemRepository.getInstance();
        ObjectMapper objectMapper = new ObjectMapper();
        // accept only application/json
        if (!req.getContentType().equals(HttpConstants.ContentType.APPLICATION_JSON)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "not_supported_format");
        }

        // Read the body content
        BufferedReader bufferedReader = req.getReader();
        String body = bufferedReader.lines().collect(Collectors.joining());

        try {
            StockItem item = objectMapper.readValue(body, StockItem.class);
            items.addItem(item);
            resp.getWriter().write(objectMapper.writeValueAsString(item));
        } catch (RuntimeException e) {
            ErrorEntity errorEntity = new ErrorEntity("json_parse_failed:" + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(objectMapper.writeValueAsString(errorEntity));
        }
    }
}
