package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UsersApiService;
import io.swagger.api.factories.UsersApiServiceFactory;

import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.ws.rs.core.UriInfo;

@Path("/users")


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-06T21:50:39.597Z")
public class UsersApi  {
   private final UsersApiService delegate = UsersApiServiceFactory.getUsersApi();

    /*@POST
    
    
    @Produces({ "application/hal+json" })
    public Response createUser( User body,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.createUser(body,securityContext);
    }*/

    @DELETE
    @Path("/{username}")
    
    @Produces({ "application/hal+json" })
    public Response deleteUser( @PathParam("username") String username,@QueryParam("api_key") String apiKey)
    throws NotFoundException {
        return delegate.deleteUser(username,apiKey);
    }
    @GET
    @Path("/{username}")
    
    @Produces({ "application/hal+json" })
    public Response getUserByName( @PathParam("username") String username,@QueryParam("api_key") String apiKey, @Context UriInfo uri)
    throws NotFoundException {
        return delegate.getUserByName(username,apiKey, uri);
    }

    @PUT
    @Path("/{username}")
    @Consumes({"application/json"})
    @Produces({ "application/hal+json" })
    public Response updateUser( @PathParam("username") String username, User body, @QueryParam("api_key") String apiKey)
    throws NotFoundException {
        return delegate.updateUser(username,body,apiKey);
    }
}
