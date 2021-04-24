package wto.lib.parser;

import java.io.Reader;
import java.io.Writer;

public interface Parser<T> {
    T getObject(Reader in, Class<T> c) throws Exception;

    void saveObject(Writer out, T o) throws Exception;
}