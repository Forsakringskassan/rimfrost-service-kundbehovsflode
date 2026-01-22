package se.fk.github.rimfrost.kundbehovsflode.logic.entity;

import java.util.UUID;

import org.immutables.value.Value;

import jakarta.annotation.Nullable;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeloppstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BerakningsgrundEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeslutsutfallEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.ErsattningstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.PeriodiseringEntity;

@Value.Immutable
public interface ErsattningEntity
{
   UUID id();

   Integer belopp();

   BerakningsgrundEntity berakningsgrund();

   BeloppstypEntity beloppstyp();

   ErsattningstypEntity ersattningstyp();

   PeriodiseringEntity periodisering();

   Integer omfattning();

   BeslutsutfallEntity beslutsutfall();

   @Nullable
   String avslagsanledning();

   ProduceratResultatEntity produceratResultat();
}
