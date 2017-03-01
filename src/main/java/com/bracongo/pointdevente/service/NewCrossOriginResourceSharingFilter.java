package com.bracongo.pointdevente.service;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author vr.kenfack
 */
@Provider
public class NewCrossOriginResourceSharingFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext response) {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTION");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
        requestContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        requestContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, OPTION");
        requestContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type");
    }
    
}
