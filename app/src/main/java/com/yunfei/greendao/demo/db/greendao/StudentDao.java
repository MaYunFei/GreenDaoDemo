package com.yunfei.greendao.demo.db.greendao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import db.bean.IDCard;

import db.bean.Student;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STUDENT".
*/
public class StudentDao extends AbstractDao<Student, Long> {

    public static final String TABLENAME = "STUDENT";

    /**
     * Properties of entity Student.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StudentName = new Property(1, String.class, "studentName", false, "STUDENT_NAME");
        public final static Property ClassId = new Property(2, Long.class, "classId", false, "CLASS_ID");
        public final static Property CardId = new Property(3, Long.class, "cardId", false, "CARD_ID");
    }

    private DaoSession daoSession;

    private Query<Student> clazz_StudentListQuery;

    public StudentDao(DaoConfig config) {
        super(config);
    }
    
    public StudentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STUDENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"STUDENT_NAME\" TEXT," + // 1: studentName
                "\"CLASS_ID\" INTEGER," + // 2: classId
                "\"CARD_ID\" INTEGER);"); // 3: cardId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STUDENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String studentName = entity.getStudentName();
        if (studentName != null) {
            stmt.bindString(2, studentName);
        }
 
        Long classId = entity.getClassId();
        if (classId != null) {
            stmt.bindLong(3, classId);
        }
 
        Long cardId = entity.getCardId();
        if (cardId != null) {
            stmt.bindLong(4, cardId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Student entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String studentName = entity.getStudentName();
        if (studentName != null) {
            stmt.bindString(2, studentName);
        }
 
        Long classId = entity.getClassId();
        if (classId != null) {
            stmt.bindLong(3, classId);
        }
 
        Long cardId = entity.getCardId();
        if (cardId != null) {
            stmt.bindLong(4, cardId);
        }
    }

    @Override
    protected final void attachEntity(Student entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Student readEntity(Cursor cursor, int offset) {
        Student entity = new Student( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // studentName
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // classId
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3) // cardId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Student entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudentName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setClassId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setCardId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Student entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Student entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Student entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "studentList" to-many relationship of Clazz. */
    public List<Student> _queryClazz_StudentList(Long classId) {
        synchronized (this) {
            if (clazz_StudentListQuery == null) {
                QueryBuilder<Student> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ClassId.eq(null));
                clazz_StudentListQuery = queryBuilder.build();
            }
        }
        Query<Student> query = clazz_StudentListQuery.forCurrentThread();
        query.setParameter(0, classId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getIDCardDao().getAllColumns());
            builder.append(" FROM STUDENT T");
            builder.append(" LEFT JOIN IDCARD T0 ON T.\"CARD_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Student loadCurrentDeep(Cursor cursor, boolean lock) {
        Student entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        IDCard IDCard = loadCurrentOther(daoSession.getIDCardDao(), cursor, offset);
        entity.setIDCard(IDCard);

        return entity;    
    }

    public Student loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Student> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Student> list = new ArrayList<Student>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Student> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Student> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
