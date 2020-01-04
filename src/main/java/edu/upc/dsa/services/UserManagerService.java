package edu.upc.dsa.services;

import edu.upc.dsa.UserDAO;
import edu.upc.dsa.UserDAOImpl;
import edu.upc.dsa.UserNotFoundException;
import edu.upc.dsa.models.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//API Return codes (!! AT TRYs/CATCHES DISCRIMINATE WHICH IS THE CATCH REASON, NOT THROW EXCEPTIONS !!): 200, 201, 400, 404, 507
//@ApiResponse(code = 200, message = "Successful")
//@ApiResponse(code = 201, message = "Successfully Created")
//@ApiResponse(code = 400, message = "Bad Request (Error in input parameters' format)")
//@ApiResponse(code = 404, message = "Not Found")
//@ApiResponse(code = 507, message = "Insufficient Storage")

@Api(value = "/usermanager", description = "Users/Players Manager service")
@Path("/usermanager")

public class UserManagerService {

    private UserDAO us;

    public UserManagerService() {
        this.us = UserDAOImpl.getInstance();
    }


    @GET
    @ApiOperation(value = "Login", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User Not Found")
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User userin) {
        try {
            User userout = this.us.loginUser(userin);
            return Response.status(200).entity(userout).build();
        }
        catch (UserNotFoundException e) { //(userout == null             ???????????  Quitar las exceptions)
            return Response.status(404).build();
        }
    }


    @GET
    @ApiOperation(value = "Get the list of all Users", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class, responseContainer = "List"),
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> listaUs = this.us.getUsers();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(listaUs){};
        return Response.status(200).entity(entity).build();
    }



    @GET
    @ApiOperation(value = "Get User stats (User class) given its name", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "User Not Found")
    })
    @Path("/users/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("name") String name) {

        //(Julen está trabajando en esto)

        // User u = this.us.getUser(name);
        // if (u == null) return Response.status(404).build();
        // else return Response.status(201).entity(u).build();
        return null; //
    }



/*  @GET
    @ApiOperation(value = "Get the stats of a given User", notes = "Expresadas en formato de Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful (Respuesta correcta)", response = Usuario.class),
            @ApiResponse(code = 404, message = "Not Found (Usuario no encontrado)")
    })
    @Path("/getEstadisticas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser() {
        Usuario u = this.us.getUser();
        if (u == null) return Response.status(404).build();
        else return Response.status(201).entity(u).build();
    }*/



    @POST
    @ApiOperation(value = "Create a new user", notes = " ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Successfully Created", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request (Error in input parameters' format)"),
            @ApiResponse(code = 507, message = "Insufficient Storage")
    })
    @Path("/newuser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(User us) {

        /*if (jugador.getNombre()==null)  return Response.status(500).entity(jugador).build();
        this.tm.addJugador(jugador.getId(), jugador.getNombre(), jugador.getApellido());
        int i=0;
        while(i<jugador.getObjetos().size()) {
            this.tm.addObjeto(jugador.getObjetos().get(i).getNombre(), jugador.getId());
            i++;
        }
        return Response.status(201).entity(jugador).build();*/

        this.us.addUser(us.getUsername(), us.getPassword());
        // crear UserObject
        // bool true = bien registrado
        // bool false = ya existe → BUSCAR CÓDIGO HTTP

        return null; //
    }



    /*@GET    //consultar objetos de un jugador
    @ApiOperation(value = "Get objetos from a Jugador", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "User not found")

    })
    @Path("/getObjetos/{idjugador}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetos(@PathParam("idjugador") String id) {
        List<Objeto> objetos = tm.consultarJugador(id).getObjetos();
        if (objetos == null) return Response.status(404).build()  ;
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
        return Response.status(201).entity(entity).build()  ;

    }*/



/*  @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newJugador(Usuario jugador) {

        if (jugador.getNombre()==null)  return Response.status(500).entity(jugador).build();
        this.tm.addJugador(jugador.getId(), jugador.getNombre(), jugador.getApellido());
        int i=0;
        while(i<jugador.getObjetos().size()) {
           this.tm.addObjeto(jugador.getObjetos().get(i).getNombre(), jugador.getId());
           i++;
        }
        return Response.status(201).entity(jugador).build();
    }*/



    /*@POST  //añadir un objeto a un jugador
    @ApiOperation(value = "create a new Object", notes = "crear nuevo objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Object.class),
            @ApiResponse(code = 500, message = "Error, intenta de nuevo")

    })
    @Path("/jugador/{idjugador}/objeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjecto(Objeto o,@PathParam("idjugador") String id ) {

        if (o.getNombre()== null) return Response.status(500).entity(o).build();
        this.tm.addObjeto(o.getNombre(), id);

        return Response.status(201).entity(o).build();
    }*/



    /*@PUT
    @ApiOperation(value = "Modificar un Usuario", notes = "debes poner el id del usuario que quieres cambiar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Jugador not found")
    })
    @Path("/modJugador")
    public Response updateJugador(Usuario jug) {
        Usuario t = this.tm.updateJugador(jug);
        if (t == null) return Response.status(404).build();
        return Response.status(201).build();
    }*/



}

