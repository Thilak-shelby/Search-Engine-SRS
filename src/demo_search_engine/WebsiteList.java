package demo_search_engine;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "websites")
@XmlAccessorType(XmlAccessType.FIELD)
public class WebsiteList {

    @XmlElement(name = "website")
    public List<Website> websites = new ArrayList<>();

    public WebsiteList() {}

    public WebsiteList(List<Website> websites) {
        this.websites = websites;
    }
}
