package se.fk.github.rimfrost.kundbehovsflode.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.KundbehovService;
import se.fk.github.rimfrost.kundbehovsflode.presentation.util.PresentationMapper;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.KundbehovControllerApi;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovResponse;

@ApplicationScoped
@Path("/kundbehov")
public class KundbehovsController implements KundbehovControllerApi
{

   @Inject
   KundbehovService kundbehovService;

   @Inject
   PresentationMapper mapper;

   @Override
   @POST
   @Consumes(
   {
         "application/json"
   })
   @Produces(
   {
         "application/json"
   })
   public PostKundbehovResponse postKundbehov(@Valid @NotNull PostKundbehovRequest postKundbehovRequest)
   {
      KundbehovCreateRequest kundbehovCreateRequest = mapper.toKundbehovCreateRequest(postKundbehovRequest);
      KundbehovCreateResponse kundbehovCreateResponse = kundbehovService.createKundbehov(kundbehovCreateRequest);
      PostKundbehovResponse response = mapper.toPostKundbehovResponse(kundbehovCreateResponse);
      return response;
   }

}
