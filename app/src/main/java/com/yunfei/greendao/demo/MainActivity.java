package com.yunfei.greendao.demo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yunfei.greendao.demo.db.greendao.ClazzDao;
import com.yunfei.greendao.demo.db.greendao.DaoMaster;
import com.yunfei.greendao.demo.db.greendao.DaoSession;
import com.yunfei.greendao.demo.db.greendao.IDCardDao;
import com.yunfei.greendao.demo.db.greendao.SchoolDao;
import com.yunfei.greendao.demo.db.greendao.StudentDao;

import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import db.bean.Clazz;
import db.bean.IDCard;
import db.bean.School;
import db.bean.Student;

public class MainActivity extends AppCompatActivity {

    private SchoolDao schoolDao;
    private ClazzDao clazzDao;
    private StudentDao studentDao;
    private IDCardDao idCardDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDB();

//        for (Long i = 0L; i < 1000; i++) {
//            Long schoolId = i % 10;
//            Long classId = i % 100;
//            addRecord(schoolId,schoolId+"",classId,classId+"",i,i+"");
//        }


        QueryBuilder<IDCard> idCardQueryBuilder = idCardDao.queryBuilder();

        Join studnet = idCardQueryBuilder.join(IDCardDao.Properties.Id, Student.class,StudentDao.Properties.CardId);
        Join clazz = idCardQueryBuilder.join(studnet, StudentDao.Properties.ClassId, Clazz.class, ClazzDao.Properties.Id);
        Join school = idCardQueryBuilder.join(clazz, ClazzDao.Properties.SchoolId, School.class, SchoolDao.Properties.Id);
        school.where(SchoolDao.Properties.Id.eq(1));



//        studnet.where(StudentDao.Properties.Id.eq(1));

        List<IDCard> list = idCardQueryBuilder.list();
        if (list!=null && list.size()>0)
        {
            for (IDCard idCard : list) {
                Log.e("66666","   fff  "+idCard.getCardName());
            }
        }

    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "demo.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);


        DaoSession daoSession = daoMaster.newSession();
        schoolDao = daoSession.getSchoolDao();
        clazzDao = daoSession.getClazzDao();
        studentDao = daoSession.getStudentDao();
        idCardDao = daoSession.getIDCardDao();
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    private void addRecord(Long schoolId, String schoolName, Long classId, String className, Long studentId, String studentName) {
        if (!isExistSchool(schoolId)) {
            School school = new School(schoolId, schoolName);
            schoolDao.insertOrReplace(school);
        }

        if (!isExistClass(classId)){
            Clazz clazz = new Clazz(classId,className,schoolId);
            clazzDao.insertOrReplace(clazz);
        }

        if (!isExistStudent(studentId)){
            IDCard idCard = new IDCard();
            idCardDao.insert(idCard);
            idCard.setCardName(idCard.getId()+" ");
            idCardDao.update(idCard);

            Student student = new Student(studentId,studentName,classId,idCard.getId());
            studentDao.insert(student);
        }


    }


    private boolean isExistSchool(Long schoolId) {
        return schoolDao.queryBuilder().where(SchoolDao.Properties.Id.eq(schoolId)).build().unique() != null;
    }

    private boolean isExistClass(Long classId) {
        return clazzDao.queryBuilder().where(ClazzDao.Properties.Id.eq(classId)).build().unique() != null;
    }

    private boolean isExistStudent(Long studentId) {
        return studentDao.queryBuilder().where(StudentDao.Properties.Id.eq(studentId)).build().unique() != null;
    }

}
