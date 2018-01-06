package com.xsm.flat;


import com.xsm.flat.dao.ProvinceMapper;
import com.xsm.flat.entity.City;
import com.xsm.flat.entity.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlatApplication.class)
@ActiveProfiles(value="dev")
@EnableTransactionManagement
public class ProvinceTest {

    @Autowired
    ProvinceMapper provinceMapper;

    @Test
    public void selectUserById(){
        List<Province> provinceList = provinceMapper.selectProvince();
        for (Province province: provinceList
             ) {
            System.out.println(province.getpName());
            for (City city: province.getCities()
                 ) {
                System.out.println(city.getcName());

            }
        }
    }
}
