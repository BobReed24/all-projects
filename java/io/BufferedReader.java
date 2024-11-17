package com.thealgorithms.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedReader {

    private static final int DEFAULT_BUFFER_SIZE = 5;

    private int bufferSize;
    private final byte[] buffer;

    private int posRead = 0;
    private int bufferPos = 0;

    private boolean foundEof = false;

    private InputStream input;

    public BufferedReader(byte[] input) throws IOException {
        this(new ByteArrayInputStream(input));
    }

    public BufferedReader(InputStream input) throws IOException {
        this(input, DEFAULT_BUFFER_SIZE);
    }

    public BufferedReader(InputStream input, int bufferSize) throws IOException {
        this.input = input;
        if (input.available() == -1) {
            throw new IOException("Empty or already closed stream provided");
        }

        this.bufferSize = bufferSize;
        buffer = new byte[bufferSize];
    }

    public int read() throws IOException {
        if (needsRefill()) {
            if (foundEof) {
                return -1;
            }
            
            refill();
        }
        return buffer[posRead++] & 0xff; 
    }

    public int available() throws IOException {
        int available = input.available();
        if (needsRefill()) {
            
            return available;
        }
        return bufferPos - posRead + available;
    }

    public int peek() throws IOException {
        return peek(1);
    }

    public int peek(int n) throws IOException {
        int available = available();
        if (n >= available) {
            throw new IOException("Out of range, available %d, but trying with %d".formatted(available, n));
        }
        pushRefreshData();

        if (n >= bufferSize) {
            throw new IllegalAccessError("Cannot peek %s, maximum upto %s (Buffer Limit)".formatted(n, bufferSize));
        }
        return buffer[n];
    }

    private void pushRefreshData() throws IOException {
        for (int i = posRead, j = 0; i < bufferSize; i++, j++) {
            buffer[j] = buffer[i];
        }

        bufferPos -= posRead;
        posRead = 0;

        justRefill();
    }

    public byte[] readBlock() throws IOException {
        pushRefreshData();

        byte[] cloned = new byte[bufferSize];
        
        if (bufferPos >= 0) {
            System.arraycopy(buffer, 0, cloned, 0,
                
                bufferSize);
        }
        
        refill();
        return cloned;
    }

    private boolean needsRefill() {
        return bufferPos == 0 || posRead == bufferSize;
    }

    private void refill() throws IOException {
        posRead = 0;
        bufferPos = 0;
        justRefill();
    }

    private void justRefill() throws IOException {
        assertStreamOpen();

        while (bufferPos < bufferSize) {
            int read = input.read();
            if (read == -1) {
                
                foundEof = true;
                
                bufferSize = bufferPos;
            }
            buffer[bufferPos++] = (byte) read;
        }
    }

    private void assertStreamOpen() {
        if (input == null) {
            throw new IllegalStateException("Input Stream already closed!");
        }
    }

    public void close() throws IOException {
        if (input != null) {
            try {
                input.close();
            } finally {
                input = null;
            }
        }
    }
}
