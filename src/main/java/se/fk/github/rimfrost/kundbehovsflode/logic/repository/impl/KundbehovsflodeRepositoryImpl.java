package se.fk.github.rimfrost.kundbehovsflode.logic.repository.impl;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodeEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.repository.KundbehovsflodeRepository;

@ApplicationScoped
public class KundbehovsflodeRepositoryImpl implements KundbehovsflodeRepository
{
   private final Map<UUID, KundbehovsflodeEntity> store = new ConcurrentHashMap<>();

   @Override
   public KundbehovsflodeEntity save(KundbehovsflodeEntity entity)
   {
      store.put(entity.id(), entity);
      return entity;
   }

   @Override
   public Optional<KundbehovsflodeEntity> findById(UUID id)
   {
      return Optional.ofNullable(store.get(id));
   }

}
