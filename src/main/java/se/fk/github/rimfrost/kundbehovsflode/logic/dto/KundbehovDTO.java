package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovDTO
{
   UUID id();

   String formanstyp();

   String version();

   OffsetDateTime kundbehovsdatum();

   KundbehovsstatusDTO kundbehovsstatus();

   PeriodDTO period();

   AvsiktDTO avsikt();

   String andringsorsak();

   @Value.Default
   default List<KundbehovsrollDTO> kundbehovsroll()
   {
      return List.of();
   }

   @Value.Default
   default List<ErsattningDTO> ersattning()
   {
      return List.of();
   }
}
