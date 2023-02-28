package alex;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Pie_chart_test {

    @Test
    void test_slice_name() {

        Slice slice = new Slice("College_gradute", null, null);
        assertEquals("College_gradute", slice.name);

        Slice slice2 = new Slice("University_degree", null, null);
        assertEquals("University_degree", slice2.name);

        Slice slice3 = new Slice("Trade_school_graduate", null, null);
        assertNotEquals("Primary_school_graduate", slice3.name);
    }

    @Test
    void test_slice_color() {

        Slice slice = new Slice(null, Color.BLACK, null);
        assertEquals(Color.BLACK, slice.color);

        Slice slice2 = new Slice(null, Color.BLUE, null);
        assertEquals(Color.BLUE, slice2.color);

        Slice slice3 = new Slice(null, Color.GRAY, null);
        assertNotEquals(Color.BLACK, slice3.color);

    }

    @Test
    void test_slice_value() {

        Slice slice = new Slice(null, null, 250000);
        assertEquals(250000, slice.value);

        Slice slice2 = new Slice(null, null, 500000);
        assertEquals(500000, slice2.value);

        Slice slice3 = new Slice(null, null, 125000);
        assertNotEquals(125001, slice3.value);

    }

    @Test
    void test_slice_rotation() {
        Slice[] slice = { new Slice(null, null, 15000), new Slice(null, null, 10000), new Slice(null,
                null, 5000), new Slice(null, null, 50000)};

        Slice[] slice2 = {null,null,null,null};

        slice2[0] = slice[3];
        slice2[1] = slice[0];
        slice2[2] = slice[1];
        slice2[3] = slice[2];

        slice[3] = slice2[3];
        slice[0] = slice2[0];
        slice[1] = slice2[1];
        slice[2] = slice2[2];

        assertEquals(50000, slice[0].value);
        assertEquals(15000, slice[1].value);
        assertEquals(10000, slice[2].value);
        assertEquals(5000, slice[3].value);
    }


    @Test
    void test_pie() {
        Slice[] slice = {new Slice("University_degree", Color.black,200000), new Slice("College_graduate", Color.green, 250000),
                new Slice("Trade_school_graduate", Color.yellow, 150000), new Slice("Primary_school_graduate", Color.red,400000) };

        Pie pie = new Pie(slice);

        assertEquals("University_degree", pie.slice[0].name);
        assertEquals("College_graduate", pie.slice[1].name);
        assertEquals("Trade_school_graduate", pie.slice[2].name);
        assertEquals("Primary_school_graduate", pie.slice[3].name);

        assertEquals(Color.black, pie.slice[0].color);
        assertEquals(Color.green, pie.slice[1].color);
        assertEquals(Color.yellow, pie.slice[2].color);
        assertEquals(Color.red, pie.slice[3].color);

        assertEquals(200000, pie.slice[0].value);
        assertEquals(250000, pie.slice[1].value);
        assertEquals(150000, pie.slice[2].value);
        assertEquals(400000, pie.slice[3].value);

    }

    @Test
    void test_frame() {

        JFrame frame = new JFrame();
        JButton button = new JButton();

        frame.setBackground(Color.RED);

        frame.setSize(700, 600);
        frame.add(button);

        assertEquals(600,frame.getSize().height);
        assertEquals(700,frame.getSize().width);

        assertEquals(Color.RED,frame.getBackground());

        assertEquals(1,frame.getComponentCount());

        assertFalse(frame.isVisible());

    }

    @Test
    void test_button() {

        JButton button = new JButton();
        JButton button2 = new JButton();

        button.setBackground(Color.GREEN);

        button.setSize(100, 250);
        button.add(button2);

        assertEquals(250,button.getSize().height);
        assertEquals(100,button.getSize().width);

        assertEquals(Color.GREEN,button.getBackground());

        assertEquals(1,button.getComponentCount());

    }

    @Test
    void test_button_add_component() {

        JButton button = new JButton();

        Slice[] slice = {new Slice("University_degree", Color.black,200000), new Slice("College_graduate", Color.green, 250000),
                new Slice("Trade_school_graduate", Color.yellow, 150000), new Slice("Primary_school_graduate", Color.red,400000) };

        Pie pie = new Pie(slice);

        button.add(pie);

        assertEquals(1,button.getComponentCount());
        assertEquals("Pie",button.getComponent(0).getClass().getSimpleName());
    }

    @Test
    void test_button_remove_component() {

        JButton button = new JButton();

        Slice[] slice = {new Slice("University_degree", Color.black,200000), new Slice("College_graduate", Color.green, 250000),
                new Slice("Trade_school_graduate", Color.yellow, 150000), new Slice("Primary_school_graduate", Color.red,400000) };

        Pie pie = new Pie(slice);

        button.add(pie);

        assertEquals(1,button.getComponentCount());

        button.remove(pie);

        assertEquals(0,button.getComponentCount());

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            button.getComponent(0);
        });

    }
}