package top.zero3737.controller;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import top.zero3737.cmsservice.CMSService;
import top.zero3737.config.Config;
import top.zero3737.util.FileUpload;
import top.zero3737.util.GetMap;

@Controller
public class CMSController {

	@Autowired
	private CMSService cmsService;
	@Autowired
	private Config config;
	
	@RequestMapping(value= {"/addcontent"})
	@ResponseBody
	public String addContent(@RequestParam Map<String,String> param, @RequestParam("file")MultipartFile[] files) {
		
		Map<String, String> map = new HashedMap();
		
		try {
			
			if(param.get("imageUrl") == null) {
				
				param.put("imageUrl", new FileUpload().saveFile(files, "/images"));
				
			}
			cmsService.addContent(param);
			map = new GetMap().getSuccess("上传成功");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			map = new GetMap().getSuccess("上传失败");
			
		}
		
		return JSON.toJSONString(map);
		
	}
	
	@RequestMapping(value= {"/findcontent"})
	@ResponseBody
	public String findContent() {
		
		return JSON.toJSONString(cmsService.findContent());
		
	}
	
}
