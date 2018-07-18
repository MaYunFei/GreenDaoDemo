package com.yunfei.greendao.demo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity

public class Lecture {

    private String lectureSort;
    private String lectureName;
    private String lectureNo;
    @Id
    private String lectureId;

    private String chapterId;

    @Generated(hash = 348609768)
    public Lecture(String lectureSort, String lectureName, String lectureNo,
            String lectureId, String chapterId) {
        this.lectureSort = lectureSort;
        this.lectureName = lectureName;
        this.lectureNo = lectureNo;
        this.lectureId = lectureId;
        this.chapterId = chapterId;
    }

    @Generated(hash = 637726957)
    public Lecture() {
    }

    public String getLectureSort() {
        return this.lectureSort;
    }

    public void setLectureSort(String lectureSort) {
        this.lectureSort = lectureSort;
    }

    public String getLectureName() {
        return this.lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureNo() {
        return this.lectureNo;
    }

    public void setLectureNo(String lectureNo) {
        this.lectureNo = lectureNo;
    }

    public String getLectureId() {
        return this.lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getChapterId() {
        return this.chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureSort='" + lectureSort + '\'' +
                ", lectureName='" + lectureName + '\'' +
                ", lectureNo='" + lectureNo + '\'' +
                ", lectureId='" + lectureId + '\'' +
                ", chapterId='" + chapterId + '\'' +
                '}';
    }
}
