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
			// 生成对应宽高的初始图片
			String randomText = verificationCode.drawRandomText(width, height, verifyImg);
			// 保存 Session 中
			request.getSession().setAttribute("verifyCode", randomText);
			// 必须设置响应内容类型为图片，否则前台不识别
			response.setContentType("image/png");
			// 获取文件输出流
			OutputStream os = response.getOutputStream();
			// 输出图片流
			ImageIO.write(verifyImg, "png", os);
			os.flush();
			os.close();//关闭流

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
