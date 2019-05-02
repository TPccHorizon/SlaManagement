/*
 * This file is generated by jOOQ.
 */
package codegen;


import codegen.tables.Address;
import codegen.tables.Databasechangeloglock;
import codegen.tables.Penalty;
import codegen.tables.ServiceLevelObjective;
import codegen.tables.Sla;
import codegen.tables.SlaUser;
import codegen.tables.SloType;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ADDRESS_PKEY = Indexes0.ADDRESS_PKEY;
    public static final Index DATABASECHANGELOGLOCK_PKEY = Indexes0.DATABASECHANGELOGLOCK_PKEY;
    public static final Index PENALTY_PKEY = Indexes0.PENALTY_PKEY;
    public static final Index SERVICE_LEVEL_OBJECTIVE_PKEY = Indexes0.SERVICE_LEVEL_OBJECTIVE_PKEY;
    public static final Index SLA_PKEY = Indexes0.SLA_PKEY;
    public static final Index SLA_USER_PKEY = Indexes0.SLA_USER_PKEY;
    public static final Index SLO_TYPE_PKEY = Indexes0.SLO_TYPE_PKEY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ADDRESS_PKEY = Internal.createIndex("address_pkey", Address.ADDRESS, new OrderField[] { Address.ADDRESS.ID }, true);
        public static Index DATABASECHANGELOGLOCK_PKEY = Internal.createIndex("databasechangeloglock_pkey", Databasechangeloglock.DATABASECHANGELOGLOCK, new OrderField[] { Databasechangeloglock.DATABASECHANGELOGLOCK.ID }, true);
        public static Index PENALTY_PKEY = Internal.createIndex("penalty_pkey", Penalty.PENALTY, new OrderField[] { Penalty.PENALTY.ID }, true);
        public static Index SERVICE_LEVEL_OBJECTIVE_PKEY = Internal.createIndex("service_level_objective_pkey", ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE, new OrderField[] { ServiceLevelObjective.SERVICE_LEVEL_OBJECTIVE.ID }, true);
        public static Index SLA_PKEY = Internal.createIndex("sla_pkey", Sla.SLA, new OrderField[] { Sla.SLA.ID }, true);
        public static Index SLA_USER_PKEY = Internal.createIndex("sla_user_pkey", SlaUser.SLA_USER, new OrderField[] { SlaUser.SLA_USER.ID }, true);
        public static Index SLO_TYPE_PKEY = Internal.createIndex("slo_type_pkey", SloType.SLO_TYPE, new OrderField[] { SloType.SLO_TYPE.ID }, true);
    }
}