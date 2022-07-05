CREATE OR REPLACE FUNCTION "upd_timestamp"()
RETURNS TRIGGER AS $$
BEGIN
    NEW.update_time = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TABLE anjob.LAYOUT_MST (  
  LAYOUT_ID serial not null
  , LAYOUT_MONEY int not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint LAYOUT_MST_PKC primary key (LAYOUT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.LAYOUT_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.MEMBER_LEVEL_MST (  
  LEVEL_ID serial not null
  , LEVEL_NM varchar(50) not null
  , REQUIRED_HONEY int not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint LEVEL_MST_PKC primary key (LEVEL_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.MEMBER_LEVEL_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.WARIBIKI_MST (  
    WARIBIKI1 numeric(4,2) not null
  , WARIBIKI2 numeric(4,2) not null
  , WARIBIKI3 numeric(4,2) not null
  , WARIBIKI4 numeric(4,2) not null
  , WARIBIKI5 numeric(4,2) not null
  , SYOHIZEI numeric(4,2) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.WARIBIKI_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.COUPON_MST ( 
  COUPON_ID serial not null
  , COUPON_NM varchar(50) not null
  , POINT_NUM int not null
  , DETAIL varchar(1000) not null
  , EXP_DAYS int default 1 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COUPON_MST_PKC primary key (COUPON_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COUPON_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.COU_MST ( 
  COUNTRY_ID serial not null
  , COUNTRY_NM varchar(100) not null
  , COUNTRY_ZIP varchar(5) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COU_MST_PKC primary key (COUNTRY_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COU_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.ALLOWANCE_MST ( 
  ALLOWANCE_ID serial not null
  , ALLOWANCE_NM varchar(100) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint ALLOWANCE_MST_PKC primary key (ALLOWANCE_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.ALLOWANCE_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.LAN_MST ( 
  LANGUAGE_ID serial not null
  , LANGUAGE varchar(40) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint LAN_MST_PKC primary key (LANGUAGE_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.LAN_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.INDUSTRY_MST ( 
  INDUSTRY_ID serial not null
  , INDUSTRY_NM varchar(50)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint INDUSTRY_MST_PKC primary key (INDUSTRY_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.INDUSTRY_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.JOBTYPE_MST ( 
  JOBTYPE_ID serial not null
  , INDUSTRY_ID int REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_NM varchar(50) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint JOBTYPE_MST_PKC primary key (JOBTYPE_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.JOBTYPE_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.SKILL_MST ( 
  SKILL_ID serial not null
  , INDUSTRY_ID int not null REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_ID int not null REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , SKILL_NM varchar(50) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint SKILL_MST_PKC primary key (SKILL_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.SKILL_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.ITEM_MST ( 
  ITEM_ID serial not null
  , ITEM_NM varchar(50) not null
  , ITEM_PRICE int not null
  , ITEM_UNIT int
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint ITEM_MST_PKC primary key (ITEM_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.ITEM_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.PREFECTURES_MST ( 
  PREFE_ID serial not null
  , PREFE_NM varchar(50) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint PREFECTURES_MST_PKC primary key (PREFE_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.PREFECTURES_MST
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE ANJOB.AD_ADDRESS (
  ID INTEGER NOT NULL DEFAULT 0
  ,KEN_ID INTEGER DEFAULT NULL
  ,CITY_ID INTEGER DEFAULT NULL
  ,TOWN_ID INTEGER DEFAULT NULL
  ,ZIP VARCHAR(8) DEFAULT NULL
  ,OFFICE_FLG INTEGER DEFAULT NULL
  ,DELETE_FLG INTEGER DEFAULT NULL
  ,KEN_NAME VARCHAR(8) DEFAULT NULL
  ,KEN_FURI VARCHAR(8) DEFAULT NULL
  ,CITY_NAME VARCHAR(24) DEFAULT NULL
  ,CITY_FURI VARCHAR(24) DEFAULT NULL
  ,TOWN_NAME VARCHAR(32) DEFAULT NULL
  ,TOWN_FURI VARCHAR(32) DEFAULT NULL
  ,TOWN_MEMO VARCHAR(16) DEFAULT NULL
  ,KYOTO_STREET VARCHAR(32) DEFAULT NULL
  ,BLOCK_NAME VARCHAR(64) DEFAULT NULL
  ,BLOCK_FURI VARCHAR(64) DEFAULT NULL
  ,MEMO VARCHAR(255) DEFAULT NULL
  ,OFFICE_NAME VARCHAR(255) DEFAULT NULL
  ,OFFICE_FURI VARCHAR(255) DEFAULT NULL
  ,OFFICE_ADDRESS VARCHAR(255) DEFAULT NULL
  ,NEW_ID VARCHAR(9) DEFAULT NULL
  , PRIMARY KEY  (ID) 
);


CREATE TABLE anjob.COMPANY_TBL ( 
  COMPANY_ID serial not null
  , COMPANY_NM varchar(50) not null
  , VALIDITY_SECTION char(1) default 0 not null
  , COMPANY_TEL varchar(15) not null
  , COMPANY_MAIL varchar(50) not null
  , COMPANY_SCALE varchar(50) not null
  , COMPANY_POSTAL varchar(10) not null
  , COUNTRY_ID int not null
  , PREFE_NM varchar(20)
  , ADDRESS1 varchar(200)
  , ADDRESS2 varchar(200) not null
  , INDUSTRY_ID1 int not null REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , INDUSTRY_ID2 int REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , INDUSTRY_ID3 int REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , BUSINESS_CONTENT varchar(500) not null
  , CAPITAL numeric(14,0)
  , SALES_AMOUNT numeric(14,0)
  , HOMEPAGE varchar(200)
  , LICENSE_ADDRESS varchar(200) not null
  , COMPANY_LOGO varchar(200)
  , PHOTO_ADDRESS1 varchar(200)
  , PHOTO_ADDRESS2 varchar(200)
  , PHOTO_ADDRESS3 varchar(200)
  , VIDEO_ADDRESS1 varchar(200)
  , VIDEO_ADDRESS2 varchar(200)
  , VIDEO_ADDRESS3 varchar(200)
  , PAY_CONS_SUM int default 0 not null
  , REMAINDER int default 0 not null
  , POINT int default 0 not null
  , LEVEL_ID int default 0 not null
  , STATUS_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COMPANY_TBL_PKC primary key (COMPANY_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COMPANY_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.USER_TBL ( 
  USER_CD serial not null
  , PWD varchar(100) not null
  , COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , AUTHORITY varchar(50) not null
  , FIRST_NAME_KANA varchar(20) not null
  , FIRST_NAME varchar(20) not null
  , LAST_NAME_KANA varchar(20) not null
  , LAST_NAME varchar(20) not null
  , SEX char(1) default 0 not null
  , COUNTRY_ZIP varchar(5) not null
  , USER_TEL varchar(15) not null
  , USER_MAIL varchar(50) not null
  , PHOTO_ADDRESS varchar(200)
  , USER_STATUS char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint USER_TBL_PKC primary key (USER_CD)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.USER_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.TRAINING_INFO_TBL ( 
  TRAINING_ID serial not null
  , COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , INDUSTRY_ID int not null REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , TRAINING_NM varchar(50) not null
  , DATE_FROM date not null
  , DATE_TO date not null
  , TIME_FROM time without time zone not null
  , TIME_TO time without time zone not null
  , POSTAL varchar(10) not null
  , PREFE_NM varchar(20)
  , TRAINING_ADDRESS1 varchar(200)
  , TRAINING_ADDRESS2 varchar(200) not null
  , TRAINING_CONTENT varchar(1000) not null
  , PRO_CNT int default 1 not null
  , TEA_NM varchar(20)
  , TEA_INTRO varchar(200)
  , COST int
  , TEL varchar(15) not null
  , CHARGE varchar(20) not null
  , TRAINING_PIC1 varchar(200)
  , TRAINING_PIC2 varchar(200)
  , TRAINING_PIC3 varchar(200)
  , STATUS_FLG char(1) default 0 not null
  , REMARKS varchar(500)
  , USE_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint TRAINING_INFO_TBL_PKC primary key (TRAINING_ID, COMPANY_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.TRAINING_INFO_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.BRIEFING_INFO_TBL ( 
  BRIEFING_ID serial not null
  , COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , BRIEFING_NM varchar(50) not null
  , BRIEFING_TYPE char(1) not null
  , BRIEFING_DATE date not null
  , DATE_FROM time without time zone not null
  , DATE_TO time without time zone not null
  , POSTAL varchar(10) not null
  , PREFE_NM varchar(20)
  , BRIEFING_ADDRESS1 varchar(200)
  , BRIEFING_ADDRESS2 varchar(200) not null
  , BRIEFING_CONTENT varchar(1000) not null
  , PRO_CNT_PLAN int default 1
  , TEA_NM varchar(20)
  , TEA_INTRO varchar(200)
  , TEL varchar(15) not null
  , CHARGE varchar(20) not null
  , PHOTO_ADDRESS1 varchar(200)
  , PHOTO_ADDRESS2 varchar(200)
  , PHOTO_ADDRESS3 varchar(200)
  , STATUS_FLG char(1) default 0 not null
  , REMARKS varchar(500)
  , USE_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint BRIEFING_INFO_TBL_PKC primary key (BRIEFING_ID, COMPANY_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.BRIEFING_INFO_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_INFO_TBL ( 
  APPLICANT_ID serial not null
  , USER_CD int UNIQUE not null REFERENCES anjob.USER_TBL(USER_CD) ON DELETE RESTRICT
  , BIRTHDAY date not null
  , APPLICANT_POSTAL varchar(10) not null
  , COUNTRY_ID int not null
  , PREFE_NM varchar(20)
  , ADDRESS1 varchar(200)
  , ADDRESS2 varchar(200) not null
  , STATION varchar(30) not null
  , HOPE_LAND1 int REFERENCES anjob.PREFECTURES_MST(PREFE_ID) ON DELETE RESTRICT
  , HOPE_LAND2 int REFERENCES anjob.PREFECTURES_MST(PREFE_ID) ON DELETE RESTRICT
  , HOPE_LAND3 int REFERENCES anjob.PREFECTURES_MST(PREFE_ID) ON DELETE RESTRICT
  , PHOTO varchar(200)
  , WORK_SITUATION char(1) not null
  , GRADUATION_SCHOOL varchar(50) not null
  , GRADUATION_MAJOR varchar(50)
  , WORK_YEARS int not null
  , INDUSTRY_ID1 int not null REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_ID1_1 int not null REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID1_2 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID1_3 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , INDUSTRY_ID2 int REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_ID2_1 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID2_2 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID2_3 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , INDUSTRY_ID3 int REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_ID3_1 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID3_2 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , JOBTYPE_ID3_3 int REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , FINAL_EDUCATION varchar(50) not null
  , HOPE_SALARY_FROM int not null
  , HOPE_SALARY_TO int
  , INTRODUCE varchar(1000)
  , REASON varchar(500)
  , SPECIALTY varchar(200)
  , INTEREST varchar(100)
  , REMAINDER int default 0 not null
  , POINT int default 0 not null
  , LEVEL_ID int not null REFERENCES anjob.MEMBER_LEVEL_MST(LEVEL_ID) ON DELETE RESTRICT
  , REMARKS varchar(400)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_INFO_TBL_PKC primary key (APPLICANT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_INFO_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.PROJECT_HIS_TBL ( 
  PROJECT_ID serial not null
  , APPLICANT_ID int  not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , PROJECT_NM varchar (40) not null
  , PRO_DATE_FROM date not null
  , PRO_DATE_TO date not null
  , PRO_CONTENT varchar (500) not null
  , PRO_DUTIES varchar (200)
  , PRO_TEC varchar (200)
  , PRO_ROLE varchar (50)
  , PRO_CNT int default 1
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint PROJECT_HIS_TBL_PKC primary key (PROJECT_ID, APPLICANT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.PROJECT_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_EDU_TBL ( 
  EDUCATION_ID serial not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , EDU_SECTION varchar(50) not null
  , EDU_DATE_FROM date not null
  , EDU_DATE_TO date not null
  , DEGREE varchar(50) not null
  , SCHOOL_NM varchar(50) not null
  , MAJOR_NM varchar(50)
  , DEGREE_PIC1 varchar(200)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_EDU_TBL_PKC primary key (EDUCATION_ID, APPLICANT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_EDU_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.POSITION_TBL ( 
  COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , POSITION_ID serial not null
  , INDUSTRY_ID int not null REFERENCES anjob.INDUSTRY_MST(INDUSTRY_ID) ON DELETE RESTRICT
  , JOBTYPE_ID int not null REFERENCES anjob.JOBTYPE_MST(JOBTYPE_ID) ON DELETE RESTRICT
  , SKILL_ID int not null REFERENCES anjob.SKILL_MST(SKILL_ID) ON DELETE RESTRICT
  , POSITION_NM varchar(50)
  , DEGREE varchar(50) not null
  , POSITION_INT varchar(2000)
  , WORK_CONTENT varchar(2000)
  , CONTRACT_SECTION char(1) not null
  , WORK_TIME_FROM time without time zone not null
  , WORK_TIME_TO time without time zone not null
  , POSTAL varchar(10) not null
  , PREFE_NM varchar(20)
  , WORK_ADDRESS_1 varchar(200)
  , WORK_ADDRESS_2 varchar(200) not null
  , STATION varchar(30) not null
  , EXP_YEARS varchar(50) not null
  , SALARY_SECTION char(1) not null
  , SALARY_MIN int not null
  , SALARY_MAX int
  , PEO_CNT int not null
  , HOLIDAY varchar(100)
  , EMP_LABOR_INS varchar(50) not null
  , WELFARE char(1) not null
  , TRAINING_FLG char(1) not null
  , INSPECTION_FLG char(1) not null
  , CON_UPD_FLG char(1) not null
  , WORK_DATE_STR date not null
  , WORKING_ADDRESS1 varchar(200)
  , WORKING_ADDRESS2 varchar(200)
  , WORKING_ADDRESS3 varchar(200)
  , ONLINE_STATUS char(1) not null default 0
  , TOP_STATUS char(1) not null default 0
  , EXP_DATE date
  , CHECK_STATUS char(1) default 0 not null
  , REMARKS varchar(1000)
  , USE_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint POSITION_TBL_PKC primary key (COMPANY_ID, POSITION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.POSITION_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_LAN_TBL ( 
  APP_LAN_ID serial 
  , APPLICANT_ID int REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , LANGUAGE_ID int REFERENCES anjob.LAN_MST(LANGUAGE_ID) ON DELETE RESTRICT
  , LEVEL_SECTION varchar(50)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_LAN_TBL_PKC primary key (APP_LAN_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_LAN_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICATION_TBL ( 
  COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , POSITION_ID int not null
  , APPLICANT_ID int not null
  , APP_COM_STATUS char(1) default 0
  , APP_APP_STATUS char(1) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICATION_TBL_PKC primary key (COMPANY_ID, POSITION_ID, APPLICANT_ID)
  , constraint APPLICATION_TBL_FK foreign key (COMPANY_ID, POSITION_ID) REFERENCES anjob.POSITION_TBL (COMPANY_ID, POSITION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICATION_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_SKILL_TBL ( 
  APP_SKILL_ID serial not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , SKILL_ID int not null REFERENCES anjob.SKILL_MST(SKILL_ID) ON DELETE RESTRICT
  , EXP_SECTION varchar(50) not null
  , OTHER_NM varchar(100)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_SKILL_TBL_PKC primary key (APP_SKILL_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_SKILL_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_WORK_HIS_TBL (
  WORK_HIS_ID serial not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , INDUSTRY_ID1 int not null
  , JOBTYPE_ID1_1 int not null
  , JOBTYPE_ID1_2 int
  , JOBTYPE_ID1_3 int
  , COMPANY_NM varchar(50) not null
  , WORK_CONTENT varchar(500) not null
  , WORK_PLACE varchar(200) not null
  , WORK_DATE_FROM date not null
  , WORK_DATE_TO date not null
  , WORK_POSITION varchar(50) not null
  , INTRODUCTION varchar(500)
  , WORK_SKILL varchar(200)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_WORK_HIS_TBL_PKC primary key (WORK_HIS_ID, APPLICANT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_WORK_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_QUA_TBL ( 
  APP_QUA_ID serial not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , QUA_NM varchar(200) not null
  , QUA_NUM varchar(200)
  , QUA_ADDRESS varchar(200)
  , ACQUISITION_DATE date
  , REMARKS varchar(200)
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_QUA_TBL_PKC primary key (APP_QUA_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_QUA_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.POSITION_ALLOWANCE_TBL ( 
  COMPANY_ID int not null
  , POSITION_ID int not null
  , ALLOWANCE_ID int not null REFERENCES anjob.ALLOWANCE_MST(ALLOWANCE_ID) ON DELETE RESTRICT
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint POSITION_ALLOWANCE_TBL_PKC primary key (COMPANY_ID, POSITION_ID, ALLOWANCE_ID)
  , constraint POSITION_ALLOWANCE_TBL_FK foreign key (COMPANY_ID, POSITION_ID) REFERENCES anjob.POSITION_TBL (COMPANY_ID, POSITION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.POSITION_ALLOWANCE_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.COMPANY_COUPON_TBL ( 
  COM_COU_ID serial not null
  , COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , COUPON_ID int not null REFERENCES anjob.COUPON_MST(COUPON_ID) ON DELETE RESTRICT
  , DEADLINE timestamp without time zone not null
  , STATUS_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COMPANY_COUPON_TBL_PKC primary key (COM_COU_ID, COMPANY_ID, COUPON_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COMPANY_COUPON_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.COMCHARGE_HIS_TBL ( 
  COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , CHARGE_ID serial not null
  , CHARGE_TIME timestamp without time zone not null
  , CHARGE_MONEY int not null
  , CHARGE_HONEY int not null
  , PAY_METHOD varchar(50) not null
  , STATUS_FLG char(1) default 0 not null
  , REMAINDER int not null
  , HONEY_LAST_DATE date not null
  , MUKOU_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COMCHARGE_HIS_TBL_PKC primary key (COMPANY_ID, CHARGE_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COMCHARGE_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.COMCONS_HIS_TBL ( 
  COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , CONS_ID serial not null
  , CONS_HONEY int not null
  , EARN_POINT int not null
  , ITEM_ID int not null REFERENCES anjob.ITEM_MST(ITEM_ID) ON DELETE RESTRICT
  , COUPON_ID int
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint COMCONS_HIS_TBL_PKC primary key (COMPANY_ID, CONS_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.COMCONS_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPLICANT_COUPON_TBL ( 
  APP_COU_ID serial not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , COUPON_ID int not null REFERENCES anjob.COUPON_MST(COUPON_ID) ON DELETE RESTRICT
  , DEADLINE timestamp without time zone not null
  , STATUS_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPLICANT_COUPON_TBL_PKC primary key (APP_COU_ID, APPLICANT_ID, COUPON_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPLICANT_COUPON_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPCHARGE_HIS_TBL ( 
  APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , CHARGE_ID serial not null
  , CHARGE_MONEY int not null
  , CHARGE_TIME timestamp without time zone not null
  , CHARGE_HONEY int not null
  , PAY_METHOD varchar(50) not null
  , STATUS_FLG char(1) default 0 not null
  , REMAINDER int not null
  , HONEY_LAST_DATE date not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPCHARGE_HIS_TBL_PKC primary key (APPLICANT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPCHARGE_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.APPCONS_HIS_TBL ( 
  APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , CONS_ID serial not null
  , CONS_HONEY int not null
  , EARN_POINT int not null
  , ITEM_ID int not null REFERENCES anjob.ITEM_MST(ITEM_ID) ON DELETE RESTRICT
  , COUPON_ID int
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint APPCONS_HIS_TBL_PKC primary key (APPLICANT_ID, CONS_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.APPCONS_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();


CREATE TABLE anjob.INTERVIEW_HIS_TBL ( 
  INTERVIEW_ID serial not null
  , COMPANY_ID int not null
  , POSITION_ID int not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , INTERVIEW_TYPE varchar(50) not null
  , TEL varchar(15) not null
  , RESPONSIBLE varchar(20) not null
  , INTERVIEW_ADDRESS varchar(50)
  , INTERVIEW_DATE date not null
  , DATE_FROM time without time zone not null
  , DATE_TO time without time zone
  , STATUS_FLG char(1) default 0 not null
  , REMARKS varchar(200)
  , USE_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint INTERVIEW_HIS_TBL_PKC primary key (INTERVIEW_ID, COMPANY_ID, POSITION_ID, APPLICANT_ID)
  , constraint INTERVIEW_HIS_TBL_FK foreign key (COMPANY_ID, POSITION_ID) REFERENCES anjob.POSITION_TBL (COMPANY_ID, POSITION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.INTERVIEW_HIS_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.TRAINING_APPL_TBL ( 
  COMPANY_ID int not null
  , TRAINING_ID int not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , COM_STATUS_FLG char(1) default 0
  , APP_STATUS_FLG char(1) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint TRAINING_APPL_TBL_PKC primary key (COMPANY_ID, TRAINING_ID, APPLICANT_ID)
  , constraint TRAINING_APPL_TBL_FK foreign key (COMPANY_ID, TRAINING_ID) REFERENCES anjob.TRAINING_INFO_TBL (COMPANY_ID, TRAINING_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.TRAINING_APPL_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.BRIEFING_APPL_TBL ( 
  COMPANY_ID int not null
  , BRIEFING_ID int not null
  , APPLICANT_ID int not null REFERENCES anjob.APPLICANT_INFO_TBL(APPLICANT_ID) ON DELETE RESTRICT
  , STATUS_FLG char(1) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint BRIEFING_APPL_TBL_PKC primary key (COMPANY_ID, BRIEFING_ID, APPLICANT_ID)
  , constraint BRIEFING_APPL_TBL_FK foreign key (COMPANY_ID, BRIEFING_ID) REFERENCES anjob.BRIEFING_INFO_TBL(COMPANY_ID, BRIEFING_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.BRIEFING_APPL_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.MESSAGE_TEXT_TBL ( 
  INTERNAL_MESSAGE_TEXT_ID serial
  , INTERNAL_MESSAGE_TEXT varchar(1000) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint MESSAGE_TEXT_TBL_PKC primary key (INTERNAL_MESSAGE_TEXT_ID)
  );

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.MESSAGE_TEXT_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.MESSAGE_TBL ( 
  INTERNAL_MESSAGE_ID serial
  , SEND_ID int
  , REC_ID int
  , SUBJECT varchar(50) not null
  , INTERNAL_MESSAGE_TEXT_ID int REFERENCES anjob.MESSAGE_TEXT_TBL(INTERNAL_MESSAGE_TEXT_ID) ON DELETE RESTRICT
  , STATUS_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint MESSAGE_TBL_PKC primary key (INTERNAL_MESSAGE_ID)
  );

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.MESSAGE_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.REPORT_TBL ( 
  REPORT_ID serial not null
  , REPORT_SECTION char(1) not null
  , TYPE_SECTION varchar(50) not null
  , COMPANY_ID int not null
  , POSITION_ID int
  , TRAINING_ID int
  , BRIEFING_ID int
  , APPLICANT_ID int not null
  , REPORT_TEXT varchar(1000) not null
  , SCREENSHOT varchar(200)
  , PROCESSING_SECTION char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint REPORT_TBL_PKC primary key (REPORT_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.REPORT_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.AD_TBL ( 
  AD_ID serial not null
  , LAYOUT_ID int not null REFERENCES anjob.LAYOUT_MST(LAYOUT_ID) ON DELETE RESTRICT
  , COMPANY_ID int not null REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  , PHOTO varchar(200) not null
  , LINK text not null
  , CONTENT varchar(20) not null
  , DATE_FROM date not null
  , DATE_TO date not null
  , DAYS int not null
  , SUM int not null
  , ONLINE_FLG char(1) default 0 not null
  , CHARGE_FLG char(1) default 0 not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint AD_TBL_PKC primary key (AD_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.AD_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.POSITION_LAN_TBL ( 
  COMPANY_ID int not null
  , POSITION_ID int not null
  , LANGUAGE_ID int not null REFERENCES anjob.LAN_MST(LANGUAGE_ID) ON DELETE RESTRICT
  , LEVEL_SECTION varchar(50) not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint POSITION_LAN_TBL_PKC primary key (COMPANY_ID, POSITION_ID, LANGUAGE_ID)
  , constraint POSITION_LAN_TBL_FK foreign key (COMPANY_ID, POSITION_ID) REFERENCES anjob.POSITION_TBL(COMPANY_ID, POSITION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.POSITION_LAN_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.RECEPTION_TBL ( 
  RECEPTION_ID serial not null
  , RECEPTION_DATE timestamp not null
  , MAIL_ADDRESS varchar(50) not null
  , PROCESSING_FLG char(1) default 0 not null
  , RECEPTION_VP timestamp not null
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint RECEPTION_TBL_PKC primary key (RECEPTION_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.RECEPTION_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();

CREATE TABLE anjob.BANK_TBL ( 
  COMPANY_ID int REFERENCES anjob.COMPANY_TBL(COMPANY_ID) ON DELETE RESTRICT
  ,BANK_ID int
  ,BANK_SECTION char(1)
  ,BANK_NAME varchar(50)
  ,BRANCH_NAME varchar(50)
  ,BRANCH_CODE int
  ,ACCOUNT_NUMBER int
  ,DEPOSIT_ITE char(1) default 0
  ,ACCOUNT_HOLDER varchar(100)
  ,ACCOUNT_HOLDER_FURI varchar(100)
  ,PASSBOOK_SYMBOL int
  ,PASSBOOK_NUMBER int
  , DEL_FLG char(1) default 0 not null
  , CREATE_TIME timestamp without time zone default CURRENT_TIMESTAMP not null
  , CREATE_BY char(20) not null
  , UPDATE_TIME timestamp without time zone default CURRENT_TIMESTAMP
  , UPDATE_BY char(20)
  , constraint BANK_TBL_PKC primary key (COMPANY_ID,BANK_ID)
);

CREATE TRIGGER "UPDATE_TIME" BEFORE UPDATE ON anjob.BANK_TBL
FOR EACH ROW
EXECUTE PROCEDURE "upd_timestamp"();