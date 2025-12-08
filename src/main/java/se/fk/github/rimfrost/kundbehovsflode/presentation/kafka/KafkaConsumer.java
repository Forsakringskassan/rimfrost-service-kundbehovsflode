package se.fk.github.rimfrost.kundbehovsflode.presentation.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import se.fk.github.logging.callerinfo.model.MDCKeys;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.impl.KundbehovsflodeServiceImpl;
import se.fk.rimfrost.VahKundbehovsflodeResponseMessagePayload;

import java.util.UUID;

@ApplicationScoped
public class KafkaConsumer
{

   private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

   @Inject
   KundbehovsflodeServiceImpl kundbehovsflodeService;

   @Incoming("vah-kundbehovsflode-responses")
   public void onVahKundbehovsFlodeResponse(VahKundbehovsflodeResponseMessagePayload vahKundbehovsflodeResponseMessagePayload)
   {
      MDC.put(MDCKeys.PROCESSID.name(), vahKundbehovsflodeResponseMessagePayload.getData().getKundbehovsflodeId());
      LOGGER.info(
            "VahKundbehovsflodeResponseMessagePayload received with KundbehovsflodeId: "
                  + vahKundbehovsflodeResponseMessagePayload.getData().getKundbehovsflodeId());
      kundbehovsflodeService.sendKundbehovsflodeDoneMessage(
            UUID.fromString(vahKundbehovsflodeResponseMessagePayload.getData().getKundbehovsflodeId()));
   }

}
