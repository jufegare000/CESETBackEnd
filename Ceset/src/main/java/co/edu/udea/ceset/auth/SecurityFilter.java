/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ceset.auth;

import co.edu.udea.ceset.dao.UsuarioDAO;
import co.edu.udea.ceset.dto.Rol;
import co.edu.udea.ceset.dto.Usuario;
import co.edu.udea.ceset.excepciones.AuthenticationException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import org.joda.time.DateTime;

/**
 *
 * @author edevargas Filtro de autenticación para el llamado de los web
 * serivices
 */
@Provider
@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {
    @Context
    HttpHeaders headers;

    private static final String EXPIRE_ERROR_MSG = "El token ha expirado",
            JWT_ERROR_MSG = "No se puede convertir a JWT",
            JWT_INVALID_MSG = "Token JWT inválido";
    private final String UNIDAD_PERSISTENCIA = "seguimiento_docente_PU";

    private UsuarioDAO obtenerUsuarioDAO() {
        UsuarioDAO DAO = new UsuarioDAO();
        return DAO;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext originalContext = requestContext.getSecurityContext();
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        
        // Si el método de la petición Http es OPTIONS no es necesario validar el token
//        if (!requestContext.getMethod().equals("OPTIONS")) {
//
//            // Si no posee Token o está incorrecto se meustra mensaje de error 
//            if (authHeader == null || authHeader.isEmpty() || authHeader.split(" ").length != 2) {
//                throw new AuthenticationException("Usted no cuenta con permisos para llamar el WebService.");
//            } else {
//                JWTClaimsSet claimSet;
//                try {
//                    claimSet = (JWTClaimsSet) AuthUtils.decodeToken(authHeader);
//                } catch (ParseException e) {
//                    throw new IOException(JWT_ERROR_MSG);
//                } catch (JOSEException e) {
//                    throw new IOException(JWT_INVALID_MSG);
//                }
//
//                // Verificamos que el token no haya expirado
//                if (claimSet.getExpirationTime() == null) {
//                    throw new AuthenticationException("El Token de autenticación no cuenta con Fecha de expiración.");
//                }
//                if (new DateTime(claimSet.getExpirationTime()).isBefore(DateTime.now())) {
//                    throw new IOException(EXPIRE_ERROR_MSG);
//                } else {
//                    // Si el Subject del claim está vacío indica que se iniciará sesión por primera vez
//                    if (claimSet.getSubject() == null || claimSet.getSubject().isEmpty()) {
//                        // Creamos un usuario vacío
//                        Authorizer authorizer = new Authorizer(new ArrayList<Rol>(), "",
//                                originalContext.isSecure());
//                        requestContext.setSecurityContext(authorizer);
//                    } else {
//                        // CAMBIAR TIPO USUARIO
//                        Usuario user = obtenerUsuarioDAO().obtenerPorId(Integer.parseInt(claimSet.getSubject()));
//                        Authorizer authorizer = new Authorizer(user.getRoles(), user.getNombreUsuario(),
//                                originalContext.isSecure());
//                        requestContext.setSecurityContext(authorizer);
//                    }
//
//                }
//            }
//        }

    }

    public static class Authorizer implements SecurityContext {

        List<Rol> roles;//Muchos a muchos Roles - Usuarios
        String username;
        boolean isSecure;

        public Authorizer(List<Rol> roles, String username, boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String rol) {
            return roles.contains(new Rol(Integer.parseInt(rol)));//Muchos a muchos
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "JWT Authentication";
        }
    }

    public static class User implements Principal {

        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
