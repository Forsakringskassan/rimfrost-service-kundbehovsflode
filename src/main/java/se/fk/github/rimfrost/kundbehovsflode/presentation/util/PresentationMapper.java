package se.fk.github.rimfrost.kundbehovsflode.presentation.util;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableIndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodePutRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodespecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableLagrumDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutablePeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableRegelDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableUppgiftspecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.IndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodePutRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodePutResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodespecifikationDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.LagrumDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.PeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ProduceratResultatDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.RegelDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.UppgiftspecifikationDTO;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Ersattning;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetKundbehovsflodeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Individ;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehov;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehovsflode;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehovsflodespecifikation;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehovsroll;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Lagrum;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Period;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovsflodeRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovsflodeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.ProduceratResultat;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PutKundbehovsflodeRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PutKundbehovsflodeResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Regel;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Uppgiftspecifikation;

@ApplicationScoped
public class PresentationMapper
{

   @Inject
   PresentationEnumMapper enumMapper;

   public KundbehovCreateRequest toKundbehovCreateRequest(PostKundbehovRequest postKundbehovRequest)
   {
      if (postKundbehovRequest == null)
      {
         return null;
      }

      KundbehovCreateRequest request = ImmutableKundbehovCreateRequest.builder()
            .persnr(postKundbehovRequest.getPersnr())
            .formanstyp(postKundbehovRequest.getPersnr())
            .start(postKundbehovRequest.getPeriod().getStart())
            .slut(postKundbehovRequest.getPeriod().getSlut())
            .build();
      return request;
   }

   public PostKundbehovResponse toPostKundbehovResponse(KundbehovCreateResponse kundbehovCreateResponse)
   {
      if (kundbehovCreateResponse == null)
      {
         return null;
      }

      PostKundbehovResponse postKundbehovResponse = new PostKundbehovResponse();
      postKundbehovResponse.setKundbehov(toKundbehov(kundbehovCreateResponse.kundbehov()));
      return postKundbehovResponse;
   }

   public Kundbehov toKundbehov(KundbehovDTO kundbehovDTO)
   {
      if (kundbehovDTO == null)
      {
         return null;
      }

      Kundbehov kundbehov = new Kundbehov();
      kundbehov.setId(kundbehovDTO.id());
      kundbehov.setFormanstyp(kundbehovDTO.formanstyp());
      kundbehov.setVersion(kundbehovDTO.version());
      kundbehov.setKundbehovsdatum(kundbehovDTO.kundbehovsdatum());
      kundbehov.setKundbehovsstatus(enumMapper.toKundbehovsstatus(kundbehovDTO.kundbehovsstatus()));
      kundbehov.setPeriod(toPeriod(kundbehovDTO.period()));
      kundbehov.setAvsikt(enumMapper.toAvsikt(kundbehovDTO.avsikt()));
      kundbehov.setAndringsorsak(kundbehovDTO.andringsorsak());
      kundbehov.setKundbehovsroll(
            kundbehovDTO.kundbehovsroll()
                  .stream()
                  .map(this::toKundbehovsroll)
                  .toList());
      kundbehov.setErsattning(
            kundbehovDTO.ersattning()
                  .stream()
                  .map(this::toErsattning)
                  .toList());
      return kundbehov;
   }

   public Period toPeriod(PeriodDTO periodDTO)
   {
      if (periodDTO == null)
      {
         return null;
      }

      Period period = new Period();
      period.setStart(periodDTO.start());
      period.setSlut(periodDTO.slut());
      return period;
   }

   public Kundbehovsroll toKundbehovsroll(KundbehovsrollDTO kundbehovsrollDTO)
   {
      if (kundbehovsrollDTO == null)
      {
         return null;
      }

      Kundbehovsroll kundbehovsroll = new Kundbehovsroll();
      kundbehovsroll.setId(kundbehovsrollDTO.id());
      kundbehovsroll.setIndivid(toIndivid(kundbehovsrollDTO.individ()));
      kundbehovsroll.setRoll(enumMapper.toRoll(kundbehovsrollDTO.roll()));
      kundbehovsroll.setYrkande(kundbehovsrollDTO.yrkande());
      return kundbehovsroll;
   }

   public Individ toIndivid(IndividDTO individDTO)
   {
      if (individDTO == null)
      {
         return null;
      }

      Individ individ = new Individ();
      individ.setId(individDTO.id());
      individ.setFornamn(individDTO.fornamn());
      individ.setEfternamn(individDTO.efternamn());
      return individ;
   }

