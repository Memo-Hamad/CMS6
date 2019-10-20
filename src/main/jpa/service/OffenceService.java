package main.jpa.service;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import main.jpa.entity.*;
import main.jpa.repository.*;

@Path("/api/offences")
@ApplicationScoped
public class OffenceService {
    @Inject
    IOffenceRepository offenceRepository;
    RewardEntity reward;
//
//    @Inject
//    IOrderRepository orderRepository;

    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences using Get request
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<OffenceEntity> getOffences() {
        return offenceRepository.getOffences();
    }

    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences/1 using Get request
    @GET
    @Path("offences/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffence(@PathParam("id") int offenceId) {
        OffenceEntity offence = offenceRepository.getOffence(offenceId);
        if (offence != null) {
            return Response.ok(offence).build();
        } else {
            String msg = String.format("Offence # %d not found", offenceId);
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }

    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences/1 using Get request
    @GET
    @Path("OffenceType/{type}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getOffenceType(@PathParam("type") String offenceType) {
        List<OffenceEntity> offence = offenceRepository.getOffenceType(offenceType);
        if (offence != null) {
            return Response.ok(offence).build();
        } else {
            String msg = String.format("Offence # %d not found", offenceType);
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }

    /*You can test it using Postman App - http://www.getpostman.com/
     Url: http://localhost:8080/api/customers using Post request
    */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addOffence(OffenceEntity offence) {
        try {
            offence = offenceRepository.addOffence(offence);
            String location = String.format("/api/customers/%s", offence.getOffenceId());
            String msg = String.format("customer #%d created successfully", offence.getOffenceId());
            return Response.created(new URI(location)).entity(msg).build();
        } catch (Exception ex) {
            String msg = String.format("Adding customer failed because : %s",
                    ex.getCause().getMessage());
            return Response.serverError().entity(msg).build();
        }
    }

    /*You can test it using Postman App - http://www.getpostman.com/
     Url: http://localhost:8080/api/offences using Put request
    */
    @PUT
    @Path("offences/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateOffence(@PathParam("id") int id, OffenceEntity offence) {
//        offence.setOffenceId(id);
        try {
            offenceRepository.updateOffence(offence);
            String msg = String.format("Offence #%s updated sucessfully", offence.getOffenceId());
            return Response.ok(msg).build();
        } catch (Exception ex) {
            String msg = String.format("Updating offence failed because : \n%s",
                    ex.getMessage());
            return Response.serverError().entity(msg).build();
        }
    }

    /*You can test it using Postman App - http://www.getpostman.com/
     Url: http://localhost:8080/api/offences/1 using Delete request
     */
    @DELETE
    @Path("offences/{id}")
    public Response deleteOffence(@PathParam("id") int id) {
        try {
            offenceRepository.deleteOffence(id);
            String msg = String.format("offence #%s deleted sucessfully", id);
            return Response.ok(msg).build();
        } catch (Exception ex) {
            String msg = String.format("Deleting offence failed because : %s",
                    ex.getCause().getMessage());
            return Response.serverError().entity(msg).build();
        }
    }

    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences/countType using Get request
    @GET
    @Path("offences/countType")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffencesTypeCount(String offenceType) {
        int count = -1  ;
        count   = offenceRepository.getOffencesTypeCount(offenceType);
        if (count != -1) {
            return Response.ok(count).build();
        } else {
            String msg = String.format("Offence type count # %d not found", offenceType);
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }


    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences/count using Get request
    @GET
    @Path("offences/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffencesCount() {
        int count = -1  ;
        count   = offenceRepository.getOffencesCount();
        if (count != -1) {
            return Response.ok(count).build();
        } else {
            String msg = String.format("Offence type count # %d not found");
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }


    //------------------------Rewards-----------------------
    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/rewards using Get request
    @GET
    @Path("rewards")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RewardEntity> getRewards() {
        return offenceRepository.getRewards();
    }

    //You can test it using Postman App - http://www.getpostman.com/
    //Url: http://localhost:8080/api/offences/1 using Get request
    @GET
    @Path("rewards/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReward(@PathParam("id") int rewardsID) {
        RewardEntity reward = offenceRepository.getReward(rewardsID);
        if (reward != null) {
            return Response.ok(reward).build();
        } else {
            String msg = String.format("reward # %d not found", rewardsID);
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }

    /*You can test it using Postman App - http://www.getpostman.com/
     Url: http://localhost:8080/api/customers using Post request
    */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response addReward(RewardEntity reward) {
        try {
            reward = offenceRepository.addReward(reward);
            String location = String.format("/api/rewards/%s", reward.getRewardId());
            String msg = String.format("reward #%d created successfully", reward.getRewardId());
            return Response.created(new URI(location)).entity(msg).build();
        } catch (Exception ex) {
            String msg = String.format("Adding reward failed because : %s",
                    ex.getCause().getMessage());
            return Response.serverError().entity(msg).build();
        }
    }

}