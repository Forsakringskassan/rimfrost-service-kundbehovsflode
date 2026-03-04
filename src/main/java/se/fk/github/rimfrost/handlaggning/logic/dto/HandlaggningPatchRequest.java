package se.fk.github.rimfrost.handlaggning.logic.dto;

import java.util.List;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
public interface HandlaggningPatchRequest
{
   UUID handlaggningId();

   List<UpdateErsattningDTO> updateErsattning();
}
