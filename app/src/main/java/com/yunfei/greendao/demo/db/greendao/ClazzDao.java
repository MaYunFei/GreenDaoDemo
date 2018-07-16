package com.yunfei.greendao.demo.db.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import db.bean.Clazz;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CLAZZ".
*/
public class ClazzDao extends AbstractDao<Clazz, Long> {

    public static final String TABLENAME = "CLAZZ";

    /**
     * Properties of entity Clazz.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ClassName = new Property(1, String.class, "className", false, "CLASS_NAME");
        public final static Property SchoolId = new Property(2, Long.class, "schoolId", false, "SCHOOL_ID");
    }

    private DaoSession daoSession;

    private Query<Clazz> school_ClazzListQuery;

    public ClazzDao(DaoConfig config) {
        super(config);
    }
    
    public ClazzDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CLAZZ\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CLASS_NAME\" TEXT," + // 1: className
                "\"SCHOOL_ID\" INTEGER);"); // 2: schoolId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CLAZZ\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Clazz entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String className = entity.getClassName();
        if (className != null) {
            stmt.bindString(2, className);
        }
 
        Long schoolId = entity.getSchoolId();
        if (schoolId != null) {
            stmt.bindLong(3, schoolId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Clazz entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String className = entity.getClassName();
        if (className != null) {
            stmt.bindString(2, className);
        }
 
        Long schoolId = entity.getSchoolId();
        if (schoolId != null) {
            stmt.bindLong(3, schoolId);
        }
    }

    @Override
    protected final void attachEntity(Clazz entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Clazz readEntity(Cursor cursor, int offset) {
        Clazz entity = new Clazz( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // className
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // schoolId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Clazz entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setClassName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSchoolId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Clazz entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Clazz entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Clazz entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "clazzList" to-many relationship of School. */
    public List<Clazz> _querySchool_ClazzList(Long schoolId) {
        synchronized (this) {
            if (school_ClazzListQuery == null) {
                QueryBuilder<Clazz> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.SchoolId.eq(null));
                school_ClazzListQuery = queryBuilder.build();
            }
        }
        Query<Clazz> query = school_ClazzListQuery.forCurrentThread();
        query.setParameter(0, schoolId);
        return query.list();
    }

}