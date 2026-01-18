package demo_search_engine;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Path("api/crawl-jobs")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CrawlJobResource {

    private static final Map<String, CrawlJob> jobs = new ConcurrentHashMap<>();

    // ✅ POST /api/crawl-jobs -> create a crawl job
    @POST
    public Response createJob(CrawlJob request) {

        if (request == null || request.websiteId == null || request.websiteId.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("websiteId is required")
                    .build();
        }

        String crawlType = (request.crawlType == null || request.crawlType.trim().isEmpty())
                ? "initial"
                : request.crawlType.trim().toLowerCase();

        String jobId = UUID.randomUUID().toString();

        CrawlJob created = new CrawlJob(
        	    jobId,
        	    request.websiteId.trim(),
        	    crawlType,
        	    "planned",
        	    java.time.Instant.now().toString()
        	);


        jobs.put(jobId, created);

        return Response.status(Response.Status.ACCEPTED)  // 202 Accepted
                .entity(created)
                .build();
    }

    // ✅ GET /api/crawl-jobs -> list all jobs
    
    @GET
    public CrawlJobList listJobs(@QueryParam("websiteId") String websiteId,
                                 @QueryParam("status") String status) {

        List<CrawlJob> result = new ArrayList<>(jobs.values());

        if (websiteId != null && !websiteId.trim().isEmpty()) {
            String wantedId = websiteId.trim();
            result.removeIf(j -> j.websiteId == null || !j.websiteId.equals(wantedId));
        }

        if (status != null && !status.trim().isEmpty()) {
            String wantedStatus = status.trim().toLowerCase();
            result.removeIf(j -> j.status == null || !j.status.toLowerCase().equals(wantedStatus));
        }

        return new CrawlJobList(result);   // ✅ FIXED
    }

}
