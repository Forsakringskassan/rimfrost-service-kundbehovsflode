package se.fk.github.rimfrost.kundbehovsflode.logic.service.impl;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.fk.github.rimfrost.kundbehovsflode.integration.KafkaProducer;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodeGetResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ImmutableKundbehovsflodePutResponse;
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
   KafkaProducer producer;

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

      // Innehåller ingen uppgiftspecifikation just nu
      KundbehovsflodespecifikationEntity kundbehovsflodespecifikationEntity = ImmutableKundbehovsflodespecifikationEntity
            .builder()
            .id(UUID.randomUUID())
            .version("1.0")
            .bpmn("VAH") // TODO: Uppdatera detta till något annat baserat på kundbehovets typ?
            .namn("Vård av hudsjur") // TODO: Uppdatera detta till något annat baserat på kundbehovets typ?
            .beskrivning("Kollar om du har rätt för ersättning för vård av husdjur")
            .build();

      KundbehovsflodeEntity kundbehovsflodeEntity = ImmutableKundbehovsflodeEntity.builder()
            .id(UUID.randomUUID())
            .kundbehov(kundbehovEntity)
            .version("1.0")
            .processinstansId(UUID.randomUUID()) // TODO: Fixa denna så att vi startar en ny process och stoppar den här??
            .skapadTS(OffsetDateTime.now())
            .kundbehovsspecifikation(kundbehovsflodespecifikationEntity)
            .build();

      kundbehovsflodeRepository.save(kundbehovsflodeEntity);
      producer.sendVahRequestMessage(kundbehovsflodeEntity.id());

      KundbehovsflodeCreateResponse response = ImmutableKundbehovsflodeCreateResponse.builder()
            .kundbehovsflode(mapper.toKundbehovsflodeDTO(kundbehovsflodeEntity))
            .build();

      return response;
   }

   @Override
   public KundbehovsflodeGetResponse getKundbehovsflode(KundbehovsflodeGetRequest request)
   {
      KundbehovsflodeEntity kundbehovsflodeEntity = kundbehovsflodeRepository.findById(request.kundbehovsflodeId()).orElse(null);
      if (kundbehovsflodeEntity == null)
      {
         return null;
      }

      // Vet inte riktigt hur man vill hantera detta då kundbehov kommer finnas i kundbehovsflode, måste man hämta ut det eller inte?

      KundbehovsflodeGetResponse response = ImmutableKundbehovsflodeGetResponse.builder()
            .kundbehovsflode(mapper.toKundbehovsflodeDTO(kundbehovsflodeEntity))
            .build();

      return response;
   }

   @Override
   public KundbehovsflodePutResponse putKundbehovsflode(KundbehovsflodePutRequest request)
   {
      kundbehovsflodeRepository.save(mapper.toKundbehovsflodeEntity(request.kundbehovsflode()));
      KundbehovsflodePutResponse response = ImmutableKundbehovsflodePutResponse.builder()
            .kundbehovsflode(request.kundbehovsflode())
            .build();

      return response;
   }

    @Override
    public void sendKundbehovsflodeDoneMessage(UUID kundbehovsflodeID) {
        producer.sendKundbehovsflodeDone(kundbehovsflodeID);
    }


}
