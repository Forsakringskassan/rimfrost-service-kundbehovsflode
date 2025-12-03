package se.fk.github.rimfrost.kundbehovsflode.logic.dto;

import java.util.UUID;

import org.immutables.value.Value;

@Value.Immutable
public interface KundbehovsflodeCreateRequest
{
   UUID kundbehovId();
}
