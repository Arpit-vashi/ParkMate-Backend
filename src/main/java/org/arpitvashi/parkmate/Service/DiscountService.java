package org.arpitvashi.parkmate.Service;

import org.arpitvashi.parkmate.Dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    DiscountDTO createDiscount(DiscountDTO discount);

    List<DiscountDTO> getAllDiscounts();

    DiscountDTO getDiscountById(Long id);

    DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO);

    void deleteDiscount(Long id);

}
