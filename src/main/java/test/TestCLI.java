package test;

import com.company.CLI;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ale on 18/08/2016.
 */
public class TestCLI {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Options options;

    @Before
    public void setUpStreamsAndOptions() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        this.options = new Options();
        options.addOption("t", true, "display input from user");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void TestGivenHelloWorldReturnsHelloWorld() throws ParseException {
        String[] args = {"-tHello, World!"};
        CLI cli = new CLI(options);
        cli.main(args);
        assertThat(outContent.toString(), is("Hello, World!"));
    }
}
