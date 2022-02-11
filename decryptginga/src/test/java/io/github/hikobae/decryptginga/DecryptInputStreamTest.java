package io.github.hikobae.decryptginga;

import com.google.common.io.ByteStreams;
import com.google.common.primitives.Bytes;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class DecryptInputStreamTest extends TestCase {

    public void test() throws IOException {
        byte[] noise = new byte[]{0x00, 0x00};
        byte[] gzip = new byte[]{
                0x1f, (byte) 0x8b, 0x08, 0x08, (byte) 0x96, 0x1a, 0x06, 0x62, 0x00, 0x03, 0x61,
                0x2e, 0x74, 0x78, 0x74, 0x00, 0x33, 0x34, 0x32, 0x06, 0x00, (byte) 0xd2, 0x63, 0x48,
                (byte) 0x88, 0x03, 0x00, 0x00, 0x00
        };
        byte[] data = Bytes.concat(noise, gzip);

        try (DecryptInputStream in = new DecryptInputStream(new ByteArrayInputStream(data), noise.length);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            ByteStreams.copy(in, out);
            assertThat(out.toByteArray()).isEqualTo(new byte[]{0x31, 0x32, 0x33});
        }
    }
}