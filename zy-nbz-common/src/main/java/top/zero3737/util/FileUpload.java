package top.zero3737.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	// savePath �������磺/images
	public String saveFile(MultipartFile[] files, String savePath) {

		String format = null;
		String fileName = null;
		
		try {
			
			for (MultipartFile file : files) {
				
				// ��ȡʱ��
				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("/yyyy/MM/dd");
				format = sdf.format(new Date());
				// ��ȡ�ļ���
				String originalFilename = file.getOriginalFilename();
				// ��ʱ�����Ϊ�ļ���
				fileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
				// ��ȡ��Ŀ·��
				String realPath = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
				// ��ȡ webapp ·��
				String parent = new File(realPath).getParent();
				File _file = new File(parent + savePath + format + "/" + fileName);
				// �ļ�·���������ڴ���
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
