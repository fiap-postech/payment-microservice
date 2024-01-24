package br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.ComboEntity;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.ProductEntity;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PurchaseItemEntity;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static java.util.Objects.isNull;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public abstract class DBPurchaseItemMapper {

    @Autowired
    private DBComboProductMapper comboProductMapper;

    @Autowired
    private DBSingleProductMapper singleProductMapper;

    @Mapping(target = "product", source = "source", qualifiedByName = "getProductEntity")
    @Mapping(target = "purchase", ignore = true)
    public abstract PurchaseItemEntity toEntity(PurchaseItemDTO source);

    @Mapping(target = "fullPrice", source = "source", qualifiedByName = "getPrice")
    @Mapping(target = "product", source = "source", qualifiedByName = "getProduct")
    public abstract PurchaseItemDTO toDTO(PurchaseItemEntity source);

    @Named("getPrice")
    BigDecimal getPrice(PurchaseItemEntity entity) {
        return entity.getProduct().getPrice();
    }

    @Named("getProductEntity")
    ProductEntity getProductEntity(PurchaseItemDTO purchaseItem) {
        var product = purchaseItem.getProduct();
        var uuid = product.getId();

        var productEntity = new ProductEntity();

        productEntity.setUuid(uuid);
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setImage(product.getImage());
        productEntity.setCategory(product.getCategory());
        productEntity.setEnabled(product.getEnabled());

        return productEntity;
    }

    @Named("getProduct")
    ProductDTO getProduct(PurchaseItemEntity purchaseItemEntity) {
        var productEntity = purchaseItemEntity.getProduct();

        if (isNull(productEntity)) return null;

        if (productEntity instanceof ComboEntity comboEntity){
            return comboProductMapper.toDTO(comboEntity);
        }

        return singleProductMapper.toDTO(productEntity);
    }
}
