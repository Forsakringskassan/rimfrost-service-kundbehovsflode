package se.fk.github.rimfrost.handlaggning.logic.entity;

import org.immutables.value.Value;

@Value.Immutable
public interface IndividEntity
{
   String id();

   String fornamn();

   String efternamn();
}
