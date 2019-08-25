/*
 * This file is generated by jOOQ.
 */
package codegen.tables;


import codegen.Indexes;
import codegen.Keys;
import codegen.Public;
import codegen.tables.records.SlaRecord;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sla extends TableImpl<SlaRecord> {

    private static final long serialVersionUID = -674685063;

    /**
     * The reference instance of <code>public.sla</code>
     */
    public static final Sla SLA = new Sla();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SlaRecord> getRecordType() {
        return SlaRecord.class;
    }

    /**
     * The column <code>public.sla.id</code>.
     */
    public final TableField<SlaRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('sla_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.sla.status</code>.
     */
    public final TableField<SlaRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>public.sla.service_price</code>.
     */
    public final TableField<SlaRecord, BigDecimal> SERVICE_PRICE = createField("service_price", org.jooq.impl.SQLDataType.NUMERIC.nullable(false), this, "");

    /**
     * The column <code>public.sla.lifecycle_phase</code>.
     */
    public final TableField<SlaRecord, String> LIFECYCLE_PHASE = createField("lifecycle_phase", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>public.sla.valid_from</code>.
     */
    public final TableField<SlaRecord, Date> VALID_FROM = createField("valid_from", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>public.sla.valid_to</code>.
     */
    public final TableField<SlaRecord, Date> VALID_TO = createField("valid_to", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>public.sla.service_provider_id</code>.
     */
    public final TableField<SlaRecord, Integer> SERVICE_PROVIDER_ID = createField("service_provider_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.sla.service_customer_id</code>.
     */
    public final TableField<SlaRecord, Integer> SERVICE_CUSTOMER_ID = createField("service_customer_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.sla.title</code>.
     */
    public final TableField<SlaRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.sla.hash</code>.
     */
    public final TableField<SlaRecord, String> HASH = createField("hash", org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.sla.monitoring_solution_id</code>.
     */
    public final TableField<SlaRecord, Integer> MONITORING_SOLUTION_ID = createField("monitoring_solution_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>public.sla</code> table reference
     */
    public Sla() {
        this(DSL.name("sla"), null);
    }

    /**
     * Create an aliased <code>public.sla</code> table reference
     */
    public Sla(String alias) {
        this(DSL.name(alias), SLA);
    }

    /**
     * Create an aliased <code>public.sla</code> table reference
     */
    public Sla(Name alias) {
        this(alias, SLA);
    }

    private Sla(Name alias, Table<SlaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Sla(Name alias, Table<SlaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Sla(Table<O> child, ForeignKey<O, SlaRecord> key) {
        super(child, key, SLA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SLA_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SlaRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SLA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SlaRecord> getPrimaryKey() {
        return Keys.SLA_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SlaRecord>> getKeys() {
        return Arrays.<UniqueKey<SlaRecord>>asList(Keys.SLA_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<SlaRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SlaRecord, ?>>asList(Keys.SLA__SLA_SERVICE_PROVIDER_ID_FKEY, Keys.SLA__SLA_SERVICE_CUSTOMER_ID_FKEY, Keys.SLA__FK_MONITORING);
    }

    public SlaUser sla_SlaServiceProviderIdFkey() {
        return new SlaUser(this, Keys.SLA__SLA_SERVICE_PROVIDER_ID_FKEY);
    }

    public SlaUser sla_SlaServiceCustomerIdFkey() {
        return new SlaUser(this, Keys.SLA__SLA_SERVICE_CUSTOMER_ID_FKEY);
    }

    public SlaUser sla_FkMonitoring() {
        return new SlaUser(this, Keys.SLA__FK_MONITORING);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sla as(String alias) {
        return new Sla(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Sla as(Name alias) {
        return new Sla(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Sla rename(String name) {
        return new Sla(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Sla rename(Name name) {
        return new Sla(name, null);
    }
}
