package com.example.dine_in_order_api.utility;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextFontContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
@Component
public class BillGenerator {

    private final TemplateEngine templateEngine;

    public byte[] generatePdf(String s, Map<String, Object> bill) throws IOException {

        Context context = new Context();
        context.setVariables(bill);
        String htmlContext =  templateEngine.process(s,context);

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContext);
            renderer.layout();
            renderer.createPDF(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }
}
