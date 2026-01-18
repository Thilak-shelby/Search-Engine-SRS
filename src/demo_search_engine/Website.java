package demo_search_engine;


import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.Instant;

@XmlRootElement(name = "website")
@XmlAccessorType(XmlAccessType.FIELD)
public class Website {

    @XmlElement
    public String websiteId;

    @XmlElement
    public String baseUrl;

    @XmlElement
    public int crawlIntervalMonths;

    @XmlElement
    public String status; // active | paused | removed

    @XmlElement
    public String createdAt;


    public Website() {}

    public Website(String websiteId, String baseUrl, int crawlIntervalMonths, String status, String createdAt) {
        this.websiteId = websiteId;
        this.baseUrl = baseUrl;
        this.crawlIntervalMonths = crawlIntervalMonths;
        this.status = status;
        this.createdAt = createdAt;
    }
}
