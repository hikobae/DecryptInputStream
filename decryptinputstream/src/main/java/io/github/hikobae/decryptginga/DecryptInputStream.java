package io.github.hikobae.decryptginga;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class DecryptInputStream extends InputStream {

    private final GZIPInputStream mGzipInputStream;

    public DecryptInputStream(InputStream inputStream, long noiseLength) throws IOException {
        if (inputStream.skip(noiseLength) < noiseLength) {
            throw new IllegalArgumentException();
        }
        mGzipInputStream = new GZIPInputStream(inputStream);
    }

    @Override
    public int read() throws IOException {
        return mGzipInputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return mGzipInputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return mGzipInputStream.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return mGzipInputStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return mGzipInputStream.available();
    }

    @Override
    public void close() throws IOException {
        mGzipInputStream.close();
    }

    @Override
    public synchronized void mark(int readLimit) {
        mGzipInputStream.mark(readLimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        mGzipInputStream.reset();
    }

    @Override
    public boolean markSupported() {
        return mGzipInputStream.markSupported();
    }
}
