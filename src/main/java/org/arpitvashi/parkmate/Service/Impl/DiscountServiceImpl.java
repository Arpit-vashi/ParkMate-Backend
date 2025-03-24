package org.arpitvashi.parkmate.Service.Impl;

import org.arpitvashi.parkmate.Dto.DiscountDTO;
import org.arpitvashi.parkmate.Mapper.DiscountMapper;
import org.arpitvashi.parkmate.Model.DiscountModel;
import org.arpitvashi.parkmate.Repository.DiscountRepository;
import org.arpitvashi.parkmate.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private final DiscountRepository discountRepository;

    private final DiscountMapper discountMapper;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository, DiscountMapper discountMapper) {
        this.discountRepository = discountRepository;
        this.discountMapper = discountMapper;
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        List<DiscountModel> discounts = discountRepository.findAll();
        return discounts.stream()
                .map(discountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DiscountDTO getDiscountById(Long id) {
        DiscountModel discount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found with id: " + id));
        return discountMapper.toDTO(discount);
    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        DiscountModel discount = discountMapper.toEntity(discountDTO);
        DiscountModel savedDiscount = discountRepository.save(discount);
        return discountMapper.toDTO(savedDiscount);
    }

    @Override
    public DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO) {
        DiscountModel existingDiscount = discountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Discount not found with id: " + id));

        if (discountDTO.getCode() != null) {
            existingDiscount.setCode(discountDTO.getCode());
        }
        if (discountDTO.getDescription() != null) {
            existingDiscount.setDescription(discountDTO.getDescription());
        }
        if (discountDTO.getDiscountPercentage() != null) {
            existingDiscount.setDiscountPercentage(discountDTO.getDiscountPercentage());
        }
        if (discountDTO.getValidFrom() != null) {
            existingDiscount.setValidFrom(discountDTO.getValidFrom());
        }
        if (discountDTO.getValidTo() != null) {
            existingDiscount.setValidTo(discountDTO.getValidTo());
        }
        if (discountDTO.getCreatedAt() != null) {
            existingDiscount.setCreatedAt(discountDTO.getCreatedAt());
        }
        if (discountDTO.getUpdatedAt() != null) {
            existingDiscount.setUpdatedAt(discountDTO.getUpdatedAt());
        }

        existingDiscount.setUpdatedAt(new Date());
        DiscountModel updatedDiscount = discountRepository.save(existingDiscount);
        return discountMapper.toDTO(updatedDiscount);
    }

    @Override
    public void deleteDiscount(Long id) {
        if (!discountRepository.existsById(id)) {
            throw new RuntimeException("Discount not found with id: " + id);
        }
        discountRepository.deleteById(id);
    }



}
