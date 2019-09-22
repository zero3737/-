package top.zero3737.controller;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.zero3737.util.VerificationCode;

@Controller
public class VerificationCodeController {

	@RequestMapping("/getverifycode")
	public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {

		try {

			int width = 200;
			int height = 69;
			BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			VerificationCode verificationCode = new VerificationCode();
			// ���ɶ�Ӧ��ߵĳ�ʼͼƬ
			String randomText = verificationCode.drawRandomText(width, height, verifyImg);
			// ���� Session ��
			request.getSession().setAttribute("verifyCode", randomText);
			// ����������Ӧ��������ΪͼƬ������ǰ̨��ʶ��
			response.setContentType("image/png");
			// ��ȡ�ļ������
			OutputStream os = response.getOutputStream();
			// ���ͼƬ��
			ImageIO.write(verifyImg, "png", os);
			os.flush();
			os.close();//�ر���

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
