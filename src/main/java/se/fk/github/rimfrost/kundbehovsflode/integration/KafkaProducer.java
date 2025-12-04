package se.fk.github.rimfrost.kundbehovsflode.integration;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.KogitoProcType;
import se.fk.rimfrost.SpecVersion;
import se.fk.rimfrost.VahKundbehovsflodeRequestMessageData;
import se.fk.rimfrost.VahKundbehovsflodeRequestMessagePayload;

@ApplicationScoped
public class KafkaProducer
{

   @Channel("vah-kundbehovsflode-requests")
   Emitter<VahKundbehovsflodeRequestMessagePayload> emitter;

   public void sendVahRequestMessage(UUID kundebehovsflodeId)
   {

      System.out.println("SKICKAR MESSAGE!");
      var data = new VahKundbehovsflodeRequestMessageData();
      data.setKundbehovsflodeId(kundebehovsflodeId.toString());

      var payload = new VahKundbehovsflodeRequestMessagePayload();
      payload.setId(kundebehovsflodeId.toString());
      payload.setData(data);
      payload.setType("vah-kundbehovsflode-requests");
      payload.setSource("/service/kundbehovsflode");
      payload.setTime(OffsetDateTime.now());
      payload.setSpecversion(SpecVersion.NUMBER_1_DOT_0);
      payload.setKogitoproctype(KogitoProcType.BPMN);
      emitter.send(payload);
   }

}
