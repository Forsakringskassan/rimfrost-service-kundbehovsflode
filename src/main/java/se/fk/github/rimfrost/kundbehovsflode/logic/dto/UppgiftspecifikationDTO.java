package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface UppgiftspecifikationDTO
{
   UUID id();

   String version();

   String namn();

   String uppgiftbeskrivning();

   VerksamhetslogikDTO verksamhetslogik();

   RollDTO roll();

   String applikationsId();

   String applikationsVersion();

   @Value.Default
   default List<RegelDTO> regel()
   {
      return List.of();
   }

   String uppgiftsGui();
}
