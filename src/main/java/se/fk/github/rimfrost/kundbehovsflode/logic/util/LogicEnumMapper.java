package se.fk.github.rimfrost.kundbehovsflode.logic.util;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.AvsiktDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.BeloppstypDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.BerakningsgrundDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.BeslutsutfallDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningsstatusDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.ErsattningstypDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.KundbehovsstatusDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.PeriodiseringDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.RollDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.dto.VerksamhetslogikDTO;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.AvsiktEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeloppstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BerakningsgrundEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.BeslutsutfallEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.ErsattningsstatusEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.ErsattningstypEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.KundbehovsstatusEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.PeriodiseringEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.RollEntity;
import se.fk.github.rimfrost.kundbehovsflode.logic.enums.VerksamhetslogikEntity;

@ApplicationScoped
public class LogicEnumMapper
{
   public AvsiktEntity toAvsiktEntity(AvsiktDTO avsiktDTO) {
        if (avsiktDTO == null) {
            return null;
        }

        AvsiktEntity out;
        switch (avsiktDTO) {
            case ANDRING -> out = AvsiktEntity.ANDRING;
            case ATERTAGEN -> out = AvsiktEntity.ATERTAGEN;
            case BORTTAG -> out = AvsiktEntity.BORTTAG;
            case NY -> out = AvsiktEntity.NY;
            default -> { return null; }
        }
        return out;
    }

   public AvsiktDTO toAvsiktDTO(AvsiktEntity avsikt) {
        if (avsikt == null) {
            return null;
        }

        AvsiktDTO out;
        switch (avsikt) {
            case ANDRING -> out = AvsiktDTO.ANDRING;
            case ATERTAGEN -> out = AvsiktDTO.ATERTAGEN;
            case BORTTAG -> out = AvsiktDTO.BORTTAG;
            case NY -> out = AvsiktDTO.NY;
            default -> { return null; }
        }
        return out;
    }

   public BeloppstypEntity toBeloppstypEntity(BeloppstypDTO beloppstypDTO) {
        if (beloppstypDTO == null) {
            return null;
        }

        BeloppstypEntity out;
        switch (beloppstypDTO) {
            case GRUNDBELOPP -> out = BeloppstypEntity.GRUNDBELOPP;
            case INKOMSTBASERAD -> out = BeloppstypEntity.INKOMSTBASERAD;
            default -> { return null; }
        }
        return out;
    }

   public BeloppstypDTO toBeloppstypDTO(BeloppstypEntity beloppstyp) {
        if (beloppstyp == null) {
            return null;
        }

        BeloppstypDTO out;
        switch (beloppstyp) {
            case GRUNDBELOPP -> out = BeloppstypDTO.GRUNDBELOPP;
            case INKOMSTBASERAD -> out = BeloppstypDTO.INKOMSTBASERAD;
            default -> { return null; }
        }
        return out;
    }

   public BerakningsgrundEntity toBerakningsgrundEntity(BerakningsgrundDTO dto) {
        if (dto == null) {
            return null;
        }

        BerakningsgrundEntity out;
        switch (dto) {
            case FASTBELOPP -> out = BerakningsgrundEntity.FASTBELOPP;
            case LON -> out = BerakningsgrundEntity.LON;
            default -> { return null; }
        }
        return out;
    }

   public BerakningsgrundDTO toBerakningsgrundDTO(BerakningsgrundEntity entity) {
        if (entity == null) {
            return null;
        }

        BerakningsgrundDTO out;
        switch (entity) {
            case FASTBELOPP -> out = BerakningsgrundDTO.FASTBELOPP;
            case LON -> out = BerakningsgrundDTO.LON;
            default -> { return null; }
        }
        return out;
    }

   public BeslutsutfallEntity toBeslutsutfallEntity(BeslutsutfallDTO dto) {
        if (dto == null) {
            return null;
        }

        BeslutsutfallEntity out;
        switch (dto) {
            case FU -> out = BeslutsutfallEntity.FU;
            case JA -> out = BeslutsutfallEntity.JA;
            case NEJ -> out = BeslutsutfallEntity.NEJ;
            default -> { return null; }
        }
        return out;
    }

   public BeslutsutfallDTO toBeslutsutfallDTO(BeslutsutfallEntity entity) {
        if (entity == null) {
            return null;
        }

        BeslutsutfallDTO out;
        switch (entity) {
            case FU -> out = BeslutsutfallDTO.FU;
            case JA -> out = BeslutsutfallDTO.JA;
            case NEJ -> out = BeslutsutfallDTO.NEJ;
            default -> { return null; }
        }
        return out;
    }

   public ErsattningsstatusEntity toErsattningsstatusEntity(ErsattningsstatusDTO dto) {
        if (dto == null) {
            return null;
        }

        ErsattningsstatusEntity out;
        switch (dto) {
            case FASTSTALLT -> out = ErsattningsstatusEntity.FASTSTALLT;
            case FASTSTALLT_UNDER_UTREDNING -> out = ErsattningsstatusEntity.FASTSTALLT_UNDER_UTREDNING;
            case PLANERAT -> out = ErsattningsstatusEntity.PLANERAT;
            case UNDER_UTREDNING -> out = ErsattningsstatusEntity.UNDER_UTREDNING;
            case YRKAT -> out = ErsattningsstatusEntity.YRKAT;
            default -> { return null; }
        }
        return out;
    }

   public ErsattningsstatusDTO toErsattningsstatusDTO(ErsattningsstatusEntity entity) {
        if (entity == null) {
            return null;
        }

        ErsattningsstatusDTO out;
        switch (entity) {
            case FASTSTALLT -> out = ErsattningsstatusDTO.FASTSTALLT;
            case FASTSTALLT_UNDER_UTREDNING -> out = ErsattningsstatusDTO.FASTSTALLT_UNDER_UTREDNING;
            case PLANERAT -> out = ErsattningsstatusDTO.PLANERAT;
            case UNDER_UTREDNING -> out = ErsattningsstatusDTO.UNDER_UTREDNING;
            case YRKAT -> out = ErsattningsstatusDTO.YRKAT;
            default -> { return null; }
        }
        return out;
    }

