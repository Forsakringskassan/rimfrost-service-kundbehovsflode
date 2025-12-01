package se.fk.github.rimfrost.kundbehovsflode.presentation;

import java.util.UUID;

import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.KundbehovsflodeControllerApi;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetKundbehovsflodeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovsflodeRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovsflodeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PutKundbehovsflodeRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PutKundbehovsflodeResponse;

public class KundbehovsflodeController implements KundbehovsflodeControllerApi
{

   @Override
   public GetKundbehovsflodeResponse getKundbehovsflode(UUID kundbehovsflodeId)
   {
      /** /kundbehovsflode/{kundbehovsflodeId} */
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public PostKundbehovsflodeResponse postKundbehovsflode(PostKundbehovsflodeRequest postKundbehovsflodeRequest)
   {
      /** /kundbehovsflode/ */
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public PutKundbehovsflodeResponse putKundbehovsflode(UUID kundbehovsflodeId,
         PutKundbehovsflodeRequest putKundbehovsflodeRequest)
   {
      /** /kundbehovsflode/{kundbehovsflodeId} */

      throw new UnsupportedOperationException("Not supported yet.");
   }

}
