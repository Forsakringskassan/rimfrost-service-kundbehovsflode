package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface RegelEntity
{
   UUID id();

   String version();

   LagrumEntity lagrum();
}
