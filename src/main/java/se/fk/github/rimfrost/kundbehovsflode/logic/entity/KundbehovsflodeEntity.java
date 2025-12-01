package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovsflodeEntity
{
   UUID id();

   KundbehovEntity kundbehov();

   String version();

   UUID processinstansId();

   OffsetDateTime skapadTS();

   OffsetDateTime avslutadTS();

   KundbehovsflodespecifikationEntity kundbehovsspecifikation();
}
