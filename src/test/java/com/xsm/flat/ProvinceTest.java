package com.xsm.flat;


import com.xsm.flat.dao.CityMapper;
import com.xsm.flat.dao.ProvinceMapper;
import com.xsm.flat.dao.StreetMapper;
import com.xsm.flat.entity.City;
import com.xsm.flat.entity.Province;
import com.xsm.flat.entity.Street;
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

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private StreetMapper streetMapper;

    @Test
    public void selectUserById(){
        String pro ="";
        String str ="";
        String citys ="";
        List<Province> provinceList = provinceMapper.selectProvince();
        for (Province province: provinceList
             ) {
                    pro = province.getpName() + pro;

            List<City> cityList = cityMapper.selectByPId(province.getpId());
            for (City city: cityList
                 ) {

                citys = city.getcName() + citys;
                List<Street> streetList = streetMapper.selectByCId(city.getcId());

                for (Street street: streetList
                     ) {
                    str = street.getsName()+str;
                }

            }
        }
        System.out.println("省："+pro+"\n"+"市："+citys+"\n"+"街道："+str);
    }


}
