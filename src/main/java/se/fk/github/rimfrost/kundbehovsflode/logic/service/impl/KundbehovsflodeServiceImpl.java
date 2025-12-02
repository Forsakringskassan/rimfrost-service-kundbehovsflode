package se.fk.github.rimfrost.kundbehovsflode.logic.service.impl;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodeGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodePutRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsflodePutResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsflodeEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.ImmutableKundbehovsflodespecifikationEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodeEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodespecifikationEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovRepository;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovsflodeRepository;
import se.fk.github.rimfrost.kundbehovsflode.logic.service.KundbehovsflodeService;
import se.fk.github.rimfrost.kundbehovsflode.logic.util.LogicMapper;

@ApplicationScoped
public class KundbehovsflodeServiceImpl implements KundbehovsflodeService
{
   @Inject
   KundbehovsflodeRepository kundbehovsflodeRepository;

   @Inject
   KundbehovRepository kundbehovRepository;

   @Inject
   private LogicMapper mapper;

   @Override
   public KundbehovsflodeCreateResponse createKundbehovsflode(KundbehovsflodeCreateRequest request)
   {
      // KundbehovGetRequest kundbehovGetRequest = ImmutableKundbehovGetRequest.builder()
      //     .kundbehovId(request.kundbehovId())
      //     .build();
      // KundbehovGetResponse kunbdehovGetResponse = kundbehovService.getById(kundbehovGetRequest);

      KundbehovEntity kundbehovEntity = kundbehovRepository.findById(request.kundbehovId()).orElse(null);

      KundbehovsflodespecifikationEntity kundbehovsflodespecifikationEntity = ImmutableKundbehovsflodespecifikationEntity
            .builder()
            .id(UUID.randomUUID())
            .version("1.0")
            .bpmn("VAH") // TODO: Uppdatera detta till något annat baserat på kundbehovets typ?
            .namn("Vård av hudsjur") // TODO: Uppdatera detta till något annat baserat på kundbehovets typ?
            .build();

      KundbehovsflodeEntity kundbehovsflodeEntity = ImmutableKundbehovsflodeEntity.builder()
            .id(UUID.randomUUID())
            .kundbehov(kundbehovEntity)
            .version("1.0")
            .processinstansId(UUID.randomUUID()) // TODO: Fixa denna så att vi startar en ny process och stoppar den här??
            .skapadTS(OffsetDateTime.now())
            .avslutadTS(null)
            .kundbehovsspecifikation(kundbehovsflodespecifikationEntity)
            .build();

      kundbehovsflodeRepository.save(kundbehovsflodeEntity);

      KundbehovsflodeCreateResponse response = ImmutableKundbehovsflodeCreateResponse.builder()
            .kundbehovsflode(mapper.toKundbehovsflodeDTO(kundbehovsflodeEntity))
            .build();

      return response;
   }

   @Override
   public KundbehovsflodeGetResponse getKundbehovsflode(KundbehovsflodeGetRequest request)
   {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getById'");
   }

   @Override
   public KundbehovsflodePutResponse putKundbehovsflode(KundbehovsflodePutRequest request)
   {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'updateById'");
   }

}
