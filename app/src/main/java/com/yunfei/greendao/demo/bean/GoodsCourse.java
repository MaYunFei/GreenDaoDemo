package com.yunfei.greendao.demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.yunfei.greendao.demo.db.greendao.DaoSession;
import com.yunfei.greendao.demo.db.greendao.ChapterDao;
import com.yunfei.greendao.demo.db.greendao.GoodsCourseDao;

@Entity
public class GoodsCourse {
    @Id
    private String courseId;
    private String courseName;
    private String cwCourseId;
    @ToMany(referencedJoinProperty = "courseId")
    @OrderBy("chapterSort DESC")
    private List<Chapter> chapterList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1687625989)
    private transient GoodsCourseDao myDao;
    @Generated(hash = 2071299132)
    public GoodsCourse(String courseId, String courseName, String cwCourseId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.cwCourseId = cwCourseId;
    }
    @Generated(hash = 659848770)
    public GoodsCourse() {
    }
    public String getCourseId() {
        return this.courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCwCourseId() {
        return this.cwCourseId;
    }
    public void setCwCourseId(String cwCourseId) {
        this.cwCourseId = cwCourseId;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1487233623)
    public List<Chapter> getChapterList() {
        if (chapterList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChapterDao targetDao = daoSession.getChapterDao();
            List<Chapter> chapterListNew = targetDao
                    ._queryGoodsCourse_ChapterList(courseId);
            synchronized (this) {
                if (chapterList == null) {
                    chapterList = chapterListNew;
                }
            }
        }
        return chapterList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1743307878)
    public synchronized void resetChapterList() {
        chapterList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 85053700)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getGoodsCourseDao() : null;
    }

    @Override
    public String toString() {
        return "GoodsCourse{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", cwCourseId='" + cwCourseId + '\'' +
                '}';
    }
}
