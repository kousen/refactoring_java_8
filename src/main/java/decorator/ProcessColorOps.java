package decorator;

import java.awt.*;
import java.util.Arrays;
import java.util.function.UnaryOperator;

// Suggested by Tim Yates, 10/16/16
public class ProcessColorOps {
    @FunctionalInterface
    interface ColorOp extends UnaryOperator<Color> {}

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color applyFilter(ColorOp filter) {
        return filter.apply(color);
    }

    public final Color applyFilters(ColorOp initial, ColorOp... filters) {
        return Arrays.stream(filters)
                .reduce(initial, (agg, e) -> (t) -> e.apply(agg.apply(t)))
                .apply(color);
    }
}