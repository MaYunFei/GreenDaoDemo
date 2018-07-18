package com.yunfei.greendao.demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.yunfei.greendao.demo.db.greendao.DaoSession;
import com.yunfei.greendao.demo.db.greendao.LectureDao;
import com.yunfei.greendao.demo.db.greendao.ChapterDao;

@Entity
public class Chapter {
    @Id
    private String chapterId;
    private String chapterName;
    private String chapterSort;

    private String courseId;
    @ToMany(referencedJoinProperty = "chapterId")
    @OrderBy("lectureSort DESC")
    private List<Lecture> lectureList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1364227941)
    private transient ChapterDao myDao;
    @Generated(hash = 1065226754)
    public Chapter(String chapterId, String chapterName, String chapterSort,
            String courseId) {
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.chapterSort = chapterSort;
        this.courseId = courseId;
    }
    @Generated(hash = 393170288)
    public Chapter() {
    }
    public String getChapterId() {
        return this.chapterId;
    }
    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }
    public String getChapterName() {
        return this.chapterName;
    }
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getChapterSort() {
        return this.chapterSort;
    }
    public void setChapterSort(String chapterSort) {
        this.chapterSort = chapterSort;
    }
    public String getCourseId() {
        return this.courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 347249684)
    public List<Lecture> getLectureList() {
        if (lectureList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LectureDao targetDao = daoSession.getLectureDao();
            List<Lecture> lectureListNew = targetDao
                    ._queryChapter_LectureList(chapterId);
            synchronized (this) {
                if (lectureList == null) {
                    lectureList = lectureListNew;
                }
            }
        }
        return lectureList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1934886677)
    public synchronized void resetLectureList() {
        lectureList = null;
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
    @Generated(hash = 1600057230)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getChapterDao() : null;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterId='" + chapterId + '\'' +
                ", chapterName='" + chapterName + '\'' +
                ", chapterSort='" + chapterSort + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
