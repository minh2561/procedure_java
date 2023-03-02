create
or replace NONEDITIONABLE PACKAGE PKG_SINHVIEN AS

        TYPE ref_cursor IS REF CURSOR;

        PROCEDURE GET_SINHVIEN(
            v_cursor OUT ref_cursor
        );

        PROCEDURE INSERT_SINHVIEN(
            p_nameUser SINHVIEN.nameUser%TYPE,
            p_age SINHVIEN.age%TYPE
        );

        PROCEDURE UPDATE_SINHVIEN(
            p_userId SINHVIEN.userId%TYPE,
            p_nameUser SINHVIEN.nameUser%TYPE,
            p_age SINHVIEN.age%TYPE
        );

        PROCEDURE DELETE_SINHVIEN(
            p_userId SINHVIEN.userId%TYPE
        );


        PROCEDURE GET_BY_SV(
            p_userId SINHVIEN.userId%TYPE , v_cursor out ref_cursor
        );
END PKG_SINHVIEN;

    create or replace NONEDITIONABLE package BODY PKG_SINHVIEN AS
        PROCEDURE INSERT_SINHVIEN(
            p_nameUser SINHVIEN.nameUser%TYPE,
            p_age SINHVIEN.age%TYPE)
        AS
BEGIN
INSERT INTO SINHVIEN(USERID, NAMEUSER, AGE)
VALUES (SINHVIEN_1.nextval, p_nameUser, p_age);
END INSERT_SINHVIEN;

        PROCEDURE GET_SINHVIEN(V_CURSOR OUT REF_CURSOR)
AS
BEGIN
OPEN V_CURSOR FOR SELECT * FROM SINHVIEN;
END GET_SINHVIEN;


        PROCEDURE DELETE_SINHVIEN(p_userId SINHVIEN.userId%TYPE)
AS
BEGIN
            DELETE
SINHVIEN WHERE userId = p_userId ;
END DELETE_SINHVIEN;


        PROCEDURE UPDATE_SINHVIEN(
            p_userId SINHVIEN.userId%TYPE,
            p_nameUser SINHVIEN.nameUser%TYPE,
            p_age SINHVIEN.age%TYPE)
AS
BEGIN
UPDATE SINHVIEN
SET nameUser=p_nameUser,
    age=p_age
WHERE userId = p_userId;

END UPDATE_SINHVIEN;

        PROCEDURE GET_BY_SV(p_userId SINHVIEN.userId%TYPE, v_cursor out ref_cursor)
AS
BEGIN
open v_cursor for
SELECT *
FROM SINHVIEN
where USERID = p_userId;
END GET_BY_SV;
END PKG_SINHVIEN ;

call PKG_SINHVIEN.INSERT_SINHVIEN('minh',30)