package se.fk.github.rimfrost.handlaggning.logic.repository.impl;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.rimfrost.handlaggning.logic.entity.YrkandeEntity;
import se.fk.github.rimfrost.handlaggning.logic.repository.YrkandeRepository;

@ApplicationScoped
public class YrkandeRepositoryImpl implements YrkandeRepository
{
   private final Map<UUID, YrkandeEntity> store = new ConcurrentHashMap<>();

   @Override
   public YrkandeEntity save(YrkandeEntity entity)
   {
      store.put(entity.id(), entity);
      return entity;
   }

   @Override
   public Optional<YrkandeEntity> findById(UUID id)
   {
      return Optional.ofNullable(store.get(id));
   }
}
