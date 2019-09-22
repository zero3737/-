package top.zero3737.cmsservice;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.zero3737.dao.ZyNbzCmsMapper;
import top.zero3737.entity.ZyNbzCms;
import top.zero3737.entity.ZyNbzCmsExample;
import top.zero3737.util.GetUUID;

@Service
public class CMSService {
	
	@Autowired
	private ZyNbzCmsMapper zyNbzCmsMapper;
	
	public void addContent(Map<String, String> param) {
		
		ZyNbzCms zyNbzCms = new ZyNbzCms();
		
		try {
			
			zyNbzCms.setId(new GetUUID().get());
			zyNbzCms.setTemplateType(param.get("template-type"));
			zyNbzCms.setTitle(param.get("title"));
			zyNbzCms.setBody(param.get("content"));
			zyNbzCms.setImagePath(param.get("imageUrl"));
			zyNbzCms.setCreateTime(new Date());
			zyNbzCmsMapper.insert(zyNbzCms);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public List<ZyNbzCms> findContent() {
		
		ZyNbzCmsExample zyNbzCmsExample = new ZyNbzCmsExample();
		
		List<ZyNbzCms> selectByExample = zyNbzCmsMapper.selectByExample(zyNbzCmsExample);
		
		return selectByExample;
		
	}

}
