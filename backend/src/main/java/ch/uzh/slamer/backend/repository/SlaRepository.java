package ch.uzh.slamer.backend.repository;

import ch.uzh.slamer.backend.exception.RecordNotFoundException;
import ch.uzh.slamer.backend.model.dto.SlaDTO;
import codegen.tables.pojos.Sla;
import codegen.tables.pojos.SlaUser;
import codegen.tables.records.SlaRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static codegen.Tables.SLA;
import static codegen.Tables.SLA_USER;

@Repository
public class SlaRepository extends AbstractRepository<SlaRecord, Integer, Sla> {


    public SlaRepository(DSLContext context) {
        super(context, SLA, SLA.ID, Sla.class);
    }

    public List<Sla> getUsersSlas(int userId) {
        return context.selectFrom(SLA).where(SLA.SERVICE_CUSTOMER_ID.equal(userId))
                .or(SLA.SERVICE_PROVIDER_ID.equal(userId))
                .fetchInto(Sla.class);
    }

    @Override
    public Sla update(Sla sla) throws RecordNotFoundException {
        int updateRecordCount = context.update(SLA)
                .set(SLA.STATUS, sla.getStatus())
                .set(SLA.SERVICE_PRICE, sla.getServicePrice())
                .set(SLA.LIFECYCLE_PHASE, sla.getLifecyclePhase())
                .set(SLA.VALID_FROM, sla.getValidFrom())
                .set(SLA.VALID_TO, sla.getValidTo())
                .set(SLA.SERVICE_PROVIDER_ID, sla.getServiceProviderId())
                .set(SLA.SERVICE_CUSTOMER_ID, sla.getServiceCustomerId())
                .execute();
        return findById(sla.getId());
    }

    @Override
    public SlaRecord createRecord(Sla sla) {
        SlaRecord record = new SlaRecord();
        record.setValidFrom(sla.getValidFrom())
                .setValidTo(sla.getValidTo())
                .setLifecyclePhase(sla.getLifecyclePhase())
                .setServiceCustomerId(sla.getServiceCustomerId())
                .setServiceProviderId(sla.getServiceProviderId())
                .setServicePrice(sla.getServicePrice())
                .setStatus(sla.getStatus());
        return record;
    }

    public SlaDTO getSlaWithParties(int slaId) {
        Sla sla = context.selectFrom(SLA)
                .where(SLA.ID.equal(slaId))
                .fetchOne().into(Sla.class);

        List<SlaUser> parties = context.select(SLA_USER.ID, SLA_USER.USERNAME, SLA_USER.PARTY_NAME)
                .from(SLA_USER)
                .where(SLA_USER.ID.equal(sla.getServiceProviderId()))
                .or(SLA_USER.ID.equal(sla.getServiceCustomerId()))
                .fetchInto(SlaUser.class);

        return new SlaDTO(sla, parties);
    }
}
