package top.zero3737.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	// savePath 参数例如：/images
	public String saveFile(MultipartFile[] files, String savePath) {

		String format = null;
		String fileName = null;
		
		try {
			
			for (MultipartFile file : files) {
				
				// 获取时间
				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("/yyyy/MM/dd");
				format = sdf.format(new Date());
				// 获取文件名
				String originalFilename = file.getOriginalFilename();
				// 以时间戳作为文件名
				fileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
				// 获取项目路径
				String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
				// 获取 webapp 路径
				String parent = new File(realPath).getParent();
				File _file = new File(parent + savePath + format + "/" + fileName);
				// 文件路径不存在在创建
				if(!_file.exists()) {
					
					_file.mkdirs();
					
				}
				file.transferTo(_file);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return savePath + format + "/" + fileName;
		
	}
	
}
