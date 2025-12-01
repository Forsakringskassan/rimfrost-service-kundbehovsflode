package se.fk.github.rimfrost.kundbehovsflode.logic.repository;

import java.util.Optional;
import java.util.UUID;

import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovEntity;

public interface KundbehovRepository
{
   KundbehovEntity save(KundbehovEntity e);

   Optional<KundbehovEntity> findById(UUID id);
}
