package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import org.immutables.value.Value;

@Value.Immutable
public interface UnderlagDTO
{

   String typ();

   String version();

   String data();

}
