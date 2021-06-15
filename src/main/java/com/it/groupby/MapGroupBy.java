package com.it.groupby;

import com.it.pojo.Company;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 利用java新特性
 *
 * @author Lyle
 * @date 2021/6/13
 */
public class MapGroupBy {
    public static void main(String[] args) {
        // 测试分组
        List<Company> companyList=new ArrayList<>();
        companyList.add(new Company("财务部",1,"张三"));
        companyList.add(new Company("财务部",2,"李四"));
        companyList.add(new Company("采购部",1,"王五"));
        companyList.add(new Company("采购部",2,"马六"));
        companyList.add(new Company("采购部",3,"田七"));
        companyList.add(new Company("人力资源部",1,"候八"));
        companyList.add(new Company("人力资源部",2,"金九"));
        companyList.add(new Company("人力资源部",3,"银十"));
        companyList.add(new Company("人力资源部",4,"十一"));
        Map<String, List<Company>> companyListMap = groupby(companyList);
        System.out.println("分组后的Map大小是："+companyListMap.size());

    }

    public static Map<String, List<Company>> groupby(List<Company> list){
        // 按照公司部门进行分组
        Map<String, List<Company>> listMap=null;
        if (!CollectionUtils.isEmpty(list)){
            listMap = list.stream().collect(Collectors.groupingBy(Company::getDepartment));
        }
        return listMap;
    }
}
