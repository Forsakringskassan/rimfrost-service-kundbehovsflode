package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

import se.fk.github.rimfrost.kundbehovsflode.logic.enums.RollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.VerksamhetslogikEntity;

@Value.Immutable
public interface UppgiftspecifikationEntity
{
   UUID id();

   String version();

   String namn();

   String uppgiftbeskrivning();

   VerksamhetslogikEntity verksamhetslogik();

   RollEntity roll();

   String applikationsId();

   String applikationsVersion();

   @Value.Default
   default List<RegelEntity> regel()
   {
      return List.of();
   }

   String uppgiftsGui();
}
