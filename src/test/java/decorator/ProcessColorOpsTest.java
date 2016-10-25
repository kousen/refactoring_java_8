package decorator;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ProcessColorOpsTest {
    private ProcessColorOps ops = new ProcessColorOps();

    @Before
    public void setUp() {
        ops.setColor(new Color(100, 50, 0));
    }

    @Test
    public void applyFilters() throws Exception {
        Color c = ops.applyFilters(Color::brighter, Color::darker);
        assertEquals(new Color(99, 49, 0), c);
    }

}