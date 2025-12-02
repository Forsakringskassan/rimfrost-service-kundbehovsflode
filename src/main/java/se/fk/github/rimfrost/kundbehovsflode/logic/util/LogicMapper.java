package se.fk.github.rimfrost.kundbehovsflode.logic.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableIndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutablePeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.IndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.PeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ErsattningEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.IndividEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsrollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.PeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ProduceratResultatEntity;

@ApplicationScoped
public class LogicMapper
{

   @Inject
   LogicEnumMapper logicEnumMapper;

   public KundbehovDTO toKundbehovDTO(KundbehovEntity kundbehovEntity)
   {
      if (kundbehovEntity == null)
      {
         return null;
      }

      return ImmutableKundbehovDTO.builder()
            .id(kundbehovEntity.id())
            .formanstyp(kundbehovEntity.formanstyp())
            .version(kundbehovEntity.version())
            .kundbehovsdatum(kundbehovEntity.kundbehovsdatum())
            .kundbehovsstatus(logicEnumMapper.toKundbehovsstatusDTO(kundbehovEntity.kundbehovsstatus()))
            .period(toPeriodDTO(kundbehovEntity.period()))
            .avsikt(logicEnumMapper.toAvsiktDTO(kundbehovEntity.avsikt()))
            .andringsorsak(kundbehovEntity.andringsorsak())
            .kundbehovsroll(kundbehovEntity.kundbehovsroll()
                  .stream()
                  .map(this::toKundbehovsrollDTO)
                  .toList())
            .ersattning(kundbehovEntity.ersattning()
                  .stream()
                  .map(this::toErsattningDTO)
                  .toList())
            .build();
   }

   public PeriodDTO toPeriodDTO(PeriodEntity periodEntity)
   {
      if (periodEntity == null)
      {
         return null;
      }

      return ImmutablePeriodDTO.builder()
            .start(periodEntity.start())
            .slut(periodEntity.slut())
            .build();
   }

   public KundbehovsrollDTO toKundbehovsrollDTO(KundbehovsrollEntity kundbehovsrollEntity)
   {
      if (kundbehovsrollEntity == null)
      {
         return null;
      }

      return ImmutableKundbehovsrollDTO.builder()
            .id(kundbehovsrollEntity.id())
            .individ(toIndividDTO(kundbehovsrollEntity.individ()))
            .roll(logicEnumMapper.toRollDTO(kundbehovsrollEntity.roll()))
            .yrkande(kundbehovsrollEntity.yrkande())
            .build();
   }

   public IndividDTO toIndividDTO(IndividEntity individEntity)
   {
      if (individEntity == null)
      {
         return null;
      }

      return ImmutableIndividDTO.builder()
            .id(individEntity.id())
            .fornamn(individEntity.fornamn())
            .efternamn(individEntity.efternamn())
            .build();
   }

   public ErsattningDTO toErsattningDTO(ErsattningEntity ersattningEntity)
   {
      if (ersattningEntity == null)
      {
         return null;
      }

      return ImmutableErsattningDTO.builder()
            .id(ersattningEntity.id())
            .belopp(ersattningEntity.belopp())
            .berakningsgrund(logicEnumMapper.toBerakningsgrundDTO(ersattningEntity.berakningsgrund()))
            .beloppstyp(logicEnumMapper.toBeloppstypDTO(ersattningEntity.beloppstyp()))
            .ersattningstyp(logicEnumMapper.toErsattningstypDTO(ersattningEntity.ersattningstyp()))
            .periodisering(logicEnumMapper.toPeriodiseringDTO(ersattningEntity.periodisering()))
            .omfattning(ersattningEntity.omfattning())
            .beslutsutfall(logicEnumMapper.toBeslutsutfallDTO(ersattningEntity.beslutsutfall()))
            .avslagsanledning(ersattningEntity.avslagsanledning())
            .produceratResultat(ersattningEntity.produceratResultat()
                  .stream()
                  .map(this::toProduceratResultatDTO)
                  .toList())
            .build();
   }

   public ProduceratResultatDTO toProduceratResultatDTO(ProduceratResultatEntity produceratResultatEntity)
   {
      if (produceratResultatEntity == null)
      {
         return null;
      }

      return ImmutableProduceratResultatDTO.builder()
            .id(produceratResultatEntity.id())
            .version(produceratResultatEntity.version())
            .franOchMed(produceratResultatEntity.franOchMed())
            .tillOchMed(produceratResultatEntity.tillOchMed())
            .status(logicEnumMapper.toErsattningsstatusDTO(produceratResultatEntity.status()))
            .build();
   }

}
