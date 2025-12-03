package se.fk.github.rimfrost.kundbehovsflode.logic.repository;

import java.util.Optional;
import java.util.UUID;

import se.fk.github.rimfrost.kundbehovsflode.logic.entity.KundbehovsflodeEntity;

public interface KundbehovsflodeRepository
{
   KundbehovsflodeEntity save(KundbehovsflodeEntity flode);

   Optional<KundbehovsflodeEntity> findById(UUID id);
}
