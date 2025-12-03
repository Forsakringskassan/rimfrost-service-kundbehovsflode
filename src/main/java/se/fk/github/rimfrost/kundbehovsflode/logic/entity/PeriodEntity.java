package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.time.OffsetDateTime;

import org.immutables.value.Value;

@Value.Immutable
public interface PeriodEntity
{
   OffsetDateTime start();

   OffsetDateTime slut();
}
