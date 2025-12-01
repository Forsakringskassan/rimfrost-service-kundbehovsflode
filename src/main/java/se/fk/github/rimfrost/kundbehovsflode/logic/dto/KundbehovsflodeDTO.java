package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovsflodeDTO
{
   UUID id();

   KundbehovDTO kundbehov();

   String version();

   UUID processinstansId();

   OffsetDateTime skapadTS();

   OffsetDateTime avslutadTS();

   KundbehovsflodespecifikationDTO kundbehovsspecifikation();
}
