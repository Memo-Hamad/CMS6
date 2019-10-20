package main.jpa.service;


import java.net.URI;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.jpa.entity.CustomerEntity;
import main.jpa.entity.PaymentEntity;
import main.jpa.repository.IPaymentRepository;


@Path("/api/Payment")
@ApplicationScoped
public class PaymentService {


    @Inject IPaymentRepository PaymentRepository;
    private int Decid;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<PaymentEntity> getPayments() {return (List<PaymentEntity>) PaymentRepository.getPayment(Decid);}

    @GET
    @Path("/{Declarationid}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getPayment(@PathParam("Declarationid") int DeclarationId) {
        PaymentEntity Payment = PaymentRepository.getPayment2(DeclarationId);

        if (Payment != null) {
            return Response.ok(Payment).build();
        } else {
            String msg = String.format("Customer # %d not found", DeclarationId);
            return Response.status(Response.Status.NOT_FOUND).entity(msg).build();
        }
    }



    //http://localhost:8080/api/Payment/{Decid}/Payment
    @POST
    @Path("/{Decid}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response Postpayment(@PathParam("Decid") int DeclarationId, PaymentEntity Pay) {
        String msg;
        try {
            Pay = this.PaymentRepository.addPayment(Pay);

            String location = String.format("/jpa/%d/Payments/%s", DeclarationId, Pay.getDeclarationByDeclarationId());
            msg = String.format("Payment done successfully", Pay.getDeclarationByDeclarationId());
            return Response.created(new URI(location)).entity(msg).build();
        } catch (Exception var5) {
            msg = String.format("Payment failed : %s", var5.getCause().getMessage());
            return Response.serverError().entity(msg).build();
        }
    }




}
