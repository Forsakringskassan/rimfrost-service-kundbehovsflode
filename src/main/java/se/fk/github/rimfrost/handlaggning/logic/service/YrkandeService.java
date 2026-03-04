package se.fk.github.rimfrost.handlaggning.logic.service;

import se.fk.github.rimfrost.handlaggning.logic.dto.YrkandeCreateRequest;
import se.fk.github.rimfrost.handlaggning.logic.dto.YrkandeCreateResponse;
import se.fk.github.rimfrost.handlaggning.logic.dto.YrkandeGetRequest;
import se.fk.github.rimfrost.handlaggning.logic.dto.YrkandeGetResponse;

public interface YrkandeService
{
   YrkandeCreateResponse createYrkande(YrkandeCreateRequest request);

   YrkandeGetResponse getById(YrkandeGetRequest request);
}
