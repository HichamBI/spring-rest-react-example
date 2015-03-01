/*
 * Created by Hicham B.I.
 */

package com.dao;

import com.hei.db.Tables;
import com.hei.db.tables.records.UserRecord;
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
        UserRecord userRecord = db.insertInto(Tables.USER)
                .set(Tables.USER.USER_ID, user.getId())
                .set(Tables.USER.USER_NAME, user.getName())
                .returning()
                .fetchOne();

        return new User(userRecord.getUserId(), userRecord.getUserName());
    }

    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        Result<UserRecord> userRecords = db.selectFrom(Tables.USER).fetch();

        return userRecords.map((userRecord) -> new User(userRecord.getUserId(), userRecord.getUserName()));
    }
}