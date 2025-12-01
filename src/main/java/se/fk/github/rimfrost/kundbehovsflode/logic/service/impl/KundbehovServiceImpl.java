package se.fk.github.rimfrost.kundbehovsflode.logic.service.impl;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutablePeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.PeriodEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.AvsiktEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.KundbehovsstatusEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovRepository;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.KundbehovService;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Kundbehov;

public class KundbehovServiceImpl implements KundbehovService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(KundbehovService.class);

   private final KundbehovRepository kundbehovRepository;

   @Inject
   public KundbehovServiceImpl(KundbehovRepository kundbehovRepository)
   {
      this.kundbehovRepository = kundbehovRepository;
   }

   @Override
   public KundbehovCreateResponse createKundbehov(KundbehovCreateRequest request)
   {
      PeriodEntity periodEntity = ImmutablePeriodEntity.builder()
         .start(request.start())
         .slut(request.slut())
         .build();

      KundbehovEntity kundbehovEntity = ImmutableKundbehovEntity.builder()
         .id(UUID.randomUUID())
         .formanstyp(request.formanstyp())
         .version("1.0")
         .kundbehovsdatum(OffsetDateTime.now())
         .kundbehovsstatus(KundbehovsstatusEntity.FASTSTALLT)
         .period(periodEntity)
         .avsikt(AvsiktEntity.NY)
         .build();

      KundbehovCreateResponse kundbehovCreateResponse = ImmutableKundbehovCreateResponse.builder()
         .build();

      return kundbehovCreateResponse;
   }

   @Override
   public Optional<KundbehovGetResponse> getById(KundbehovGetRequest id)
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

}
