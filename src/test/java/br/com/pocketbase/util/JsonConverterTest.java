package br.com.pocketbase.util;

import br.com.pocketbase.dto.PocketbasePage;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class JsonConverterTest {

    public JsonConverterTest() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

//    @Test
//    public void testFromJsonList() throws Exception {
//        System.out.println("fromJsonList");
//        List expResult = null;
//        List result = JsonConverter.fromJsonList(null);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testFromJson() throws Exception {
        System.out.println("fromJson");
        Resposta expResult = new Resposta();
        expResult.setData(LocalDateTime.of(2025, Month.APRIL, 30, 21, 30, 20));
        String json = "{\"nome\":\"gilmario\",\"idade\":16,\"data\":\"2025-04-30 21:30:20\"}";
        Resposta result = JsonConverter.fromJson(json, Resposta.class);
        Assertions.assertEquals(expResult.getData(), result.getData());
//        fail("The test case is a prototype.");
    }

    @Test
    public void testFromJsonPage() throws Exception {
        System.out.println("fromJsonPage");
        String json = "{\"page\":1,\"perPage\":30,\"totalItems\":8,\"totalPages\":1,\"items\":[{\"nome\":\"gilmario\",\"idade\":16,\"data\":\"2025-04-30 21:30:20\"}]}";
        PocketbasePage<Resposta> result = JsonConverter.fromJson(json, PocketbasePage.class, Resposta.class);
        Assertions.assertTrue(!result.getItems().isEmpty());
    }

    @Test
    public void testFromJsonList() throws Exception {
        System.out.println("fromJsonPage");
        String json = "[{\"nome\":\"gilmario\",\"idade\":16,\"data\":\"2025-04-30 21:30:20\"}]";
        List<Resposta> result = JsonConverter.fromJson(json, List.class, Resposta.class);
        Assertions.assertTrue(result.size() == 1);
    }

    @Test
    public void testToJson() throws Exception {
        System.out.println("toJson");
        Resposta resposta = new Resposta();
        resposta.setData(LocalDateTime.of(2025, Month.APRIL, 30, 21, 30, 20));
        resposta.setNome("Gilmario");
        resposta.setIdade(39);

        String expResult = "{\"nome\":\"Gilmario\",\"idade\":39,\"data\":\"2025-04-30 21:30:20\"}";
        String result = JsonConverter.toJson(resposta);

        Assertions.assertEquals(expResult, result);
//        fail("The test case is a prototype.");
    }
}
