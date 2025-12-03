package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface RegelDTO
{
   UUID id();

   String version();

   @Value.Default
   default List<LagrumDTO> lagrum()
   {
      return List.of();
   }
}
