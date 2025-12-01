package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.time.OffsetDateTime;

import org.immutables.value.Value;

@Value.Immutable
public interface PeriodDTO
{
   OffsetDateTime start();

   OffsetDateTime slut();
}
