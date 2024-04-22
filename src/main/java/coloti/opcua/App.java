package coloti.opcua;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coloti.opcua.server.UaServer;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
       try {
        UaServer server = new UaServer("/home/coloti/OPCUA/StructuredOpcua/opcuaserver/MCS_ICD_COLOTI.xlsx");
        
        server.startup().get();

        final CompletableFuture<Void> future = new CompletableFuture<>();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> future.complete(null)));

        future.get();
    } catch (Exception e) {
       logger.error(e.getMessage());
    }
       logger.info( "Hello World!" );
    }
}
