package se.fk.github.rimfrost.kundbehovsflode.presentation;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.KundbehovService;
import se.fk.github.rimfrost.kundbehovsflode.presentation.util.PresentationMapper;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.KundbehovControllerApi;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovResponse;

public class KundbehovsController implements KundbehovControllerApi
{

   @Inject
   KundbehovService kundbehovService;

   @Inject
   PresentationMapper presentationMapper;

   @Override
   public PostKundbehovResponse postKundbehov(@Valid @NotNull PostKundbehovRequest postKundbehovRequest)
   {
      KundbehovCreateRequest kundbehovCreateRequest = presentationMapper.toKundbehovCreateRequest(postKundbehovRequest);
      KundbehovCreateResponse kundbehovCreateResponse = kundbehovService.createKundbehov(kundbehovCreateRequest);
      PostKundbehovResponse response = presentationMapper.toPostKundbehovResponse(kundbehovCreateResponse);
      return response;
   }

}
