package db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.yunfei.greendao.demo.db.greendao.DaoSession;
import com.yunfei.greendao.demo.db.greendao.IDCardDao;
import com.yunfei.greendao.demo.db.greendao.StudentDao;

@Entity
public class Student {
    @Id
    private Long id;
    private String studentName;
    private Long classId;
    private Long cardId;
    @ToOne(joinProperty = "cardId")
    private IDCard IDCard;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 82139904)
    public Student(Long id, String studentName, Long classId, Long cardId) {
        this.id = id;
        this.studentName = studentName;
        this.classId = classId;
        this.cardId = cardId;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentName() {
        return this.studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Long getClassId() {
        return this.classId;
    }
    public void setClassId(Long classId) {
        this.classId = classId;
    }
    public Long getCardId() {
        return this.cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    @Generated(hash = 1328471784)
    private transient Long IDCard__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1571745750)
    public IDCard getIDCard() {
        Long __key = this.cardId;
        if (IDCard__resolvedKey == null || !IDCard__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IDCardDao targetDao = daoSession.getIDCardDao();
            IDCard IDCardNew = targetDao.load(__key);
            synchronized (this) {
                IDCard = IDCardNew;
                IDCard__resolvedKey = __key;
            }
        }
        return IDCard;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1019915000)
    public void setIDCard(IDCard IDCard) {
        synchronized (this) {
            this.IDCard = IDCard;
            cardId = IDCard == null ? null : IDCard.getId();
            IDCard__resolvedKey = cardId;
        }
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
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }

}
