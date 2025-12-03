package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.immutables.value.Value;

import jakarta.annotation.Nullable;

@Value.Immutable
public interface KundbehovsflodeDTO
{
   UUID id();

   KundbehovDTO kundbehov();

   String version();

   UUID processinstansId();

   OffsetDateTime skapadTS();

   @Nullable
   OffsetDateTime avslutadTS();

   KundbehovsflodespecifikationDTO kundbehovsspecifikation();
}