   public Ersattning toErsattning(ErsattningDTO ersattningDTO)
   {
      if (ersattningDTO == null)
      {
         return null;
      }

      Ersattning ersattning = new Ersattning();
      ersattning.setId(ersattningDTO.id());
      ersattning.setBelopp(ersattningDTO.belopp());
      ersattning.setBerakningsgrund(enumMapper.toBerakningsgrund(ersattningDTO.berakningsgrund()));
      ersattning.setBeloppstyp(enumMapper.toBeloppstyp(ersattningDTO.beloppstyp()));
      ersattning.setErsattningstyp(enumMapper.toErsattningstyp(ersattningDTO.ersattningstyp()));
      ersattning.setPeriodisering(enumMapper.toPeriodisering(ersattningDTO.periodisering()));
      ersattning.setOmfattning(ersattningDTO.omfattning());
      ersattning.setBeslutsutfall(enumMapper.toBeslutsutfallEnum(ersattningDTO.beslutsutfall()));
      ersattning.setAvslagsanledning(ersattningDTO.avslagsanledning());
      ersattning.setProduceratResultat(
            ersattningDTO.produceratResultat()
                  .stream()
                  .map(this::toProduceratResultat)
                  .toList());
      return ersattning;
   }

   public ProduceratResultat toProduceratResultat(ProduceratResultatDTO produceratResultatDTO)
   {
      if (produceratResultatDTO == null)
      {
         return null;
      }

      ProduceratResultat produceratResultat = new ProduceratResultat();
      produceratResultat.setId(produceratResultatDTO.id());
      produceratResultat.setVersion(produceratResultatDTO.version());
      produceratResultat.setFrom(produceratResultatDTO.franOchMed());
      produceratResultat.setTom(produceratResultatDTO.tillOchMed());
      produceratResultat.setStatus(enumMapper.toErsattningsstatus(produceratResultatDTO.status()));
      return produceratResultat;
   }

   public KundbehovsflodeCreateRequest toKundbehovsflodeCreateRequest(PostKundbehovsflodeRequest postKundbehovRequest)
   {
      if (postKundbehovRequest == null)
      {
         return null;
      }

      KundbehovsflodeCreateRequest request = ImmutableKundbehovsflodeCreateRequest.builder()
            .kundbehovId(postKundbehovRequest.getKundbehovId())
            .build();
      return request;
   }

   public PostKundbehovsflodeResponse toPostKundbehovsflodeResponse(KundbehovsflodeCreateResponse kundbehovsflodeCreateResponse)
   {
      if (kundbehovsflodeCreateResponse == null)
      {
         return null;
      }

      PostKundbehovsflodeResponse postKundbehovsflodeResponse = new PostKundbehovsflodeResponse();
      postKundbehovsflodeResponse.setKundbehovsflode(toKundbehovsflode(kundbehovsflodeCreateResponse.kundbehovsflode()));

      return postKundbehovsflodeResponse;
   }

   public KundbehovsflodeGetRequest toKundbehovsflodeGetRequest(UUID kundbehovsflodeId)
   {
      if (kundbehovsflodeId == null)
      {
         return null;
      }
      KundbehovsflodeGetRequest kundbehovsflodeGetRequest = ImmutableKundbehovsflodeGetRequest.builder()
            .kundbehovsflodeId(kundbehovsflodeId)
            .build();

      return kundbehovsflodeGetRequest;
   }

   public GetKundbehovsflodeResponse toGetKundbehovsflodeResponse(KundbehovsflodeGetResponse kundbehovsflodeGetResponse)
   {
      if (kundbehovsflodeGetResponse == null)
      {
         return null;
      }

      GetKundbehovsflodeResponse response = new GetKundbehovsflodeResponse();
      response.setKundbehovsflode(toKundbehovsflode(kundbehovsflodeGetResponse.kundbehovsflode()));

      return response;
   }

   public KundbehovsflodePutRequest toKundbehovsflodePutRequest(UUID kundbehovsflodeId,
         PutKundbehovsflodeRequest putKundbehovsflodeRequest)
   {
      if (kundbehovsflodeId == null || putKundbehovsflodeRequest == null)
      {
         return null;
      }

      KundbehovsflodePutRequest request = ImmutableKundbehovsflodePutRequest.builder()
         .kundbehovsflodeId(kundbehovsflodeId)
         .kundbehovsflode(toKundbehovsflodeDTO(putKundbehovsflodeRequest.getKundbehovsflode()))
         .build();

      return request;
   }

