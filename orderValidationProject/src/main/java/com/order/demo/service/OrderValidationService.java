package com.order.demo.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.demo.model.Order;
import com.order.demo.xml.OrderXmlValidator;

@Service
public class OrderValidationService {

    @Autowired
    private OrderXmlValidator orderXmlValidator;

    public boolean validateOrder(Order order) {
        // Validate XML content against XSD
        String xmlContent = convertOrderToXml(order);
        return orderXmlValidator.validateXml(xmlContent);
    }

    private String convertOrderToXml(Order order) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(order, writer);

            return writer.toString();
        } catch (JAXBException e) {
            // Handle JAXB exception
            e.printStackTrace();
            return null;
        }
    }
}