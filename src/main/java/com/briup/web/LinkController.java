package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Link;
import com.briup.exception.CustomerException;
import com.briup.service.ILinkService;
import com.briup.util.Message;
import com.briup.util.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/link")
@Api(description="连接接口")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	@PutMapping("/saveOrUpdate")
	@ApiOperation("更新保存信息")
	public  Message<String>saveOrUpdate(Link link){
		linkService.saveOrUpdate(link);
		return MessageUtil.success("保存成功");
	}
	@GetMapping("/finAll")
	@ApiOperation("查询所有的链接信息")
	public  Message<List<Link>>findAll(){
		List<Link> linklist=linkService.findAll();
		return MessageUtil.success(linklist);
	}
	@GetMapping("/findById")
	@ApiOperation("根据id查询所有的链接信息")
	@ApiImplicitParam(name="id",value="链接id",required = true,paramType = "query",dataType = "int")
	public Message<Link>findById(Integer id){
		Message<String>deteleById=null;
		try {
			Link link=linkService.findById(id);
			return MessageUtil.success(link);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return MessageUtil.error(500, "id is not");
		}
			
		
	}
	@GetMapping("/deteleById")
	@ApiOperation("删除链接信息")
	@ApiImplicitParam(name="id",value="链接id",required = true,paramType = "query",dataType = "int")
	public Message<String>deteleById(Integer id){
		Message<String>deteleById=null;
		try {
			linkService.deleteById(id);
			return MessageUtil.success("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return MessageUtil.error(500, "id is not");
		}
	}
}
