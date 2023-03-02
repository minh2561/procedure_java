package com.example.demo_get.repostory;

import com.example.demo_get.model.entity.SinhVienEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Configuration
@EnableJpaRepositories
public interface sinhVienReponstory extends JpaRepository<SinhVienEntity, Integer> {
    @Modifying
    @Transactional
    @Procedure(procedureName = "PKG_SINHVIEN.GET_SINHVIEN", refCursor = true)
    List<SinhVienEntity> getSinhVien();


    @Modifying
    @Transactional
    @Query(value = "{call PKG_SINHVIEN.INSERT_SINHVIEN(?1,?2)}", nativeQuery = true)
    void createSinhVien(String nameUser, Integer age);

    @Modifying
    @Transactional
    @Query(value = "{call PKG_SINHVIEN.DELETE_SINHVIEN(?1)}", nativeQuery = true)
    SinhVienEntity deleteSinhVien(Integer Id);



    @Modifying
    @Transactional
    @Query(value = "{call PKG_SINHVIEN.UPDATE_SINHVIEN(?1,?2,?3)}", nativeQuery = true)
    void updateSinhVien(Integer Id, String nameUser, Integer age);


//    @Modifying
//    @Transactional
//    @Procedure(name = "GET_SV")
//    List<SinhVienEntity> getSinhVienById(@Param("p_userId") Integer Id);
@Modifying
@Transactional
@Query(value = "{call PKG_SINHVIEN.GET_BY_SV(?1)}", nativeQuery = true)
void getSinhVienById(Integer Id);

}