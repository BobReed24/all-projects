package com.thealgorithms.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class BufferedReaderTest {
    @Test
    public void testPeeks() throws IOException {
        String text = "Hello!\nWorld!";
        int len = text.length();
        byte[] bytes = text.getBytes();

        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        BufferedReader reader = new BufferedReader(input);

        assertEquals(reader.read(), 'H');
        len--;
        assertEquals(reader.available(), len);

        assertEquals(reader.peek(1), 'l');
        assertEquals(reader.peek(2), 'l'); 
        assertEquals(reader.peek(3), 'o');
    }

    @Test
    public void testMixes() throws IOException {
        String text = "Hello!\nWorld!";
        int len = text.length();
        byte[] bytes = text.getBytes();

        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        BufferedReader reader = new BufferedReader(input);

        assertEquals(reader.read(), 'H'); 
        len--;

        assertEquals(reader.peek(1), 'l'); 
        assertEquals(reader.read(), 'e'); 
        len--;
        assertEquals(reader.available(), len);

        assertEquals(reader.peek(2), 'o'); 
        assertEquals(reader.peek(3), '!');
        assertEquals(reader.peek(4), '\n');

        assertEquals(reader.read(), 'l'); 
        assertEquals(reader.peek(1), 'o'); 

        for (int i = 0; i < 6; i++) {
            reader.read();
        }
        try {
            System.out.println((char) reader.peek(4));
        } catch (Exception ignored) {
            System.out.println("[cached intentional error]");
            
        }
    }

    @Test
    public void testBlockPractical() throws IOException {
        String text = "!Hello\nWorld!";
        byte[] bytes = text.getBytes();
        int len = bytes.length;

        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        BufferedReader reader = new BufferedReader(input);

        assertEquals(reader.peek(), 'H');
        assertEquals(reader.read(), '!'); 
        len--;

        assertEquals(new String(reader.readBlock()), "Hello");
        len -= 5;
        assertEquals(reader.available(), len);

        if (reader.read() == '\n') {
            assertEquals(reader.read(), 'W');
            assertEquals(reader.read(), 'o');

            assertEquals(new String(reader.readBlock()), "rld!");
        } else {
            
            throw new IOException("Something not right");
        }
    }
}
