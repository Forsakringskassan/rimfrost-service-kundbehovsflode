package se.fk.github.rimfrost.handlaggning.logic.repository;

import java.util.Optional;
import java.util.UUID;
import se.fk.github.rimfrost.handlaggning.logic.entity.HandlaggningEntity;

public interface HandlaggningRepository
{
   HandlaggningEntity save(HandlaggningEntity flode);

   Optional<HandlaggningEntity> findById(UUID id);
}
