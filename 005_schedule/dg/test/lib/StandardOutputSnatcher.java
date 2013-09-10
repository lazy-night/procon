package lib;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

/**
 * 標準出力に対し、読み出しができるようにする
 */
public class StandardOutputSnatcher extends PrintStream {
    private BufferedReader buffer = new BufferedReader(new StringReader(""));

    public StandardOutputSnatcher() {
        super(new ByteArrayOutputStream());
    }

    /**
     * 1行文の文字列を読み込む
     * @return 改行を含まない文字。終端の場合はnull
     */
    public String readLine() {
        try {
            String line = "";
            if ((line = buffer.readLine()) != null) {
                return line;
            } else {
                buffer = new BufferedReader(new StringReader(out.toString()));
                ((ByteArrayOutputStream) out).reset();
                return buffer.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
