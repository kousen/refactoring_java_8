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

    @Test
    public void parallelVsSequential() throws Exception {
        System.out.println(demo.joinFileNamesDeclarative());
        System.out.println(demo.joinFileNamesParallel());
        System.out.println(demo.joinFileNamesParallelStringBuffer());
    }
}