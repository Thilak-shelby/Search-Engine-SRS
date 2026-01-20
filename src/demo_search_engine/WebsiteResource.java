package demo_search_engine;


import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Path("api/websites")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class WebsiteResource {

    private static final Map<String, Website> websites = new ConcurrentHashMap<>();

    // ✅ POST /api/websites  -> Create Website
    @POST
    public Response createWebsite(Website request, @Context UriInfo uriInfo) {

        if (request == null || request.baseUrl == null || request.baseUrl.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("baseUrl is required")
                    .build();
        }

        int months = (request.crawlIntervalMonths == 6 || request.crawlIntervalMonths == 12)
                ? request.crawlIntervalMonths
                : 6;

        String status = (request.status == null || request.status.trim().isEmpty())
                ? "active"
                : request.status.trim().toLowerCase();

        String id = UUID.randomUUID().toString();

        Website created = new Website(
        	    id,
        	    request.baseUrl.trim(),
        	    months,
        	    status,
        	    java.time.Instant.now().toString()
        	);

        websites.put(id, created);

        URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.created(location).entity(created).build(); // 201 Created
    }

    // ✅ GET /api/websites  -> List Websites (?status=active optional)
    @GET
    public List<Website> listWebsites(@QueryParam("status") String status) {
        List<Website> result = new ArrayList<>(websites.values());

        if (status != null && !status.trim().isEmpty()) {
            String wanted = status.trim().toLowerCase();
            result.removeIf(w -> w.status == null || !w.status.equalsIgnoreCase(wanted));
        }

        return result;
    }
}
