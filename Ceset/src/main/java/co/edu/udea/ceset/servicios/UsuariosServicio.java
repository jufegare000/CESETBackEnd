package co.edu.udea.ceset.servicios;


import co.edu.udea.ceset.auth.AuthUtils;
import co.edu.udea.ceset.auth.Token;
import co.edu.udea.ceset.bl.UsuarioBL;
import co.edu.udea.ceset.dto.Rol;
import co.edu.udea.ceset.dto.Rolec;
import co.edu.udea.ceset.dto.User;
import co.edu.udea.ceset.dto.Usuario;
import com.nimbusds.jose.JOSEException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> obtenerPorId() {
        return UsuarioBL.getInstance().obtenerTodods();
    }
    
    /**
     * Métdodo para autenticar un usuario.
     *
     * @param usuario a autenticar
     * @param clave cifrada del usuario
     * @return usuario en formatio JSON
     * @throws JOSEException
     */
    @GET
    @PermitAll
    @Path("/autenticar")
    @Produces("application/json")
    public Response autenticar(
            @QueryParam("usuario") String usuario,
            @QueryParam("clave") String clave,
            @QueryParam("rol") int rol) throws JOSEException, IOException {
        
                User usuarioAutenticado;
                usuarioAutenticado = UsuarioBL.getInstance().autenticar(usuario, clave);

                if (usuarioAutenticado != null) {
                    // Verifico si el usuario tiene permisos para entrar con el rol elegido
                    for (Iterator<Rolec> it = usuarioAutenticado.getRoles().iterator(); it.hasNext();) {
                        Rolec rolIt = it.next();
                        if (rolIt.getIdRole()== rol) {
                            Token token = AuthUtils.createToken("auth-backend", usuarioAutenticado, rol);
                            return Response.status(200)
                                    .type(MediaType.APPLICATION_JSON)
                                    .entity(token)
                                    .build();
                        }
                    }
                }
        
        return null;

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
