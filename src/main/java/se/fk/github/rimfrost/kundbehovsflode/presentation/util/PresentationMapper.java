package se.fk.github.rimfrost.kundbehovsflode.presentation.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.IndividDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsrollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.PeriodDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ProduceratResultatDTO;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Ersattning;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Individ;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehov;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehovsroll;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Period;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovRequest;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.PostKundbehovResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.ProduceratResultat;

@ApplicationScoped
public class PresentationMapper
{

   @Inject
   PresentationEnumMapper enumMapper;

   public KundbehovCreateRequest toKundbehovCreateRequest(PostKundbehovRequest postKundbehovRequest)
   {
      KundbehovCreateRequest request = ImmutableKundbehovCreateRequest.builder()
            .persnr(postKundbehovRequest.getPersnr())
            .formanstyp(postKundbehovRequest.getPersnr())
            .start(postKundbehovRequest.getPeriod().getStart())
            .slut(postKundbehovRequest.getPeriod().getSlut())
            .build();
      return request;
   }

   public PostKundbehovResponse toPostKundbehovResponse(KundbehovCreateResponse kundbehovCreateResponse) {
      PostKundbehovResponse postKundbehovResponse = new PostKundbehovResponse();
      postKundbehovResponse.setKundbehov(toKundbehov(kundbehovCreateResponse.kundbehov()));
      return postKundbehovResponse;
   }

   public Kundbehov toKundbehov(KundbehovDTO kundbehovDTO) {
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
            .toList()
      );
      kundbehov.setErsattning(
         kundbehovDTO.ersattning()
            .stream()
            .map(this::toErsattning)
            .toList() 
      );
      return kundbehov;
   }

   public Period toPeriod(PeriodDTO periodDTO) {
      Period period = new Period();
      period.setStart(periodDTO.start());
      period.setSlut(periodDTO.slut());
      return period;
   }

   public Kundbehovsroll toKundbehovsroll(KundbehovsrollDTO kundbehovsrollDTO) {
      Kundbehovsroll kundbehovsroll = new Kundbehovsroll();
      kundbehovsroll.setId(kundbehovsrollDTO.id());
      kundbehovsroll.setIndivid(toIndivid(kundbehovsrollDTO.individ()));
      kundbehovsroll.setRoll(enumMapper.toRoll(kundbehovsrollDTO.roll()));
      kundbehovsroll.setYrkande(kundbehovsrollDTO.yrkande());
      return kundbehovsroll;
   }

   public Individ toIndivid(IndividDTO individDTO) {
      Individ individ = new Individ();
      individ.setId(individDTO.id());
      individ.setFornamn(individDTO.fornamn());
      individ.setEfternamn(individDTO.efternamn());
      return individ;
   }

   public Ersattning toErsattning(ErsattningDTO ersattningDTO) {
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
            .toList()
      );
      return ersattning;
   }

   public ProduceratResultat toProduceratResultat(ProduceratResultatDTO produceratResultatDTO) {
      ProduceratResultat produceratResultat = new ProduceratResultat();
      produceratResultat.setId(produceratResultatDTO.id());
      produceratResultat.setVersion(produceratResultatDTO.version());
      produceratResultat.setFrom(produceratResultatDTO.franOchMed());
      produceratResultat.setTom(produceratResultatDTO.tillOchMed());
      produceratResultat.setStatus(enumMapper.toErsattningsstatus(produceratResultatDTO.status()));
      return produceratResultat;
   }
}

