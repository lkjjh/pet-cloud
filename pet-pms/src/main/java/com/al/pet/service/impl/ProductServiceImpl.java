package com.al.pet.service.impl;

import com.al.pet.mapper.*;
import com.al.pet.model.condition.SearchCondition;
import com.al.pet.model.dto.DetailCategoryDto;
import com.al.pet.model.dto.DetailSpuDto;
import com.al.pet.model.dto.SkuDto;
import com.al.pet.model.dto.SkuPicDto;
import com.al.pet.model.pojo.*;
import com.al.pet.model.vo.DetailVo;
import com.al.pet.model.vo.SearchVo;
import com.al.pet.service.ProductService;
import com.al.pet.util.StringUtils;
import com.alibaba.nacos.common.utils.Objects;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author al
 * @version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private ProductAttributeRelMapper productAttributeRelMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Autowired
    private SkuPicMapper skuPicMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private ProductDetailPicMapper productDetailPicMapper;

    @Override
    public SearchVo search(SearchCondition condition) {
        String order = getOrder(condition.getSort());
        LambdaQueryWrapper<Spu> wrapper = new QueryWrapper<Spu>()
                .orderByDesc(StringUtils.notNull(order), order)
                .lambda()
                .like(StringUtils.notNull(condition.getKeyword()), Spu::getName, condition.getKeyword())
                .eq(Objects.nonNull(condition.getBrandId()), Spu::getBrandId, condition.getBrandId())
                .eq(Objects.nonNull(condition.getProductLevel1CategoryId()), Spu::getCid1, condition.getProductLevel1CategoryId())
                .eq(Objects.nonNull(condition.getProductLevel2CategoryId()), Spu::getCid2, condition.getProductLevel2CategoryId());

        List<Integer> ids = condition.getProductAttributeIds();
        if (Objects.nonNull(ids) && !ids.isEmpty()) {
            List<Long> list = productAttributeRelMapper.selectBatchIds(ids)
                    .stream()
                    .map(PmsProductAttributeRel::getSpuId)
                    .collect(Collectors.toList());
            wrapper.in(!list.isEmpty(), Spu::getId, list);
        }

        Page<Spu> page = new Page<>(condition.getPageNo(), condition.getPageSize());
        spuMapper.selectPage(page, wrapper);
        return SearchVo.build(page);
    }

    @Override
    public DetailVo detail(Long spuId) {
        Spu spu = spuMapper.selectById(spuId);
        List<PmsProductDetailPic> picList = productDetailPicMapper.selectList(new LambdaQueryWrapper<PmsProductDetailPic>()
                .eq(PmsProductDetailPic::getSpuId, spuId));

        List<PmsSku> skus = skuMapper.selectList(new LambdaQueryWrapper<PmsSku>()
                .eq(PmsSku::getSpuId, spuId));
        List<SkuDto> list = skus.stream()
                .map(sku -> {
                    List<SkuPicDto> pics = skuPicMapper.selectList(new LambdaQueryWrapper<PmsSkuPic>()
                                    .eq(PmsSkuPic::getSkuId, sku.getId()))
                            .stream()
                            .map(SkuPicDto::build)
                            .collect(Collectors.toList());
                    SkuDto build = SkuDto.build(spu, sku);
                    build.setSkuPicList(pics);
                    return build;
                })
                .collect(Collectors.toList());

        List<DetailCategoryDto> detailCategoryDtos = productCategoryMapper.selectBatchIds(Arrays.asList(spu.getCid1(), spu.getCid2()))
                .stream()
                .map(DetailCategoryDto::build)
                .collect(Collectors.toList());
        return DetailVo.build(DetailSpuDto.build(spu, picList), list, detailCategoryDtos);
    }

    private String getOrder(Integer order) {
        if (Objects.isNull(order)) {
            return "";
        }
        return order == 2
                ? "sale"
                : "comment_amount";
    }

}
