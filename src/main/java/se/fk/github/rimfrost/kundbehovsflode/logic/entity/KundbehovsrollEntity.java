package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.util.UUID;

import org.immutables.value.Value;

import se.fk.github.rimfrost.kundbehovsflode.logic.enums.RollEntity;

@Value.Immutable
public interface KundbehovsrollEntity
{
   UUID id();

   IndividEntity individ();

   RollEntity roll();

   boolean yrkande();
}
