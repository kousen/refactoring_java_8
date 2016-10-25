package collectors;

import org.junit.Test;

import static org.junit.Assert.*;

public class JoiningTest {
    private Joining demo = new Joining();

    @Test
    public void joinFileNamesTest() throws Exception {
        assertTrue(demo.joinFileNamesDeclarative().equals(
                demo.joinFileNamesImperative()
        ));
    }

}