package restassured;

import lombok.extern.log4j.Log4j2;

import java.io.OutputStream;
import java.io.PrintStream;

@Log4j2
public class RestAssuredOutputPrinter extends PrintStream {

    public RestAssuredOutputPrinter(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String value) {
        log.debug(value);
    }
}
