package com.willi.wl.web;

import com.willi.wl.bean.User;
import com.willi.wl.service.UserService;
import com.willi.wl.utils.ResponseUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.xml.ws.Response;
import java.util.*;


/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/15 14:42
 **/
@Transactional
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //创建线程安全的map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    /**
     *根据用户id查询
     * @param id
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据用户id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping(value = "user/findById")
    public @ResponseBody ResponseUtil getUserById(@RequestParam(value = "id") Integer id) {

        try{
            User user = userService.getUserById(id);
            ResponseUtil responseUtil = ResponseUtil.ok();
            responseUtil.putReponseData("success", user);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 根据用户usernam查询
     * @param username
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据用户username来获取用户详细信息")
    @ApiImplicitParam(name = "username" , value = "用户名", required = true, dataType = "String" , paramType = "value")
    @GetMapping(value = "user/findByName")
    public @ResponseBody ResponseUtil getUserByName(@RequestParam(value = "username") String username) {

        try {
            User user = userService.getUserByName(username);
            ResponseUtil responseUtil = ResponseUtil.ok();
            responseUtil.putReponseData("success", user);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 根据用户名和密码来查找用户
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "查找用户", notes = "根据用户名和密码来查找用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping(value = "user/findByNameAndPass")
    public @ResponseBody ResponseUtil getUserByNameAndPass(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        try {
            User user = userService.getUserByNameAndPass(username, password);
            ResponseUtil responseUtil = ResponseUtil.ok();
            responseUtil.putReponseData("success", user);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 查询用户列表
     * @return
     */
    @ApiOperation(value = "获取全部用户信息", notes = "获取用户列表")
    @GetMapping(value = "user/findAll")
    public @ResponseBody ResponseUtil getUserList() {

        try{
            List<User> users = userService.getUserList();
            ResponseUtil responseUtil = ResponseUtil.ok();
            responseUtil.putReponseData("success", users);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }


    /**
     * 根据email查找用户
     * @param email
     * @return
     */
    @ApiOperation(value= "查找用户" , notes = "根据email查找用户")
    @ApiImplicitParam(name = "email" , value = "邮箱", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "user/findByEmail")
    public @ResponseBody ResponseUtil getUserByEmail(@RequestParam(value = "email") String email) {

        try {
            User user = userService.getUserByEmail(email);
            ResponseUtil responseUtil = ResponseUtil.ok();
            responseUtil.putReponseData("success", user);
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据用户user对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value = "user/add")
    public @ResponseBody ResponseUtil add(@RequestBody User user) {

        System.out.println("---------------------------add-----------------------");
        user.setUser_id(UUID.randomUUID().toString());
        System.out.println(user);

        try{
            int orderID = userService.add(user);
            System.out.print(orderID);
            ResponseUtil responseUtil = ResponseUtil.ok();
            if (orderID < 0) {
                responseUtil.putReponseData("fail", user);
            } else {
                responseUtil.putReponseData("success", user);
            }
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 根据用户id删除
     * @param id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long", paramType = "path")
    @DeleteMapping(value = "user/deleteById")
    public @ResponseBody ResponseUtil delete(@RequestParam(value = "id") Integer id) {

        try {
            int ret = userService.delete(id);
            ResponseUtil responseUtil = ResponseUtil.ok();
            if (ret == 0) {
                responseUtil.putReponseData("fail", ret);
            } else {
                responseUtil.putReponseData("success", ret);
            }
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 根据用户username删除
     * @param username
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据username来指定删除用户")
    @ApiImplicitParam(name = "username", value = "用户username", required = true, dataType = "String", paramType = "path")
    @DeleteMapping(value = "user/deleteByName")
    public @ResponseBody ResponseUtil deleteByName(@RequestParam(value = "username") String username) {

        try {
            int ret = userService.deleteByName(username);
            ResponseUtil responseUtil = ResponseUtil.ok();
            if (ret == 0) {
                responseUtil.putReponseData("fail", ret);
            } else {
                responseUtil.putReponseData("success", ret);
            }
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }



    /**
     * 根据用户id来更改信息
     * @param id
     * @param user
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据用户的id来指定更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "user/updateById")
    public @ResponseBody ResponseUtil update(@RequestParam(value = "id") Integer id, @RequestBody User user) {

        try{
            int ret = userService.update(id, user);
            ResponseUtil responseUtil = ResponseUtil.ok();
            if (ret == 0) {
                responseUtil.putReponseData("fail", ret);
            } else {
                responseUtil.putReponseData("success", ret);
            }
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

    /**
     * 根据用户username来更改信息
     * @param username
     * @param user
     * @return
     */
    @ApiOperation(value = "更新信息", notes = "根据用户的username来指定更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户username", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping(value = "user/updateByName")
    public @ResponseBody ResponseUtil updateByName(@RequestParam(value = "username", required = true) String username, @RequestBody User user) {

        try {
            int ret = userService.updateByName(username, user);
            ResponseUtil responseUtil = ResponseUtil.ok();
            if (ret == 0) {
                responseUtil.putReponseData("fail", ret);
            } else {
                responseUtil.putReponseData("success", ret);
            }
            return responseUtil;
        } catch (Exception e) {
            ResponseUtil responseUtil = ResponseUtil.serverInternalError();
            responseUtil.putReponseData("error", e.getClass());
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseUtil;
        }
    }

}