   public PutKundbehovsflodeResponse toPutKundbehovsflodeResponse(KundbehovsflodePutResponse kundbehovsflodePutResponse)
   {
      if (kundbehovsflodePutResponse == null)
      {
         return null;
      }

      PutKundbehovsflodeResponse response = new PutKundbehovsflodeResponse();
      response.setKundbehovsflode(toKundbehovsflode(kundbehovsflodePutResponse.kundbehovsflode()));

      return response;
   }

   public Kundbehovsflode toKundbehovsflode(KundbehovsflodeDTO kundbehovsflodeDTO)
   {
      if (kundbehovsflodeDTO == null)
      {
         return null;
      }

      Kundbehovsflode kundbehovsflode = new Kundbehovsflode();
      kundbehovsflode.setId(kundbehovsflodeDTO.id());
      kundbehovsflode.setKundbehov(toKundbehov(kundbehovsflodeDTO.kundbehov()));
      kundbehovsflode.setVersion(kundbehovsflodeDTO.version());
      kundbehovsflode.setProcessinstansId(kundbehovsflodeDTO.processinstansId());
      kundbehovsflode.setSkapadTS(kundbehovsflodeDTO.skapadTS());
      kundbehovsflode.setAvslutadTS(kundbehovsflodeDTO.avslutadTS());
      kundbehovsflode.setKundbehovsspecifikation(toKundbehovsflodespecifikation(kundbehovsflodeDTO.kundbehovsspecifikation()));

      return kundbehovsflode;
   }

   public Kundbehovsflodespecifikation toKundbehovsflodespecifikation(
         KundbehovsflodespecifikationDTO kundbehovsflodespecifikationDTO)
   {
      if (kundbehovsflodespecifikationDTO == null)
      {
         return null;
      }
      Kundbehovsflodespecifikation kundbehovsflodespecifikation = new Kundbehovsflodespecifikation();
      kundbehovsflodespecifikation.setId(kundbehovsflodespecifikationDTO.id());
      kundbehovsflodespecifikation.setVersion(kundbehovsflodespecifikationDTO.version());
      kundbehovsflodespecifikation.setBpmn(kundbehovsflodespecifikationDTO.bpmn());
      kundbehovsflodespecifikation.setNamn(kundbehovsflodespecifikationDTO.namn());
      kundbehovsflodespecifikation.setBeskrivning(kundbehovsflodespecifikationDTO.beskrivning());
      kundbehovsflodespecifikation.setUppgiftspecifikation(
            kundbehovsflodespecifikationDTO.uppgiftspecifikation()
                  .stream()
                  .map(this::toUppgiftspecifikation)
                  .toList());
      return kundbehovsflodespecifikation;
   }

   public Uppgiftspecifikation toUppgiftspecifikation(UppgiftspecifikationDTO uppgiftspecifikationDTO)
   {
      if (uppgiftspecifikationDTO == null)
      {
         return null;
      }

      Uppgiftspecifikation uppgiftspecifikation = new Uppgiftspecifikation();
      uppgiftspecifikation.setId(uppgiftspecifikationDTO.id());
      uppgiftspecifikation.setVersion(uppgiftspecifikationDTO.version());
      uppgiftspecifikation.setNamn(uppgiftspecifikationDTO.namn());
      uppgiftspecifikation.setUppgiftbeskrivning(uppgiftspecifikationDTO.uppgiftbeskrivning());
      uppgiftspecifikation.setVerksamhetslogik(enumMapper.toVerksamhetslogik(uppgiftspecifikationDTO.verksamhetslogik()));
      uppgiftspecifikation.setRoll(enumMapper.toRoll(uppgiftspecifikationDTO.roll()));
      uppgiftspecifikation.setApplikationsId(uppgiftspecifikationDTO.applikationsId());
      uppgiftspecifikation.setApplikationsVersion(uppgiftspecifikationDTO.applikationsVersion());
      uppgiftspecifikation.setRegel(
            uppgiftspecifikationDTO.regel()
                  .stream()
                  .map(this::toRegel)
                  .toList());
      uppgiftspecifikation.setUppgiftsGui(uppgiftspecifikationDTO.uppgiftsGui());

      return uppgiftspecifikation;
   }

   public Regel toRegel(RegelDTO regelDTO)
   {
      if (regelDTO == null)
      {
         return null;
      }
      Regel regel = new Regel();
      regel.setId(regelDTO.id());
      regel.setVersion(regelDTO.version());
      regel.setLagrum(
            regelDTO.lagrum()
                  .stream()
                  .map(this::toLagrum)
                  .toList());

      return regel;
   }

