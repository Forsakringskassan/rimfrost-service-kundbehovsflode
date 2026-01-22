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
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableErsattningEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableIndividEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsflodeEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsflodespecifikationEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsrollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableLagrumEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutablePeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableProduceratResultatEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableRegelEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableUppgiftspecifikationEntity;
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
            .produceratResultat(toProduceratResultatDTO(ersattningEntity.produceratResultat()))
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
            .regel(toRegelDTO(uppgiftspecifikationEntity.regel()))
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
            .lagrum(toLagrumDTO(regelEntity.lagrum()))
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

   public KundbehovEntity toKundbehovEntity(KundbehovDTO kundbehovDTO)
   {
      if (kundbehovDTO == null)
      {
         return null;
      }

      return ImmutableKundbehovEntity.builder()
            .id(kundbehovDTO.id())
            .formanstyp(kundbehovDTO.formanstyp())
            .version(kundbehovDTO.version())
            .kundbehovsdatum(kundbehovDTO.kundbehovsdatum())
            .kundbehovsstatus(enumMapper.toKundbehovsstatusEntity(kundbehovDTO.kundbehovsstatus()))
            .period(toPeriodEntity(kundbehovDTO.period()))
            .avsikt(enumMapper.toAvsiktEntity(kundbehovDTO.avsikt()))
            .andringsorsak(kundbehovDTO.andringsorsak())
            .kundbehovsroll(
                  kundbehovDTO.kundbehovsroll()
                        .stream()
                        .map(this::toKundbehovsrollEntity)
                        .toList())
            .ersattning(
                  kundbehovDTO.ersattning()
                        .stream()
                        .map(this::toErsattningEntity)
                        .toList())
            .build();
   }

   public PeriodEntity toPeriodEntity(PeriodDTO periodDTO)
   {
      if (periodDTO == null)
      {
         return null;
      }

      return ImmutablePeriodEntity.builder()
            .start(periodDTO.start())
            .slut(periodDTO.slut())
            .build();
   }

   public KundbehovsrollEntity toKundbehovsrollEntity(KundbehovsrollDTO kundbehovsrollDTO)
   {
      if (kundbehovsrollDTO == null)
      {
         return null;
      }

      return ImmutableKundbehovsrollEntity.builder()
            .id(kundbehovsrollDTO.id())
            .individ(toIndividEntity(kundbehovsrollDTO.individ()))
            .roll(enumMapper.toRollEntity(kundbehovsrollDTO.roll()))
            .yrkande(kundbehovsrollDTO.yrkande())
            .build();
   }

   public IndividEntity toIndividEntity(IndividDTO individDTO)
   {
      if (individDTO == null)
      {
         return null;
      }

      return ImmutableIndividEntity.builder()
            .id(individDTO.id())
            .fornamn(individDTO.fornamn())
            .efternamn(individDTO.efternamn())
            .build();
   }

   public ErsattningEntity toErsattningEntity(ErsattningDTO ersattningDTO)
   {
      if (ersattningDTO == null)
      {
         return null;
      }

      return ImmutableErsattningEntity.builder()
            .id(ersattningDTO.id())
            .belopp(ersattningDTO.belopp())
            .berakningsgrund(enumMapper.toBerakningsgrundEntity(ersattningDTO.berakningsgrund()))
            .beloppstyp(enumMapper.toBeloppstypEntity(ersattningDTO.beloppstyp()))
            .ersattningstyp(enumMapper.toErsattningstypEntity(ersattningDTO.ersattningstyp()))
            .periodisering(enumMapper.toPeriodiseringEntity(ersattningDTO.periodisering()))
            .omfattning(ersattningDTO.omfattning())
            .beslutsutfall(enumMapper.toBeslutsutfallEntity(ersattningDTO.beslutsutfall()))
            .avslagsanledning(ersattningDTO.avslagsanledning())
            .produceratResultat(toProduceratResultatEntity(ersattningDTO.produceratResultat()))
            .build();
   }

   public ProduceratResultatEntity toProduceratResultatEntity(ProduceratResultatDTO produceratResultatDTO)
   {
      if (produceratResultatDTO == null)
      {
         return null;
      }

      return ImmutableProduceratResultatEntity.builder()
            .id(produceratResultatDTO.id())
            .version(produceratResultatDTO.version())
            .franOchMed(produceratResultatDTO.franOchMed())
            .tillOchMed(produceratResultatDTO.tillOchMed())
            .status(enumMapper.toErsattningsstatusEntity(produceratResultatDTO.status()))
            .build();
   }

   public KundbehovsflodeEntity toKundbehovsflodeEntity(KundbehovsflodeDTO kundbehovsflodeDTO)
   {
      if (kundbehovsflodeDTO == null)
      {
         return null;
      }

      return ImmutableKundbehovsflodeEntity.builder()
            .id(kundbehovsflodeDTO.id())
            .kundbehov(toKundbehovEntity(kundbehovsflodeDTO.kundbehov()))
            .version(kundbehovsflodeDTO.version())
            .processinstansId(kundbehovsflodeDTO.processinstansId())
            .skapadTS(kundbehovsflodeDTO.skapadTS())
            .avslutadTS(kundbehovsflodeDTO.avslutadTS())
            .kundbehovsspecifikation(
                  toKundbehovsflodespecifikationEntity(kundbehovsflodeDTO.kundbehovsspecifikation()))
            .build();
   }

   public KundbehovsflodespecifikationEntity toKundbehovsflodespecifikationEntity(
         KundbehovsflodespecifikationDTO kundbehovsflodespecifikationDTO)
   {
      if (kundbehovsflodespecifikationDTO == null)
      {
         return null;
      }

      return ImmutableKundbehovsflodespecifikationEntity.builder()
            .id(kundbehovsflodespecifikationDTO.id())
            .version(kundbehovsflodespecifikationDTO.version())
            .bpmn(kundbehovsflodespecifikationDTO.bpmn())
            .namn(kundbehovsflodespecifikationDTO.namn())
            .beskrivning(kundbehovsflodespecifikationDTO.beskrivning())
            .uppgiftspecifikation(
                  kundbehovsflodespecifikationDTO.uppgiftspecifikation()
                        .stream()
                        .map(this::toUppgiftspecifikationEntity)
                        .toList())
            .build();
   }

   public UppgiftspecifikationEntity toUppgiftspecifikationEntity(UppgiftspecifikationDTO uppgiftspecifikationDTO)
   {
      if (uppgiftspecifikationDTO == null)
      {
         return null;
      }

      return ImmutableUppgiftspecifikationEntity.builder()
            .id(uppgiftspecifikationDTO.id())
            .version(uppgiftspecifikationDTO.version())
            .namn(uppgiftspecifikationDTO.namn())
            .uppgiftbeskrivning(uppgiftspecifikationDTO.uppgiftbeskrivning())
            .verksamhetslogik(enumMapper.toVerksamhetslogikEntity(uppgiftspecifikationDTO.verksamhetslogik()))
            .roll(enumMapper.toRollEntity(uppgiftspecifikationDTO.roll()))
            .applikationsId(uppgiftspecifikationDTO.applikationsId())
            .applikationsVersion(uppgiftspecifikationDTO.applikationsVersion())
            .regel(toRegelEntity(uppgiftspecifikationDTO.regel()))
            .uppgiftsGui(uppgiftspecifikationDTO.uppgiftsGui())
            .build();
   }

   public RegelEntity toRegelEntity(RegelDTO regelDTO)
   {
      if (regelDTO == null)
      {
         return null;
      }

      return ImmutableRegelEntity.builder()
            .id(regelDTO.id())
            .version(regelDTO.version())
            .lagrum(toLagrumEntity(regelDTO.lagrum()))
            .build();
   }

   public LagrumEntity toLagrumEntity(LagrumDTO lagrumDTO)
   {
      if (lagrumDTO == null)
      {
         return null;
      }

      return ImmutableLagrumEntity.builder()
            .id(lagrumDTO.id())
            .version(lagrumDTO.version())
            .giltigFrom(lagrumDTO.giltigFrom())
            .giltigTom(lagrumDTO.giltigTom())
            .forfattning(lagrumDTO.forfattning())
            .kapitel(lagrumDTO.kapitel())
            .paragraf(lagrumDTO.paragraf())
            .stycke(lagrumDTO.stycke())
            .punkt(lagrumDTO.punkt())
            .build();
   }

}
