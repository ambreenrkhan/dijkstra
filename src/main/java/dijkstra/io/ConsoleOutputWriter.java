package dijkstra.io;

public class ConsoleOutputWriter implements OutputWriter<String>
{
    public void writeOutput( String output )
    {
        System.out.println( output );
    }
}