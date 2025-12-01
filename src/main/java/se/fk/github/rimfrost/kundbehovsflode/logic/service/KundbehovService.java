package se.fk.github.rimfrost.kundbehovsflode.logic.service;

import java.util.Optional;

import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovCreateResponse;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetRequest;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovGetResponse;

public interface KundbehovService
{
   KundbehovCreateResponse createKundbehov(KundbehovCreateRequest request);

   Optional<KundbehovGetResponse> getById(KundbehovGetRequest request);
}
