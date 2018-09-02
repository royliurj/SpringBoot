package com.roy.springbootcache.service;

import com.roy.springbootcache.bean.Employee;
import com.roy.springbootcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的结果进行缓存；以后在访问相同的数据，直接从缓存中获取；
     *
     * CacheManager管理多个Cache组件，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件又自己唯一一个名字
     * 属性：
     *      cacheNames/value；指定缓存组件的名字
     *      key：缓存数据时的key，默认使用方法参数的值
     *          编写SpEL：#id、#a0、#p0、#root.args[0]
     *      keyGenerator：key生成器；可以自己指定key的生成器
     *          key/keyGenerator 二选一
     *      cacheManager：指定缓存管理器；或者指定缓存解析器cacheResolver 二选一
     *      condition：指定符合条件的情况下才缓存
     *      unless：否定缓存，当unless指定的条件为true，则方法的返回值不会被缓存，可以获取到结果进行判断
     *      sync：是否使用异步
     *
     * 原理：
     * 1，自动配置类CacheAutoConfiguration
     * 2，缓存配置类
     * 3，默认配置类：SimpleCacheConfiguration
     * 4，ConcurrentMapCacheManager
     * 运行流程：
     * 1，方法运行前，先去查询cache，按照cachenames指定的名字获取，没有的话会创建一个cache
     * 2，去cache中查找缓存的内容，使用一个key（是按照某种策略生成的，默认使用SimpleKeyGenerator生成），默认是方法的参数。
     * 3，没有查到缓存，就调用目标方法
     * 4，将方法结果放进缓存中
     */
    //key = getEmp[id]  key = "#root.methodName+'[' + #id +']'"
    //keyGeneratory keyGenerator = "myKeyGenerator"
    @Cacheable(cacheNames = "emp", condition = "#id > 0", unless = "#id ==2")
    public Employee getEmp(Integer id){
        System.out.println("search " + id + " employee");
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }

    /**
     * @CachePut ： 即调用方法，又更新缓存数据；
     * 修改了数据库的数据库，同时更新缓存
     */
    @CachePut(cacheNames = "emp", key = "#employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * @CacheEvict 删除缓存
     * allEntries=true 清除所有的缓存
     * beforeInvocation = false 缓存的清除是否在方法之前执行
     */
    @CacheEvict( cacheNames = "emp", key = "#id")
    public void deleteEmp(Integer id){

        employeeMapper.deleteEmpById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp", key = "#result.id"),
                    @CachePut(value = "emp", key = "#result.email")
            },
            evict = {
                    @CacheEvict(value = "emp", key = "#lastName")
            }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
