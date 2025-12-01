package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface RegelEntity
{
   UUID id();

   String version();

   @Value.Default
   default List<LagrumEntity> lagrum()
   {
      return List.of();
   }
}
