package se.fk.github.rimfrost.handlaggning.logic.entity;

import java.time.OffsetDateTime;
import org.immutables.value.Value;

@Value.Immutable
public interface PeriodEntity
{
   OffsetDateTime start();

   OffsetDateTime slut();
}
