/*
 * Created by Hicham B.I.
 */

package com.dao;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.hei.db.Tables;
import com.hei.db.tables.records.TechUserRecord;
import com.model.User;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class UserDao {

    @Autowired
    DSLContext db;

    @Transactional
    public User addUser(User user) {
        TechUserRecord techUserRecord = db.insertInto(Tables.TECH_USER)
                .set(Tables.TECH_USER.USR_ID, user.getId())
                .set(Tables.TECH_USER.USER_NAME, user.getName())
                .returning()
                .fetchOne();

        return new User(techUserRecord.getUsrId(), techUserRecord.getUserName());
    }

    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        Result<TechUserRecord> userRecords = db.selectFrom(Tables.TECH_USER).fetch();
        return userRecords.map(ur -> new User(ur.getUsrId(), ur.getUserName()));
    }
}