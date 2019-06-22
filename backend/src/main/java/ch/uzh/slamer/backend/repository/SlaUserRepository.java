package ch.uzh.slamer.backend.repository;

import ch.uzh.slamer.backend.exception.RecordNotFoundException;
import codegen.tables.pojos.SlaUser;
import codegen.tables.records.SlaUserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static codegen.Tables.SLA_USER;

@Repository
public class SlaUserRepository extends AbstractRepository<SlaUserRecord, Integer, SlaUser> {


    @Autowired
    public SlaUserRepository(DSLContext context) {
        super(context, SLA_USER, SLA_USER.ID, SlaUser.class);
    }

    @Transactional
    @Override
    public SlaUser update(SlaUser slaUser) throws RecordNotFoundException {
        int updatedRecordCount = context.update(SLA_USER)
                .set(SLA_USER.PARTY_NAME, slaUser.getPartyName())
                .set(SLA_USER.PARTY_TYPE, slaUser.getPartyType())
                .set(SLA_USER.PASSWORD, slaUser.getPassword())
                .set(SLA_USER.SALT, slaUser.getSalt())
                .set(SLA_USER.PHONE_NR, slaUser.getPhoneNr())
                .set(SLA_USER.USERNAME, slaUser.getUsername())
                .where(SLA_USER.ID.equal(slaUser.getId()))
                .execute();

        return findById(slaUser.getId());
    }

    public SlaUser findByUsername(String username) throws RecordNotFoundException {
        System.out.println("Find user with username: " + username);
        SlaUserRecord record = context.selectFrom(SLA_USER).where(SLA_USER.USERNAME.equal(username)).fetchOne();
        if (record == null) {
            throw new RecordNotFoundException("No User found with username: " + username);
        }
        return convertResultIntoModel(record);
    }
}
