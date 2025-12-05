package se.fk.github.rimfrost.kundbehovsflode.integration;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.*;

@ApplicationScoped
public class KafkaProducer
{

   @Channel("vah-kundbehovsflode-requests")
   Emitter<VahKundbehovsflodeRequestMessagePayload> vahEmitter;

   public void sendVahRequestMessage(UUID kundbehovsflodeId)
   {
      var data = new VahKundbehovsflodeRequestMessageData();
      data.setKundbehovsflodeId(kundbehovsflodeId.toString());

      var payload = new VahKundbehovsflodeRequestMessagePayload();
      payload.setId(kundbehovsflodeId.toString());
      payload.setData(data);
      payload.setType("vah-kundbehovsflode-requests");
      payload.setSource("/service/kundbehovsflode");
      payload.setTime(OffsetDateTime.now());
      payload.setSpecversion(SpecVersion.NUMBER_1_DOT_0);
      payload.setKogitoproctype(KogitoProcType.BPMN);
      vahEmitter.send(payload);
   }

    @Channel("kundbehovsflode-done")
    Emitter<KundbehovsflodeDoneMessage> kundbehovsflodeDoneMessageEmitter;
    public void sendKundbehovsflodeDone(UUID kundbehovsflodeId)
    {
        var payload = new KundbehovsflodeDoneMessage();
        payload.setKundbehovsflodeId(kundbehovsflodeId.toString());
        kundbehovsflodeDoneMessageEmitter.send(payload);
    }
}