   public Lagrum toLagrum(LagrumDTO lagrumDTO)
   {
      if (lagrumDTO == null)
      {
         return null;
      }

      Lagrum lagrum = new Lagrum();
      lagrum.setId(lagrumDTO.id());
      lagrum.setVersion(lagrumDTO.version());
      lagrum.setGiltigFrom(lagrumDTO.giltigFrom());
      lagrum.setGiltigTom(lagrumDTO.giltigTom());
      lagrum.setForfattning(lagrumDTO.forfattning());
      lagrum.setKapitel(lagrumDTO.kapitel());
      lagrum.setParagraf(lagrumDTO.paragraf());
      lagrum.setStycke(lagrumDTO.stycke());
      lagrum.setPunkt(lagrumDTO.punkt());

      return lagrum;
   }

   public KundbehovsflodeDTO toKundbehovsflodeDTO(Kundbehovsflode kundbehovsflode)
   {
      if (kundbehovsflode == null)
      {
         return null;
      }

      KundbehovsflodeDTO kundbehovsflodeDTO = ImmutableKundbehovsflodeDTO.builder()
            .id(kundbehovsflode.getId())
            .kundbehov(toKundbehovDTO(kundbehovsflode.getKundbehov()))
            .version(kundbehovsflode.getVersion())
            .processinstansId(kundbehovsflode.getProcessinstansId())
            .skapadTS(kundbehovsflode.getSkapadTS())
            .avslutadTS(kundbehovsflode.getAvslutadTS())
            .kundbehovsspecifikation(toKundbehovsflodespecifikationDTO(kundbehovsflode.getKundbehovsspecifikation()))
            .build();

      return kundbehovsflodeDTO;
   }

   public KundbehovsflodespecifikationDTO toKundbehovsflodespecifikationDTO(
         Kundbehovsflodespecifikation kundbehovsflodespecifikation)
   {
      if (kundbehovsflodespecifikation == null)
      {
         return null;
      }

      KundbehovsflodespecifikationDTO kundbehovsflodespecifikationDTO = ImmutableKundbehovsflodespecifikationDTO.builder()
         .id(kundbehovsflodespecifikation.getId())
         .version(kundbehovsflodespecifikation.getVersion())
         .bpmn(kundbehovsflodespecifikation.getBpmn())
         .namn(kundbehovsflodespecifikation.getNamn())
         .beskrivning(kundbehovsflodespecifikation.getBeskrivning())
         .uppgiftspecifikation(
            kundbehovsflodespecifikation.getUppgiftspecifikation()
               .stream()
               .map(this::toUppgiftspecifikationDTO)
               .toList())
         .build();

      return kundbehovsflodespecifikationDTO;
   }

   public UppgiftspecifikationDTO toUppgiftspecifikationDTO(Uppgiftspecifikation uppgiftspecifikation)
   {
      if (uppgiftspecifikation == null)
      {
         return null;
      }

      UppgiftspecifikationDTO uppgiftspecifikationDTO = ImmutableUppgiftspecifikationDTO.builder()
         .id(uppgiftspecifikation.getId())
         .version(uppgiftspecifikation.getVersion())
         .namn(uppgiftspecifikation.getNamn())
         .uppgiftbeskrivning(uppgiftspecifikation.getUppgiftbeskrivning())
         .verksamhetslogik(enumMapper.toVerksamhetslogikDTO(uppgiftspecifikation.getVerksamhetslogik()))
         .roll(enumMapper.toRollDTO(uppgiftspecifikation.getRoll()))
         .applikationsId(uppgiftspecifikation.getApplikationsId())
         .applikationsVersion(uppgiftspecifikation.getApplikationsVersion())
         .regel(
            uppgiftspecifikation.getRegel()
               .stream()
               .map(this::toRegelDTO)
               .toList())
         .uppgiftsGui(uppgiftspecifikation.getUppgiftsGui())
         .build();

      return uppgiftspecifikationDTO;
   }

   public RegelDTO toRegelDTO(Regel regel)
   {
      if (regel == null)
      {
         return null;
      }

      RegelDTO regelDTO = ImmutableRegelDTO.builder()
         .id(regel.getId())
         .version(regel.getVersion())
         .lagrum(
            regel.getLagrum()
               .stream()
               .map(this::toLagrumDTO)
               .toList())
         .build();

      return regelDTO;
   }

