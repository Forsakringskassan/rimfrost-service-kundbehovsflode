package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface ErsattningDTO
{
   UUID id();

   Integer belopp();

   BerakningsgrundDTO berakningsgrund();

   BeloppstypDTO beloppstyp();

   ErsattningstypDTO ersattningstyp();

   PeriodiseringDTO periodisering();

   Integer omfattning();

   BeslutsutfallDTO beslutsutfall();

   String avslagsanledning();

   ProduceratResultatDTO produceratResultat();
}
