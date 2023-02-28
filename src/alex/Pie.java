package alex;

import javax.swing.*;
import java.awt.*;

public class Pie extends JComponent {
    public Slice[] slice = {null, null, null, null};

    public Pie(Slice[] slice) {
        this.slice[0] = slice[0];
        this.slice[1] = slice[1];
        this.slice[2] = slice[2];
        this.slice[3] = slice[3];
    }


    public void paint(Graphics graph) {

        drawPie((Graphics2D) graph, getBounds(), slice);
    }

    void drawPie(Graphics2D graph2d, Rectangle area, Slice[] slice) {
        double total = 0.0D;

        for (Slice value : slice) {
            total += value.value;
        }
        double curValue = 0.0D;
        int start_angle = 0;
        for (Slice value : slice) {

            start_angle = (int) -(Math.round(curValue * 360 / total)) + 90;
            int arc_angle = (int) -(Math.round(value.value * 360 / total));

            graph2d.setColor(value.color);
            graph2d.fillArc(area.x + 80, area.y + 80, area.width - 200, area.height - 200, start_angle, arc_angle - 1);

            curValue += value.value;
        }
    }
}
