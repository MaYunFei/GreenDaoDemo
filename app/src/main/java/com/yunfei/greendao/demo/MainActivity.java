package com.yunfei.greendao.demo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yunfei.greendao.demo.bean.Chapter;
import com.yunfei.greendao.demo.bean.GoodsCourse;
import com.yunfei.greendao.demo.bean.Lecture;
import com.yunfei.greendao.demo.db.greendao.ChapterDao;
import com.yunfei.greendao.demo.db.greendao.ClazzDao;
import com.yunfei.greendao.demo.db.greendao.DaoMaster;
import com.yunfei.greendao.demo.db.greendao.DaoSession;
import com.yunfei.greendao.demo.db.greendao.GoodsCourseDao;
import com.yunfei.greendao.demo.db.greendao.IDCardDao;
import com.yunfei.greendao.demo.db.greendao.LectureDao;
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
    private GoodsCourseDao goodsCourseDao;
    private ChapterDao chapterDao;
    private LectureDao lectureDao;

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


//        testJoin();

//        for (int i = 0; i < 10; i++) {
//            GoodsCourse goodsCourse = new GoodsCourse();
//            goodsCourse.setCourseId("--"+i);
//            goodsCourse.setCourseName("冲刺 " +i);
//            goodsCourse.setCwCourseId("=="+i);
//            if (goodsCourseDao.queryBuilder().where(GoodsCourseDao.Properties.CourseId.eq(goodsCourse.getCourseId())).count()==0) {
//                goodsCourseDao.insertOrReplace(goodsCourse);
//            }
//
//            for (int j = 0; j < 10; j++) {
//                Chapter chapter = new Chapter();
//                chapter.setChapterId("chapter"+i+""+j);
//                chapter.setChapterName("name"+i+""+j);
//                chapter.setChapterSort("name"+i+""+j);
//                chapter.setCourseId("--"+i);
//                if (chapterDao.queryBuilder().where(ChapterDao.Properties.ChapterId.eq(chapter.getChapterId())).count() == 0) {
//                    chapterDao.insertOrReplace(chapter);
//                }
//
//                for (int k = 0; k < 10; k++) {
//                    Lecture lecture = new Lecture();
//                    lecture.setChapterId("chapter"+i+""+j);
//                    lecture.setLectureId("lecture"+i+" " +" " +j +" " +k);
//                    lecture.setLectureNo(k+"");
//                    lecture.setLectureSort(k+"");
//                    lecture.setLectureName("lecture " + k);
//                    if (lectureDao.queryBuilder().where(LectureDao.Properties.LectureId.eq(lecture.getLectureId())).count() == 0) {
//                        lectureDao.insertOrReplace(lecture);
//                    }
//                }
//            }
//        }
//


        for (GoodsCourse goodsCourse : goodsCourseDao.queryBuilder().list()) {
            List<Chapter> chapterList = goodsCourse.getChapterList();
            for (int i = 0; i < chapterList.size(); i++) {
                Log.i("TEST",chapterList.get(i).toString());
            }
        }







    }

    private void testJoin() {
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
        goodsCourseDao = daoSession.getGoodsCourseDao();
        chapterDao = daoSession.getChapterDao();
        lectureDao = daoSession.getLectureDao();

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
