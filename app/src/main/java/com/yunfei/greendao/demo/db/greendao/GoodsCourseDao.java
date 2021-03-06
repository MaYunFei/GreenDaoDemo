package com.yunfei.greendao.demo.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yunfei.greendao.demo.bean.GoodsCourse;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GOODS_COURSE".
*/
public class GoodsCourseDao extends AbstractDao<GoodsCourse, String> {

    public static final String TABLENAME = "GOODS_COURSE";

    /**
     * Properties of entity GoodsCourse.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CourseId = new Property(0, String.class, "courseId", true, "COURSE_ID");
        public final static Property CourseName = new Property(1, String.class, "courseName", false, "COURSE_NAME");
        public final static Property CwCourseId = new Property(2, String.class, "cwCourseId", false, "CW_COURSE_ID");
    }

    private DaoSession daoSession;


    public GoodsCourseDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsCourseDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GOODS_COURSE\" (" + //
                "\"COURSE_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: courseId
                "\"COURSE_NAME\" TEXT," + // 1: courseName
                "\"CW_COURSE_ID\" TEXT);"); // 2: cwCourseId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GOODS_COURSE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GoodsCourse entity) {
        stmt.clearBindings();
 
        String courseId = entity.getCourseId();
        if (courseId != null) {
            stmt.bindString(1, courseId);
        }
 
        String courseName = entity.getCourseName();
        if (courseName != null) {
            stmt.bindString(2, courseName);
        }
 
        String cwCourseId = entity.getCwCourseId();
        if (cwCourseId != null) {
            stmt.bindString(3, cwCourseId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GoodsCourse entity) {
        stmt.clearBindings();
 
        String courseId = entity.getCourseId();
        if (courseId != null) {
            stmt.bindString(1, courseId);
        }
 
        String courseName = entity.getCourseName();
        if (courseName != null) {
            stmt.bindString(2, courseName);
        }
 
        String cwCourseId = entity.getCwCourseId();
        if (cwCourseId != null) {
            stmt.bindString(3, cwCourseId);
        }
    }

    @Override
    protected final void attachEntity(GoodsCourse entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public GoodsCourse readEntity(Cursor cursor, int offset) {
        GoodsCourse entity = new GoodsCourse( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // courseId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // courseName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // cwCourseId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GoodsCourse entity, int offset) {
        entity.setCourseId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCourseName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCwCourseId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final String updateKeyAfterInsert(GoodsCourse entity, long rowId) {
        return entity.getCourseId();
    }
    
    @Override
    public String getKey(GoodsCourse entity) {
        if(entity != null) {
            return entity.getCourseId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GoodsCourse entity) {
        return entity.getCourseId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
