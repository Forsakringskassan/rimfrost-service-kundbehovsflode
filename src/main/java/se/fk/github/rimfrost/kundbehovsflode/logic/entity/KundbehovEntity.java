package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.immutables.value.Value;

import se.fk.github.rimfrost.kundbehovsflode.logic.enums.AvsiktEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.KundbehovsstatusEntity;

@Value.Immutable
public interface KundbehovEntity
{
   UUID id();

   String formanstyp();

   String version();

   OffsetDateTime kundbehovsdatum();

   KundbehovsstatusEntity kundbehovsstatus();

   PeriodEntity period();

   AvsiktEntity avsikt();

   String andringsorsak();

   @Value.Default
   default List<KundbehovsrollEntity> kundbehovsroll()
   {
      return List.of();
   }

   @Value.Default
   default List<ErsattningEntity> ersattning()
   {
      return List.of();
   }
}
