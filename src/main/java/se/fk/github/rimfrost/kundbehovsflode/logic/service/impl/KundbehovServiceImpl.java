package se.fk.github.rimfrost.kundbehovsflode.logic.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ErsattningEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableErsattningEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableIndividEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsrollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutablePeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableProduceratResultatEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.IndividEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsrollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.PeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ProduceratResultatEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.AvsiktEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeloppstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BerakningsgrundEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeslutsutfallEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.ErsattningsstatusEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.ErsattningstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.KundbehovsstatusEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.PeriodiseringEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.RollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovRepository;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.KundbehovService;
import se.fk.github.rimfrost.kundbehovsflode.logic.util.LogicMapper;

@ApplicationScoped
public class KundbehovServiceImpl implements KundbehovService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(KundbehovService.class);

   @Inject
   private KundbehovRepository kundbehovRepository;

   @Inject
   private LogicMapper mapper;

   @Override
   public KundbehovCreateResponse createKundbehov(KundbehovCreateRequest request)
   {
      OffsetDateTime start = request.start();
      OffsetDateTime slut = request.slut();
      LocalDate startDate = start.toLocalDate();
      LocalDate endDate = slut.toLocalDate();

      long days = ChronoUnit.DAYS.between(start.toLocalDate(), slut.toLocalDate()) + 1;

      PeriodEntity periodEntity = ImmutablePeriodEntity.builder()
            .start(request.start())
            .slut(request.slut())
            .build();

      // TODO: Ta bort hårdkodning av namn
      IndividEntity individEntity = ImmutableIndividEntity.builder()
            .id(request.persnr())
            .fornamn("Lisa")
            .efternamn("Tass")
            .build();

      KundbehovsrollEntity kundbehovsrollEntity = ImmutableKundbehovsrollEntity.builder()
            .id(UUID.randomUUID())
            .individ(individEntity)
            .roll(RollEntity.AGARE)
            .yrkande(true)
            .build();

      List<ErsattningEntity> ersattningar = new ArrayList<>();
      for (int i = 0; i < days; i++)
      {
         LocalDate currentDate = startDate.plusDays(i);

         OffsetDateTime franOchMed;
         OffsetDateTime tillOchMed;

         if (i == 0)
         {
            // First day
            franOchMed = start;

            if (startDate.equals(endDate))
            {
               tillOchMed = slut;
            }
            else
            {
               tillOchMed = currentDate.atTime(LocalTime.MAX).atOffset(start.getOffset());
            }
         }
         else if (currentDate.equals(endDate))
         {
            // Last day
            franOchMed = currentDate.atStartOfDay().atOffset(slut.getOffset());
            tillOchMed = slut;
         }
         else
         {
            // Middle day
            franOchMed = currentDate.atStartOfDay().atOffset(start.getOffset());
            tillOchMed = currentDate.atTime(LocalTime.MAX).atOffset(start.getOffset());
         }

         ProduceratResultatEntity pre = ImmutableProduceratResultatEntity.builder()
               .id(UUID.randomUUID())
               .version("1.0")
               .franOchMed(franOchMed)
               .tillOchMed(tillOchMed)
               .status(ErsattningsstatusEntity.PLANERAT)
               .build();

         ErsattningEntity ersattningEntity = ImmutableErsattningEntity.builder()
               .id(UUID.randomUUID())
               .belopp(40000)
               .berakningsgrund(BerakningsgrundEntity.LON)
               .beloppstyp(BeloppstypEntity.INKOMSTBASERAD)
               .ersattningstyp(ErsattningstypEntity.HUNDBIDRAG)
               .periodisering(PeriodiseringEntity.DAG)
               .omfattning(100)
               .beslutsutfall(BeslutsutfallEntity.FU)
               .avslagsanledning("")
               .produceratResultat(List.of(pre))
               .build();

         ersattningar.add(ersattningEntity);
      }

      KundbehovEntity kundbehovEntity = ImmutableKundbehovEntity.builder()
            .id(UUID.randomUUID())
            .formanstyp(request.formanstyp())
            .version("1.0")
            .kundbehovsdatum(OffsetDateTime.now())
            .kundbehovsstatus(KundbehovsstatusEntity.FASTSTALLT)
            .period(periodEntity)
            .avsikt(AvsiktEntity.NY)
            .andringsorsak("")
            .kundbehovsroll(List.of(kundbehovsrollEntity))
            .ersattning(ersattningar)
            .build();

      kundbehovRepository.save(kundbehovEntity);

      KundbehovCreateResponse kundbehovCreateResponse = ImmutableKundbehovCreateResponse.builder()
            .kundbehov(mapper.toKundbehovDTO(kundbehovEntity))
            .build();

      return kundbehovCreateResponse;
   }

   @Override
   public KundbehovGetResponse getById(KundbehovGetRequest kundbehovGetRequest)
   {
      UUID id = kundbehovGetRequest.kundbehovId();
      KundbehovEntity kundbehovEntity = kundbehovRepository.findById(id).orElse(null);
      KundbehovGetResponse kundbehovGetResponse = ImmutableKundbehovGetResponse.builder()
            .kundbehov(mapper.toKundbehovDTO(kundbehovEntity))
            .build();
      return kundbehovGetResponse;
   }

}