   public ErsattningstypEntity toErsattningstypEntity(ErsattningstypDTO dto) {
        if (dto == null) {
            return null;
        }

        ErsattningstypEntity out;
        switch (dto) {
            case HUNDBIDRAG -> out = ErsattningstypEntity.HUNDBIDRAG;
            case TILLFALLIG_VARD_AV_HUND -> out = ErsattningstypEntity.TILLFALLIG_VARD_AV_HUND;
            default -> { return null; }
        }
        return out;
    }

   public ErsattningstypDTO toErsattningstypDTO(ErsattningstypEntity entity) {
        if (entity == null) {
            return null;
        }

        ErsattningstypDTO out;
        switch (entity) {
            case HUNDBIDRAG -> out = ErsattningstypDTO.HUNDBIDRAG;
            case TILLFALLIG_VARD_AV_HUND -> out = ErsattningstypDTO.TILLFALLIG_VARD_AV_HUND;
            default -> { return null; }
        }
        return out;
    }

   public KundbehovsstatusEntity toKundbehovsstatusEntity(KundbehovsstatusDTO dto) {
        if (dto == null) {
            return null;
        }

        KundbehovsstatusEntity out;
        switch (dto) {
            case FASTSTALLT -> out = KundbehovsstatusEntity.FASTSTALLT;
            case FASTSTALLT_UNDER_UTREDNING -> out = KundbehovsstatusEntity.FASTSTALLT_UNDER_UTREDNING;
            case PLANERAT -> out = KundbehovsstatusEntity.PLANERAT;
            case UNDER_UTREDNING -> out = KundbehovsstatusEntity.UNDER_UTREDNING;
            case YRKAT -> out = KundbehovsstatusEntity.YRKAT;
            default -> { return null; }
        }
        return out;
    }

   public KundbehovsstatusDTO toKundbehovsstatusDTO(KundbehovsstatusEntity entity) {
        if (entity == null) {
            return null;
        }

        KundbehovsstatusDTO out;
        switch (entity) {
            case FASTSTALLT -> out = KundbehovsstatusDTO.FASTSTALLT;
            case FASTSTALLT_UNDER_UTREDNING -> out = KundbehovsstatusDTO.FASTSTALLT_UNDER_UTREDNING;
            case PLANERAT -> out = KundbehovsstatusDTO.PLANERAT;
            case UNDER_UTREDNING -> out = KundbehovsstatusDTO.UNDER_UTREDNING;
            case YRKAT -> out = KundbehovsstatusDTO.YRKAT;
            default -> { return null; }
        }
        return out;
    }

   public PeriodiseringEntity toPeriodiseringEntity(PeriodiseringDTO dto) {
        if (dto == null) {
            return null;
        }

        PeriodiseringEntity out;
        switch (dto) {
            case DAG -> out = PeriodiseringEntity.DAG;
            case ENGANGS -> out = PeriodiseringEntity.ENGANGS;
            case MANAD -> out = PeriodiseringEntity.MANAD;
            case VECKA -> out = PeriodiseringEntity.VECKA;
            default -> { return null; }
        }
        return out;
    }

   public PeriodiseringDTO toPeriodiseringDTO(PeriodiseringEntity entity) {
        if (entity == null) {
            return null;
        }

        PeriodiseringDTO out;
        switch (entity) {
            case DAG -> out = PeriodiseringDTO.DAG;
            case ENGANGS -> out = PeriodiseringDTO.ENGANGS;
            case MANAD -> out = PeriodiseringDTO.MANAD;
            case VECKA -> out = PeriodiseringDTO.VECKA;
            default -> { return null; }
        }
        return out;
    }

   public RollEntity toRollEntity(RollDTO dto) {
        if (dto == null) {
            return null;
        }

        RollEntity out;
        switch (dto) {
            case AGARE -> out = RollEntity.AGARE;
            case ANSVARIG_HANDLAGGARE -> out = RollEntity.ANSVARIG_HANDLAGGARE;
            case DJUR -> out = RollEntity.DJUR;
            default -> { return null; }
        }
        return out;
    }

   public RollDTO toRollDTO(RollEntity entity) {
        if (entity == null) {
            return null;
        }

        RollDTO out;
        switch (entity) {
            case AGARE -> out = RollDTO.AGARE;
            case ANSVARIG_HANDLAGGARE -> out = RollDTO.ANSVARIG_HANDLAGGARE;
            case DJUR -> out = RollDTO.DJUR;
            default -> { return null; }
        }
        return out;
    }

   public VerksamhetslogikEntity toVerksamhetslogikEntity(VerksamhetslogikDTO dto) {
        if (dto == null) {
            return null;
        }

        VerksamhetslogikEntity out;
        switch (dto) {
            case A -> out = VerksamhetslogikEntity.A;
            case B -> out = VerksamhetslogikEntity.B;
            case C -> out = VerksamhetslogikEntity.C;
            default -> { return null; }
        }
        return out;
    }

   public VerksamhetslogikDTO toVerksamhetslogikDTO(VerksamhetslogikEntity entity) {
        if (entity == null) {
            return null;
        }

        VerksamhetslogikDTO out;
        switch (entity) {
            case A -> out = VerksamhetslogikDTO.A;
            case B -> out = VerksamhetslogikDTO.B;
            case C -> out = VerksamhetslogikDTO.C;
            default -> { return null; }
        }
        return out;
    }

}
