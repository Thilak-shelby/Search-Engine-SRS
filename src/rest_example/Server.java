// REST example
// http://localhost:8080/demo/myresource/

// REST example
// Battery URL: http://localhost:8080/robot/battery
package rest_example;

import demo_search_engine.MyApplication;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws Exception {
        Logger.getLogger("org.glassfish").setLevel(Level.SEVERE);

        URI baseUri = new URI("http://0.0.0.0:8080/");
        ResourceConfig config = ResourceConfig.forApplicationClass(MyApplication.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("Server running:");
        System.out.println("http://localhost:8080/api/websites");
        System.out.println("http://localhost:8080/api/crawl-jobs");
        System.out.println("Press ENTER to stop the server.");
        System.in.read();

        server.shutdownNow();
    }
}
