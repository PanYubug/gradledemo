package com.panyu.restful;


import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by mfns on 2018/9/28.
 */
@Path("hello")
public class Demo1 {
    /**
     * 响应字符串
     * @param name
     * @return
     */
    @GET
    @Path("/sayHi")
    public String sayHi(@QueryParam("name") String name){
        System.out.println(name);
        return "hello world "+name;
    }
    /**
    响应体进行响应
    */
    @GET
    @Path("/hi")
    public Response hi(@QueryParam("name") String name){
        JSONObject json = new JSONObject();
        json.put("hello",name);
        json.put("msg","welcome to jersey world");
        return Response.status(Response.Status.OK).entity(json.toString()).build();
    }
}
