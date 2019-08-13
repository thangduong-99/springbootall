package com.congthang.validator;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.congthang.dto.ProductInfo;
import com.congthang.entity.Product;
import com.congthang.service.ProductService;

@Component
public class ProductFormValidator implements Validator {

  @Autowired
  private ProductService productService;

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz == ProductInfo.class;
  }

  @Override
  public void validate(Object target, Errors errors) {
    ProductInfo productInfo = (ProductInfo) target;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productId",
        "NotEmpty.productInfo.productId");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productInfo.name");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productInfo.price");

    Long productId = productInfo.getProductId();
    if (productId != null && productId > 0) {
      Optional<Product> product = productService.findProductById(productId);
      if (product != null) {
        errors.rejectValue("productId", "Duplicate.productInfo.productId");
      }

    }
  }
}


