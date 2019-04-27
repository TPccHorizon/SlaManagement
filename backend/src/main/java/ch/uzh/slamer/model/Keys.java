/*
 * This file is generated by jOOQ.
 */
package ch.uzh.slamer.model;


import ch.uzh.slamer.model.tables.Address;
import ch.uzh.slamer.model.tables.Penalty;
import ch.uzh.slamer.model.tables.ServiceLevelObjective;
import ch.uzh.slamer.model.tables.Sla;
import ch.uzh.slamer.model.tables.SlaUser;
import ch.uzh.slamer.model.tables.SloType;
import ch.uzh.slamer.model.tables.records.AddressRecord;
import ch.uzh.slamer.model.tables.records.PenaltyRecord;
import ch.uzh.slamer.model.tables.records.ServiceLevelObjectiveRecord;
import ch.uzh.slamer.model.tables.records.SlaRecord;
import ch.uzh.slamer.model.tables.records.SlaUserRecord;
import ch.uzh.slamer.model.tables.records.SloTypeRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Identities0.IDENTITY_ADDRESS;
    public static final Identity<PenaltyRecord, Integer> IDENTITY_PENALTY = Identities0.IDENTITY_PENALTY;
    public static final Identity<ServiceLevelObjectiveRecord, Integer> IDENTITY_SERVICE_LEVEL_OBJECTIVE = Identities0.IDENTITY_SERVICE_LEVEL_OBJECTIVE;
    public static final Identity<SlaRecord, Integer> IDENTITY_SLA = Identities0.IDENTITY_SLA;
    public static final Identity<SlaUserRecord, Integer> IDENTITY_SLA_USER = Identities0.IDENTITY_SLA_USER;
    public static final Identity<SloTypeRecord, Integer> IDENTITY_SLO_TYPE = Identities0.IDENTITY_SLO_TYPE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AddressRecord> ADDRESS_PKEY = UniqueKeys0.ADDRESS_PKEY;
    public static final UniqueKey<PenaltyRecord> PENALTY_PKEY = UniqueKeys0.PENALTY_PKEY;
    public static final UniqueKey<ServiceLevelObjectiveRecord> SERVICE_LEVEL_OBJECTIVE_PKEY = UniqueKeys0.SERVICE_LEVEL_OBJECTIVE_PKEY;
    public static final UniqueKey<SlaRecord> SLA_PKEY = UniqueKeys0.SLA_PKEY;
    public static final UniqueKey<SlaUserRecord> SLA_USER_PKEY = UniqueKeys0.SLA_USER_PKEY;
    public static final UniqueKey<SloTypeRecord> SLO_TYPE_PKEY = UniqueKeys0.SLO_TYPE_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AddressRecord, SlaUserRecord> ADDRESS__ADDRESS_USER_ID_FKEY = ForeignKeys0.ADDRESS__ADDRESS_USER_ID_FKEY;
    public static final ForeignKey<PenaltyRecord, ServiceLevelObjectiveRecord> PENALTY__PENALTY_SLO_ID_FKEY = ForeignKeys0.PENALTY__PENALTY_SLO_ID_FKEY;
    public static final ForeignKey<ServiceLevelObjectiveRecord, SlaRecord> SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLA_ID_FKEY = ForeignKeys0.SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLA_ID_FKEY;
    public static final ForeignKey<ServiceLevelObjectiveRecord, SloTypeRecord> SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLO_TYPE_ID_FKEY = ForeignKeys0.SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLO_TYPE_ID_FKEY;
    public static final ForeignKey<SlaRecord, SlaUserRecord> SLA__SLA_SERVICE_PROVIDER_ID_FKEY = ForeignKeys0.SLA__SLA_SERVICE_PROVIDER_ID_FKEY;
    public static final ForeignKey<SlaRecord, SlaUserRecord> SLA__SLA_SERVICE_CUSTOMER_ID_FKEY = ForeignKeys0.SLA__SLA_SERVICE_CUSTOMER_ID_FKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Internal.createIdentity(Address.ADDRESS, Address.ADDRESS.ID);
        public static Identity<PenaltyRecord, Integer> IDENTITY_PENALTY = Internal.createIdentity(Penalty.PENALTY, Penalty.PENALTY.ID);
        public static Identity<ServiceLevelObjectiveRecord, Integer> IDENTITY_SERVICE_LEVEL_OBJECTIVE = Internal.createIdentity(ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE, ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE.ID);
        public static Identity<SlaRecord, Integer> IDENTITY_SLA = Internal.createIdentity(Sla.SLA, Sla.SLA.ID);
        public static Identity<SlaUserRecord, Integer> IDENTITY_SLA_USER = Internal.createIdentity(SlaUser.SLA_USER, SlaUser.SLA_USER.ID);
        public static Identity<SloTypeRecord, Integer> IDENTITY_SLO_TYPE = Internal.createIdentity(SloType.SLO_TYPE, SloType.SLO_TYPE.ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AddressRecord> ADDRESS_PKEY = Internal.createUniqueKey(Address.ADDRESS, "address_pkey", Address.ADDRESS.ID);
        public static final UniqueKey<PenaltyRecord> PENALTY_PKEY = Internal.createUniqueKey(Penalty.PENALTY, "penalty_pkey", Penalty.PENALTY.ID);
        public static final UniqueKey<ServiceLevelObjectiveRecord> SERVICE_LEVEL_OBJECTIVE_PKEY = Internal.createUniqueKey(ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE, "service_level_objective_pkey", ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE.ID);
        public static final UniqueKey<SlaRecord> SLA_PKEY = Internal.createUniqueKey(Sla.SLA, "sla_pkey", Sla.SLA.ID);
        public static final UniqueKey<SlaUserRecord> SLA_USER_PKEY = Internal.createUniqueKey(SlaUser.SLA_USER, "sla_user_pkey", SlaUser.SLA_USER.ID);
        public static final UniqueKey<SloTypeRecord> SLO_TYPE_PKEY = Internal.createUniqueKey(SloType.SLO_TYPE, "slo_type_pkey", SloType.SLO_TYPE.ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<AddressRecord, SlaUserRecord> ADDRESS__ADDRESS_USER_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SLA_USER_PKEY, Address.ADDRESS, "address__address_user_id_fkey", Address.ADDRESS.USER_ID);
        public static final ForeignKey<PenaltyRecord, ServiceLevelObjectiveRecord> PENALTY__PENALTY_SLO_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SERVICE_LEVEL_OBJECTIVE_PKEY, Penalty.PENALTY, "penalty__penalty_slo_id_fkey", Penalty.PENALTY.SLO_ID);
        public static final ForeignKey<ServiceLevelObjectiveRecord, SlaRecord> SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLA_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SLA_PKEY, ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE, "service_level_objective__service_level_objective_sla_id_fkey", ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE.SLA_ID);
        public static final ForeignKey<ServiceLevelObjectiveRecord, SloTypeRecord> SERVICE_LEVEL_OBJECTIVE__SERVICE_LEVEL_OBJECTIVE_SLO_TYPE_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SLO_TYPE_PKEY, ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE, "service_level_objective__service_level_objective_slo_type_id_fkey", ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE.SLO_TYPE_ID);
        public static final ForeignKey<SlaRecord, SlaUserRecord> SLA__SLA_SERVICE_PROVIDER_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SLA_USER_PKEY, Sla.SLA, "sla__sla_service_provider_id_fkey", Sla.SLA.SERVICE_PROVIDER_ID);
        public static final ForeignKey<SlaRecord, SlaUserRecord> SLA__SLA_SERVICE_CUSTOMER_ID_FKEY = Internal.createForeignKey(ch.uzh.slamer.model.Keys.SLA_USER_PKEY, Sla.SLA, "sla__sla_service_customer_id_fkey", Sla.SLA.SERVICE_CUSTOMER_ID);
    }
}
