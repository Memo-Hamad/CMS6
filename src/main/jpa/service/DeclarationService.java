package main.jpa.service;

import java.net.URI;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
import main.jpa.entity.DeclarationEntity;
import main.jpa.repository.IDeclarationRepository;

@Path("/api/declarations")

@ApplicationScoped
public class DeclarationService {
//
//    @Inject
//    IDeclarationRepository declarationRepository;
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public List<DeclarationEntity> getDeclarations() {
//        return declarationRepository.getDeclarations();
//    }
//
//    //SA comment: search declaration by many features
//
//    @GET
//    @Path("/Search") //SA comment: Add "Search?decType=I&decPortType=S" to function
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<DeclarationEntity> searchDeclarations(@Context UriInfo uriInfo) {
//
//        /** read complete declaration info list from request query parameter**/
//
//        DeclarationTypeEntity decType = uriInfo.getQueryParameters().get("decType");
//
//        int decId = uriInfo.getQueryParameters().get("decId");
//
//        DeclarationStatusEntity decStatus = uriInfo.getQueryParameters().get("decStatus");
//
//        Timestamp decSubmittedOn = uriInfo.getQueryParameters().get("decSubmittedOn");
//
//        PortEntity decPortType = uriInfo.getQueryParameters().get("decPortType");
//
//        AgentEntity decAgentId = uriInfo.getQueryParameters().get("decAgentId");
//
//        return declarationRepository.searchDeclarations(DeclarationTypeEntity decType,
//
//        int decId,
//
//        DeclarationStatusEntity decStatus,
//
//        Timestamp decSubmittedOn,
//
//        PortEntity decPortType,
//
//        AgentEntity decAgentId);
//
//    }
//
//    /*You can test it using Postman App - http://www.getpostman.com/
//    Url: http://localhost:8080/api/declarations/{id} using Put request
//   */
//    //SA comment: search declaration by decID
//    @GET
//    @Path("declarations/{decId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getDeclaration(@PathParam("decId") int decId) {
//
//        DeclarationEntity declaration = declarationRepository.getDeclaration(decId);
//
//        if (declaration != null) {
//
//            return Response.ok(declaration).build();
//
//        } else {
//
//            String msg = String.format("Declaration # %d not found", decId);
//
//            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
//        }
//    }
//
//
//    //SA comment: Submit Declaration
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response addDeclaration(DeclarationEntity dec) {
//        try {
//            dec = declarationRepository.addDeclaration(dec);
//            String location = String.format("/api/declarations/%s", dec.getDeclarationId());
//            String msg = String.format("Declaration #%d created successfully",dec.getDeclarationId());
//            return Response.created(new URI(location)).entity(msg).build();
//        } catch (Exception ex) {
//            String msg = String.format("Adding declarations failed because : %s",
//                    ex.getCause().getMessage());
//            return Response.serverError().entity(msg).build();
//        }
//    }
//
//
//
//    //SA comment: Update Declaration
//     /*You can test it using Postman App - http://www.getpostman.com/
//     Url: http://localhost:8080/api/declarations using Put request
//    */
//    @PUT
//    @Path("declarations/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public Response updateOffence(@PathParam("id") int id, DeclarationEntity dec) {
////        offence.setOffenceId(id);
//        try {
//            declarationRepository.updateDeclaration(dec);
//            String msg = String.format("Dec #%s updated sucessfully", dec.getDeclarationId());
//            return Response.ok(msg).build();
//        } catch (Exception ex) {
//            String msg = String.format("Updating dec failed because : \n%s",
//                    ex.getMessage());
//            return Response.serverError().entity(msg).build();
//        }
//    }


}
