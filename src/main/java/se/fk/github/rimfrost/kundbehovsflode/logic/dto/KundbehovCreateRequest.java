package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.time.OffsetDateTime;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovCreateRequest
{
   public String persnr();

   public String formanstyp();

   public OffsetDateTime start();

   public OffsetDateTime slut();
}
