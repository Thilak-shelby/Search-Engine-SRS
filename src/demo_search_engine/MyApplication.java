package demo_search_engine;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class MyApplication extends Application {

    private final Set<Object> singletons = new HashSet<>();

    public MyApplication() {
        singletons.add(new WebsiteResource());   
        singletons.add(new CrawlJobResource());

    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
