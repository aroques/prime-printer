package literateProgramming;

import java.io.*;
import java.nio.file.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PrimePrinterTest {
    private PrintStream out;

    @Before
    public void setUp() throws Exception {
        out = new PrintStream(new FileOutputStream("lead"));
        System.setOut(out);
    }

    @After
    public void teardown() throws Exception {
        out.close();
        Files.delete(Paths.get("lead"));
    }

    @Test
    public void makeSureOutputMatchesGold() throws Exception {
        PrimePrinter.main(new String[0]);
        try(BufferedReader lead = new BufferedReader(new FileReader("lead"))) {
            try(BufferedReader gold = new BufferedReader(new FileReader("gold"))) {
                String line;
                while ((line = gold.readLine()) != null)
                    assertEquals(line, lead.readLine());
                assertNull(lead.readLine());
            }
        }
    }
}