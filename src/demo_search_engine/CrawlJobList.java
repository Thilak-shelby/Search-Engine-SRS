package demo_search_engine;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "crawlJobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class CrawlJobList {

    @XmlElement(name = "crawlJob")
    public List<CrawlJob> jobs = new ArrayList<>();

    public CrawlJobList() {}

    public CrawlJobList(List<CrawlJob> jobs) {
        this.jobs = jobs;
    }
}