   public LagrumDTO toLagrumDTO(Lagrum lagrum)
   {
      if (lagrum == null)
      {
         return null;
      }

      LagrumDTO lagrumDTO = ImmutableLagrumDTO.builder()
         .id(lagrum.getId())
         .version(lagrum.getVersion())
         .giltigFrom(lagrum.getGiltigFrom())
         .giltigTom(lagrum.getGiltigTom())
         .forfattning(lagrum.getForfattning())
         .kapitel(lagrum.getKapitel())
         .paragraf(lagrum.getParagraf())
         .stycke(lagrum.getStycke())
         .punkt(lagrum.getPunkt())
         .build();

      return lagrumDTO;
   }

   public KundbehovDTO toKundbehovDTO(Kundbehov kundbehov)
   {
      if (kundbehov == null)
      {
         return null;
      }

      return ImmutableKundbehovDTO.builder()
         .id(kundbehov.getId())
         .formanstyp(kundbehov.getFormanstyp())
         .version(kundbehov.getVersion())
         .kundbehovsdatum(kundbehov.getKundbehovsdatum())
         .kundbehovsstatus(enumMapper.toKundbehovsstatusDTO(kundbehov.getKundbehovsstatus()))
         .period(toPeriodDTO(kundbehov.getPeriod()))
         .avsikt(enumMapper.toAvsiktDTO(kundbehov.getAvsikt()))
         .andringsorsak(kundbehov.getAndringsorsak())
         .kundbehovsroll(kundbehov.getKundbehovsroll()
            .stream()
            .map(this::toKundbehovsrollDTO)
            .toList())
         .ersattning(kundbehov.getErsattning()
            .stream()
            .map(this::toErsattningDTO)
            .toList())
         .build();
   }

   public PeriodDTO toPeriodDTO(Period period)
   {
      if (period == null)
      {
         return null;
      }

      return ImmutablePeriodDTO.builder()
         .start(period.getStart())
         .slut(period.getSlut())
         .build();
   }

   public KundbehovsrollDTO toKundbehovsrollDTO(Kundbehovsroll kundbehovsroll)
   {
      if (kundbehovsroll == null)
      {
         return null;
      }

      return ImmutableKundbehovsrollDTO.builder()
         .id(kundbehovsroll.getId())
         .individ(toIndividDTO(kundbehovsroll.getIndivid()))
         .roll(enumMapper.toRollDTO(kundbehovsroll.getRoll()))
         .yrkande(kundbehovsroll.getYrkande())
         .build();
   }

   public IndividDTO toIndividDTO(Individ individ)
   {
      if (individ == null)
      {
         return null;
      }

      return ImmutableIndividDTO.builder()
         .id(individ.getId())
         .fornamn(individ.getFornamn())
         .efternamn(individ.getEfternamn())
         .build();
   }

   public ErsattningDTO toErsattningDTO(Ersattning ersattning)
   {
      if (ersattning == null)
      {
         return null;
      }

      return ImmutableErsattningDTO.builder()
         .id(ersattning.getId())
         .belopp(ersattning.getBelopp())
         .berakningsgrund(enumMapper.toBerakningsgrundDTO(ersattning.getBerakningsgrund()))
         .beloppstyp(enumMapper.toBeloppstypDTO(ersattning.getBeloppstyp()))
         .ersattningstyp(enumMapper.toErsattningstypDTO(ersattning.getErsattningstyp()))
         .periodisering(enumMapper.toPeriodiseringDTO(ersattning.getPeriodisering()))
         .omfattning(ersattning.getOmfattning())
         .beslutsutfall(enumMapper.toBeslutsutfallDTO(ersattning.getBeslutsutfall()))
         .avslagsanledning(ersattning.getAvslagsanledning())
         .produceratResultat(ersattning.getProduceratResultat()
            .stream()
            .map(this::toProduceratResultatDTO)
            .toList())
         .build();
   }

   public ProduceratResultatDTO toProduceratResultatDTO(ProduceratResultat produceratResultat)
   {
      if (produceratResultat == null)
      {
         return null;
      }

      return ImmutableProduceratResultatDTO.builder()
         .id(produceratResultat.getId())
         .version(produceratResultat.getVersion())
         .franOchMed(produceratResultat.getFrom())
         .tillOchMed(produceratResultat.getTom())
         .status(enumMapper.toErsattningsstatusDTO(produceratResultat.getStatus()))
         .build();
   }

}
