package se.fk.github.rimfrost.kundbehovsflode.logic.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableIndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodespecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableLagrumDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutablePeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableRegelDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableUppgiftspecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.IndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodespecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.LagrumDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.PeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.RegelDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.UppgiftspecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ErsattningEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.IndividEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodeEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodespecifikationEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsrollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.LagrumEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.PeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ProduceratResultatEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.RegelEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.UppgiftspecifikationEntity;

@ApplicationScoped
public class LogicMapper
{

   @Inject
   LogicEnumMapper enumMapper;

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
            .kundbehovsstatus(enumMapper.toKundbehovsstatusDTO(kundbehovEntity.kundbehovsstatus()))
            .period(toPeriodDTO(kundbehovEntity.period()))
            .avsikt(enumMapper.toAvsiktDTO(kundbehovEntity.avsikt()))
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
            .roll(enumMapper.toRollDTO(kundbehovsrollEntity.roll()))
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
            .berakningsgrund(enumMapper.toBerakningsgrundDTO(ersattningEntity.berakningsgrund()))
            .beloppstyp(enumMapper.toBeloppstypDTO(ersattningEntity.beloppstyp()))
            .ersattningstyp(enumMapper.toErsattningstypDTO(ersattningEntity.ersattningstyp()))
            .periodisering(enumMapper.toPeriodiseringDTO(ersattningEntity.periodisering()))
            .omfattning(ersattningEntity.omfattning())
            .beslutsutfall(enumMapper.toBeslutsutfallDTO(ersattningEntity.beslutsutfall()))
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
            .status(enumMapper.toErsattningsstatusDTO(produceratResultatEntity.status()))
            .build();
   }

   public KundbehovsflodeDTO toKundbehovsflodeDTO(KundbehovsflodeEntity kundbehovsflodeEntity)
   {
      if (kundbehovsflodeEntity == null)
      {
         return null;
      }

      KundbehovsflodeDTO kundbehovsflodeDTO = ImmutableKundbehovsflodeDTO.builder()
            .id(kundbehovsflodeEntity.id())
            .kundbehov(toKundbehovDTO(kundbehovsflodeEntity.kundbehov()))
            .version(kundbehovsflodeEntity.version())
            .processinstansId(kundbehovsflodeEntity.processinstansId())
            .skapadTS(kundbehovsflodeEntity.skapadTS())
            .avslutadTS(kundbehovsflodeEntity.avslutadTS())
            .kundbehovsspecifikation(toKundbehovsflodespecifikationDTO(kundbehovsflodeEntity.kundbehovsspecifikation()))
            .build();

      return kundbehovsflodeDTO;
   }

   public KundbehovsflodespecifikationDTO toKundbehovsflodespecifikationDTO(
         KundbehovsflodespecifikationEntity kundbehovsflodespecifikationEntity)
   {
      if (kundbehovsflodespecifikationEntity == null)
      {
         return null;
      }

      KundbehovsflodespecifikationDTO kundbehovsflodespecifikationDTO = ImmutableKundbehovsflodespecifikationDTO.builder()
            .id(kundbehovsflodespecifikationEntity.id())
            .version(kundbehovsflodespecifikationEntity.version())
            .bpmn(kundbehovsflodespecifikationEntity.bpmn())
            .namn(kundbehovsflodespecifikationEntity.namn())
            .beskrivning(kundbehovsflodespecifikationEntity.beskrivning())
            .uppgiftspecifikation(
                  kundbehovsflodespecifikationEntity.uppgiftspecifikation()
                        .stream()
                        .map(this::toUppgiftspecifikationDTO)
                        .toList())
            .build();

      return kundbehovsflodespecifikationDTO;
   }

   public UppgiftspecifikationDTO toUppgiftspecifikationDTO(UppgiftspecifikationEntity uppgiftspecifikationEntity)
   {
      if (uppgiftspecifikationEntity == null)
      {
         return null;
      }

      UppgiftspecifikationDTO uppgiftspecifikationDTO = ImmutableUppgiftspecifikationDTO.builder()
            .id(uppgiftspecifikationEntity.id())
            .version(uppgiftspecifikationEntity.version())
            .namn(uppgiftspecifikationEntity.namn())
            .uppgiftbeskrivning(uppgiftspecifikationEntity.uppgiftbeskrivning())
            .verksamhetslogik(enumMapper.toVerksamhetslogikDTO(uppgiftspecifikationEntity.verksamhetslogik()))
            .roll(enumMapper.toRollDTO(uppgiftspecifikationEntity.roll()))
            .applikationsId(uppgiftspecifikationEntity.applikationsId())
            .applikationsVersion(uppgiftspecifikationEntity.applikationsVersion())
            .regel(
                  uppgiftspecifikationEntity.regel()
                        .stream()
                        .map(this::toRegelDTO)
                        .toList())
            .uppgiftsGui(uppgiftspecifikationEntity.uppgiftsGui())
            .build();

      return uppgiftspecifikationDTO;
   }

   public RegelDTO toRegelDTO(RegelEntity regelEntity)
   {
      if (regelEntity == null)
      {
         return null;
      }

      RegelDTO regelDTO = ImmutableRegelDTO.builder()
            .id(regelEntity.id())
            .version(regelEntity.version())
            .lagrum(
                  regelEntity.lagrum()
                        .stream()
                        .map(this::toLagrumDTO)
                        .toList())
            .build();

      return regelDTO;
   }

   public LagrumDTO toLagrumDTO(LagrumEntity lagrumEntity)
   {
      if (lagrumEntity == null)
      {
         return null;
      }

      LagrumDTO lagrumDTO = ImmutableLagrumDTO.builder()
            .id(lagrumEntity.id())
            .version(lagrumEntity.version())
            .giltigFrom(lagrumEntity.giltigFrom())
            .giltigTom(lagrumEntity.giltigTom())
            .forfattning(lagrumEntity.forfattning())
            .kapitel(lagrumEntity.kapitel())
            .paragraf(lagrumEntity.paragraf())
            .stycke(lagrumEntity.stycke())
            .punkt(lagrumEntity.punkt())
            .build();

      return lagrumDTO;
   }
}
