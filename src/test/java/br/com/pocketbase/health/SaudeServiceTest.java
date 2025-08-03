package br.com.pocketbase.health;

import br.com.pocketbase.http.PocketbaseClient;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class SaudeServiceTest {

    public SaudeServiceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of verificarSaude method, of class SaudeService.
     */
    @Test
    public void testVerificarSaude() throws Exception {
        System.out.println("verificarSaude");

        String url = "http://localhost:8090";

        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);

        PocketbaseClient client = new PocketbaseClient(conf);

        SaudeService instance = new SaudeService(client);
        boolean expResult = true;
        boolean result = instance.verificarSaude();
        Assertions.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
