package demo_search_engine;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "crawlJob")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrawlJob {

    @XmlElement
    public String jobId;

    @XmlElement
    public String websiteId;

    @XmlElement
    public String crawlType;   // initial | periodic

    @XmlElement
    public String status;      // planned | running | completed | failed

    @XmlElement
    public String createdAt;

    public CrawlJob() {}

    public CrawlJob(String jobId, String websiteId, String crawlType, String status, String createdAt) {
        this.jobId = jobId;
        this.websiteId = websiteId;
        this.crawlType = crawlType;
        this.status = status;
        this.createdAt = createdAt;
    }
}
