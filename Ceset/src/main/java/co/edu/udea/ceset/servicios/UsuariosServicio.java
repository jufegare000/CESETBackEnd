package co.edu.udea.ceset.servicios;


import co.edu.udea.ceset.auth.AuthUtils;
import co.edu.udea.ceset.auth.Token;
import co.edu.udea.ceset.bl.PersonBL;
import co.edu.udea.ceset.bl.UsuarioBL;
import co.edu.udea.ceset.dto.entities.Person;
import co.edu.udea.ceset.dto.entities.Rol;
import co.edu.udea.ceset.dto.entities.Rolec;
import co.edu.udea.ceset.dto.entities.User;
import co.edu.udea.ceset.dto.entities.Usuario;
import com.nimbusds.jose.JOSEException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.management.relation.Role;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * Root resource (exposed at "usuarios" path)
 */
@Path("/usuarios")
public class UsuariosServicio implements Serializable {

    private static final long serialVersionUID = -9066585482051897942L;
    
    @Context
    SecurityContext securityContext;
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public void creatUser(User usr) {

    }
    
    @Context
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> obtenerPorId() {
        return UsuarioBL.getInstance().obtenerTodods();
    }
    // Mandar la información por post o por header y la clave la deben enviar encriptada. hs264 ejemplo.
    /**
     * Métdodo para autenticar un usuario.
     *
     * @param usuario a autenticar
     * @param clave cifrada del usuario
     * @return usuario en formatio JSON
     * @throws JOSEException
     */
    @POST
    @PermitAll
    @Path("/autenticar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response autenticar(User usuario) throws JOSEException, IOException {
        //int rol = 0;
        User usuarioAutenticado;
        usuarioAutenticado = UsuarioBL.getInstance().autenticar(usuario);
        Token token;
        String mensaje;

        if (usuarioAutenticado != null) {
            // Devuelves un Response con un entity de tipo Token. 
            // En el token están los datos del usuario autenticado
            token = AuthUtils.createToken("auth-backend", usuarioAutenticado);
            return Response.status(200)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(token)
                    .build();
        }else{
            mensaje = "El usuario o la contraseña son incorrectos";
            return Response.status(403)
                    .entity(mensaje)
                    .build();
        }
        
        
    }

   
    /**
     * Método que retorna un Usuario dado un id
     *
     * @param id : id del Usuario
     * @return Usuario : Usuario en formato Json
     */
    @GET
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public User obtenerPorId(@PathParam("idUser") int id) {
        return UsuarioBL.getInstance().obtenerPorId(id);
    } 

}
