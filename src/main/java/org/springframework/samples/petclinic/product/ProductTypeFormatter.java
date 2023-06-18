package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    ProductService ps;

    @Autowired
    public ProductTypeFormatter(ProductService ps) {
		this.ps = ps;
	}

    @Override
    public String print(ProductType object, Locale locale) {
    
        return object.getName();
    }

 @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType pt = ps.getProductType(text);
        if(pt == null) {
        	throw new ParseException("Product type not found", 0);
        }
        return pt;
    }
    
}
    
    
