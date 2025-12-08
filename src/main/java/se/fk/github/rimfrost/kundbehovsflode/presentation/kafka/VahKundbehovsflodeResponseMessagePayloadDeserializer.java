package se.fk.github.rimfrost.kundbehovsflode.presentation.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.fk.rimfrost.VahKundbehovsflodeResponseMessagePayload;

public class VahKundbehovsflodeResponseMessagePayloadDeserializer
      extends ObjectMapperDeserializer<VahKundbehovsflodeResponseMessagePayload>
{

   public VahKundbehovsflodeResponseMessagePayloadDeserializer()
   {
      super(VahKundbehovsflodeResponseMessagePayload.class);
   }

}
