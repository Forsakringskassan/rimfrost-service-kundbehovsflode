package se.fk.github.rimfrost.kundbehovsflode.logic.repository.impl;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovRepository;

@ApplicationScoped
public class KundbehovRepositoryImpl implements KundbehovRepository
{
   private final Map<UUID, KundbehovEntity> store = new ConcurrentHashMap<>();

   @Override
   public KundbehovEntity save(KundbehovEntity entity)
   {
      store.put(entity.id(), entity);
      return entity;
   }

   @Override
   public Optional<KundbehovEntity> findById(UUID id)
   {
      return Optional.ofNullable(store.get(id));
   }
}
