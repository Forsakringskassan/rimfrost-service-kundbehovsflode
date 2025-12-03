package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovsflodespecifikationDTO
{
   UUID id();

   String version();

   String bpmn();

   String namn();

   String beskrivning();

   @Value.Default
   default List<UppgiftspecifikationDTO> uppgiftspecifikation()
   {
      return List.of();
   }
}
