package com.example.demo_get.service.implement;

import com.example.demo_get.mapper.sinhVienMapper;
import com.example.demo_get.model.dto.sinhVienDto;
import com.example.demo_get.model.entity.SinhVienEntity;
import com.example.demo_get.model.in.sinhVienIn;
import com.example.demo_get.repostory.sinhVienReponstory;
import com.example.demo_get.service.sinhVienService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// hien thuc interface
@Component
@Transactional
@Service
public class sinhVienServerImplement implements sinhVienService{
    // chien khai phuong thuc
    @Autowired
    // gọi thành bin mình muốn lấy để xử lý

    private sinhVienReponstory sinhVienReponstory;

    @Override
    public List<sinhVienDto> getAll() {
        List<SinhVienEntity> list = sinhVienReponstory.getSinhVien();
        List<sinhVienDto> listDto = list.stream().map(sinhVienMapper::map1).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(listDto);
        return listDto;
    }

    @Override
    public Map<String, Object> create(sinhVienIn sinhVienIn) {
        sinhVienReponstory.createSinhVien(sinhVienIn.getNameUser(), sinhVienIn.getAge());
        Map<String, Object> respont = new HashMap<>();
        respont.put("result", "them thành công");
        return respont;
    }

    @Procedure
    @Override
    public Map<String, Object> delete(Integer Id) {
        SinhVienEntity sinhvienEntity = sinhVienReponstory.deleteSinhVien(Id);
        sinhVienReponstory.deleteSinhVien(sinhvienEntity.getId());
        Map<String, Object> respont = new HashMap<>();
        respont.put("result", "xóa thành công");
        return respont;
    }

    @Procedure
    @Override
    public Map<String, Object> update(Integer Id, sinhVienIn sinhVienIn) {
        sinhVienReponstory.updateSinhVien(Id, sinhVienIn.getNameUser(), sinhVienIn.getAge());
        Map<String, Object> respont = new HashMap<>();
        respont.put("result", "update thành công");
        return respont;
    }

    @PersistenceContext
    private EntityManager entityManager;
    public Map<String, Object> getById(String Id) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("PKG_SINHVIEN.GET_BY_SV")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, void.class, ParameterMode.REF_CURSOR)
                .setParameter(1, Id);

        List<Object[]> resultList = storedProcedure.getResultList();
        Map<String, Object> result1 = new HashMap<>();
        List<sinhVienDto> sinhVienDtos = new ArrayList<>();
        sinhVienDto sinhVienDto = null;

//        Map<String, Object> result = new HashMap<>();

//        for (Object[] result : resultList) {

//            BigDecimal idDecimal = (BigDecimal) result[0];
//            Integer id = idDecimal.toBigInteger().intValue();
//
//            BigDecimal ageDecimal = (BigDecimal) result[2];
//            Integer age = ageDecimal.toBigInteger().intValue();
//
//            sinhVienDto = new sinhVienDto();
//            sinhVienDto.setId(id);
//            sinhVienDto.setNameUser((String) result[1]);
//            sinhVienDto.setAge(age);
//            sinhVienDtos.add(sinhVienDto);
//        }

        result1.put("data", storedProcedure.getOutputParameterValue(2));
//        result1.put("data2",resultList);

        return result1;




//        List<sinhVienDto> sinhVienDtos = new ArrayList<>();
//        List<?> resultList = storedProcedure.getResultList();
////
//        List<SinhVienEntity> companyList = resultList.stream().map(o -> new SinhVienEntity((Integer) o[0], (String) o[1], (Integer) o[2])).collect(Collectors.toList());
////
////        List<SinhVienEntity> list = storedProcedure.getResultList().stream().map(o -> (SinhVienEntity) o).collect(Collectors.toList());
////
//////        List<SinhVienEntity> list = resultValue.;
////
//////        sinhVienDto listDto = modelMapper.map(sinhVienEntity,sinhVienDto.class);
////
////        List<sinhVienDto> listDtos = resultList.stream().map(sinhVienMapper::map1).collect(Collectors.toList());
//
////        String code= (String)storedProcedure.getOutputParameterValue(2);
//        System.out.println(resultList + " ket qua");
//        return null;
    }




    @Override
    public List<sinhVienDto> getPaginate(sinhVienIn sinhVienIn) {

        Integer ativePage = sinhVienIn.getActivePage();
        Integer limit1 = sinhVienIn.getLimit();
        Integer limitSkip = ativePage * limit1;

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("PKG_SINHVIEN.PAGINATE")
                .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, void.class, ParameterMode.REF_CURSOR)
                .registerStoredProcedureParameter(2, Integer.class, ParameterMode.OUT)
                .setParameter(1, limitSkip);
        storedProcedure.execute();


        Integer totalPagePaginate = (Integer) storedProcedure.getOutputParameterValue(2);
        System.out.println(totalPagePaginate + " totalPagePaginate");
//        double skip  = Math.ceil((ativePage - 1) * limit);
//        double totalPage = Math.ceil(totalPagePaginate / limit);


        List<Object[]> resultList = storedProcedure.getResultList();
        List<sinhVienDto> sinhVienDtos = new ArrayList<>();
        sinhVienDto sinhVienDto = null;
        for (Object[] result : resultList) {

            BigDecimal idDecimal = (BigDecimal) result[0];
            Integer id = idDecimal.toBigInteger().intValue();

            BigDecimal ageDecimal = (BigDecimal) result[2];
            Integer age = ageDecimal.toBigInteger().intValue();

            sinhVienDto = new sinhVienDto();
            sinhVienDto.setId(id);
            sinhVienDto.setNameUser((String) result[1]);
            sinhVienDto.setAge(age);
            sinhVienDtos.add(sinhVienDto);

        }

        return sinhVienDtos;
    }


}

