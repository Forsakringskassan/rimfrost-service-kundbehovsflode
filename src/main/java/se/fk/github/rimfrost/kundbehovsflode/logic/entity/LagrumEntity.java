package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface LagrumEntity
{
   UUID id();

   String version();

   OffsetDateTime giltigFrom();

   OffsetDateTime giltigTom();

   String forfattning();

   String kapitel();

   String paragraf();

   String stycke();

   String punkt();
}
