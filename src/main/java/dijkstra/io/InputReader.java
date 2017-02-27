package dijkstra.io;

import java.io.IOException;

public interface InputReader<T>
{
    /**
     * @return next node in the input stream
     */
    T readNext() throws IOException;

    /**
     * Closes the input stream and release any resources
     */
    void close();
}