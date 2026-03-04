package se.fk.github.rimfrost.handlaggning.logic.entity;

import java.util.UUID;
import org.immutables.value.Value;
import se.fk.github.rimfrost.handlaggning.logic.enums.RollEntity;

@Value.Immutable
public interface YrkanderollEntity
{
   UUID id();

   IndividEntity individ();

   RollEntity roll();

   boolean yrkande();
}
