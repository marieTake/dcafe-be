package com.dcafe.order.util;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.dcafe.order.dto.DisplayOrderDetailsDTO;
import com.dcafe.order.dto.DisplayOrderedItemDTO;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(DisplayOrderDetailsDTO displayOrderDetailsDto) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(displayOrderDetailsDto.getEmail());
			messageHelper.setSubject("Order Confirmation");
			
			Context context = createEmailBody(displayOrderDetailsDto);
			messageHelper.setText(getMailBody("OrderConfirmationEmail", context), true);
			
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	//Emailに表示する注文内容を用意する
	private Context createEmailBody(DisplayOrderDetailsDTO displayOrderDetailsDto) {
		Context context = new Context();
		
		context.setVariable("customerName", displayOrderDetailsDto.getCustomerName());
		
		List<DisplayOrderedItemDTO> listOfOrderedItem = displayOrderDetailsDto.getDisplayOrderedItemDto();
		context.setVariable("orderedItems", listOfOrderedItem);
		
		context.setVariable("totalPrice", displayOrderDetailsDto.getTotalPrice());
		
		return context;
	}

	private String getMailBody(String templateName, Context context) {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(mailTemplateResolver());
		return templateEngine.process(templateName, context);
	}
	
	private ClassLoaderTemplateResolver mailTemplateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("mailtemplate/");
		templateResolver.setSuffix(".html");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(true);
		return templateResolver;
	}

}
